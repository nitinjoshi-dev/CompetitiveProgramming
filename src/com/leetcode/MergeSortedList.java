package com.leetcode;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeSortedList {

    // 1 -> 2 -> 4
    // 1 -> 3 -> 4

    // 1, 1 -> 1 -> 2
    // 1 -> 2, 3
    // 2 -> 3 -> 4 -> 4, 3
    // 4, 3 -> 4 -> 4
    // 4, 4 -> 4
    // 4, null
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            ListNode list = mergeTwoLists(list1.next, list2);
            list1.next = list;
            return list1;
        } else {
            ListNode list = mergeTwoLists(list1, list2.next); //4
            list2.next = list;
            return list2;
        }
    }

    public static void main(String[] args) {
        MergeSortedList obj = new MergeSortedList();

        ListNode node = new ListNode(4, null);
        node = new ListNode(2, node);
        node = new ListNode(1, node);
        ListNode node1 = node;

        node = new ListNode(4, null);
        node = new ListNode(3, node);
        node = new ListNode(1, node);
        ListNode node2 = node;

        node = obj.mergeTwoLists(node1, node2);
        while (node != null) {
            System.out.println(node.val + " ->");
            node = node.next;
        }
    }
}
