package com.leetcode;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/

/**
 * Created a linked list of FrequencyBucket nodes to keep track of the frequency of elements.
 * The FrequencyBucket node has a set of elements that have the same frequency.
 * Also created a map to keep track of the element to FrequencyBucket node mapping.
 * When a element is encountered again, it is moved to the next FrequencyBucket node.
 * If any FrequencyBucket node is empty, it is removed from the linked list.
 * We keep the head of the linked list to get the elements with the highest frequency.
 * Time complexity: O(n) to create the linked list and O(k) to get the top k elements.
 * Space complexity: O(# of unique elements) to store the elements in the linked list.
 *
 * We could have split the for loop into two parts:
 * <ol>
 *  <li>To create the map</li>
 *  <li>To create the linked list</li>
 *  </ol>
 *
 * Other easy solution could have been to use a HashMap to keep track of the frequency of elements.
 * Then use array of count to List<Integer> of elements.
 * This is a bucket sort approach and very similar to linked list.
 * The difference is that the elements with no data are not removed and it is an array and not linked list.
 * Time complexity: O(n) to create the hashmap and O(k) to get the top k elements.
 * Space complexity: O(n) to store the elements in the array.
 *
 */

public class TopKFrequentElements {


    class FrequencyBucket {
        FrequencyBucket previous;
        FrequencyBucket next;
        int frequency;
        Set<Integer> elementToFrequency = new HashSet<>();

        FrequencyBucket(int frequency) {
            this.frequency = frequency;
        }

        public boolean isEmpty() {
            return elementToFrequency.isEmpty();
        }

        public boolean hasImmediateNextFrequencyBucket() {
            return this.next != null && this.next.frequency == (this.frequency + 1);
        }

        public int[] getElements() {
            return elementToFrequency.stream().mapToInt(i -> i).toArray();
        }

        public FrequencyBucket moveToNextFrequencyBucket(int element) {
            FrequencyBucket immediateNextFrequencyBucket = this.next;
            if (!hasImmediateNextFrequencyBucket()) {
                immediateNextFrequencyBucket = new FrequencyBucket(frequency + 1);
                immediateNextFrequencyBucket.next = this.next;
                immediateNextFrequencyBucket.previous = this;
                if (this.next != null) {
                    this.next.previous = immediateNextFrequencyBucket;
                }
                this.next = immediateNextFrequencyBucket;
            }
            immediateNextFrequencyBucket.elementToFrequency.add(element);
            this.elementToFrequency.remove(element);
            return immediateNextFrequencyBucket;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, FrequencyBucket> numberToNode = new HashMap<>();
        FrequencyBucket firstFrequencyBucket = createFirstNode();
        FrequencyBucket head = firstFrequencyBucket;

        for (int element : nums) {
            FrequencyBucket newFrequencyBucket;
            if (numberToNode.containsKey(element)) {
                FrequencyBucket currentFrequencyBucket = numberToNode.get(element);
                newFrequencyBucket = moveToNextFrequencyBucket(element, currentFrequencyBucket, numberToNode);
                removeNodeIfNeeded(currentFrequencyBucket);
            } else {
                newFrequencyBucket = moveToNextFrequencyBucket(element, firstFrequencyBucket, numberToNode);
            }
            if (newFrequencyBucket.frequency > head.frequency) {
                head = newFrequencyBucket;
            }
        }

        int [] result = new int[k];
        for (int i = 0; i < k; ) {
            int[] elements = head.getElements();
            for (int element : elements) {
                result[i++] = element;
            }
            head = head.previous;
        }
        return result;
    }

    private FrequencyBucket moveToNextFrequencyBucket(int element, FrequencyBucket currentFrequencyBucket, Map<Integer, FrequencyBucket> numberToNode) {
        FrequencyBucket newFrequencyBucket = currentFrequencyBucket.moveToNextFrequencyBucket(element);
        numberToNode.put(element, newFrequencyBucket);
        return newFrequencyBucket;
    }

    private static void removeNodeIfNeeded(FrequencyBucket frequencyBucket) {
        boolean isRootBucket = frequencyBucket.frequency == 0;
        if (frequencyBucket.isEmpty() && !isRootBucket) {
            if (frequencyBucket.previous != null) {
                frequencyBucket.previous.next = frequencyBucket.next;
            }
            if (frequencyBucket.next != null) {
                frequencyBucket.next.previous = frequencyBucket.previous;
            }
        }
    }

    private FrequencyBucket createFirstNode() {
        FrequencyBucket root = new FrequencyBucket(0);
        return root;
    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] output = obj.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        printOutput(output);

        output = obj.topKFrequent(new int[]{1}, 1);
        printOutput(output);

        output = obj.topKFrequent(new int[]{1,1,1,2,2,2,1}, 2);
        printOutput(output);
    }

    private static void printOutput(int[] output) {
        for (int i : output) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
