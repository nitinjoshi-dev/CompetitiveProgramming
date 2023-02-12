package com.leetcode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromLL {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromLL obj = new RemoveDuplicatesFromLL();
        int[] elements = {1,1,2,3,3};
        ListNode head = null;
        ListNode currentNode = null;
        for (int element: elements) {
            ListNode node = new ListNode(element);
            if(head == null) {
                head = node;
            }
            if (currentNode != null) {
                currentNode.next = node;
            }
            currentNode = node;
        }
        head = obj.deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }



     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
