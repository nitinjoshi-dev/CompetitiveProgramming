package com.leetcode;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoLL {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode previousNode = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode currentNode = new ListNode(sum % 10);
            carry = sum / 10;
            if(result == null) {
                result = currentNode;
            }
            if (previousNode != null) {
                previousNode.next = currentNode;
            }
            previousNode = currentNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            ListNode currentNode = new ListNode(sum % 10);
            carry = sum / 10;
            previousNode.next = currentNode;
            previousNode = currentNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            ListNode currentNode = new ListNode(sum % 10);
            carry = sum / 10;
            previousNode.next = currentNode;
            previousNode = currentNode;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode currentNode = new ListNode(carry);
            previousNode.next = currentNode;
        }

        return result;
    }

    public static void main(String[] args) {
        AddTwoLL obj = new AddTwoLL();
        int[] element1 = {2,4,3};
        int[] element2 = {5,6,4};
        ListNode result = obj.getResultSum(element1, element2);
        displayResult(result);
        int[] element3 = {9,9,9,9,9,9,9};
        int[] element4 = {9,9,9,9};
        result = obj.getResultSum(element3, element4);
        displayResult(result);
        int[] element5 = {5};
        int[] element6 = {5};
        result = obj.getResultSum(element5, element5);
        displayResult(result);
    }

    private static void displayResult(ListNode result) {
        System.out.println("Result -----------------------");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private ListNode getResultSum(int[] element1, int[] element2) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode currentNode = null;
        for (int element: element1) {
            ListNode node = new ListNode(element);
            if(head1 == null) {
                head1 = node;
            }
            if (currentNode != null) {
                currentNode.next = node;
            }
            currentNode = node;
        }
        currentNode = null;
        for (int element: element2) {
            ListNode node = new ListNode(element);
            if(head2 == null) {
                head2 = node;
            }
            if (currentNode != null) {
                currentNode.next = node;
            }
            currentNode = node;
        }
        ListNode result = addTwoNumbers(head1, head2);
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
