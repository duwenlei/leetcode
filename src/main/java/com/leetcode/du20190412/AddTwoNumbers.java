package com.leetcode.du20190412;


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 非空判断
        if (l1 == null || l2 == null) {
            return null;
        }

        // 相加
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode curry = ans;
        while (n1 != null || n2 != null) {
            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curry.next = new ListNode(sum % 10);
            curry = curry.next;

            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;

        }
        if (carry > 0) {
            curry.next = new ListNode(carry);
        }

        return ans.next;

    }

    public static void main(String[] args) {
            System.out.println(19/10);
        System.exit(0);
        ListNode l1 = new ListNode(2);
        ListNode l1Next = new ListNode(4);
        ListNode l1NextNext = new ListNode(3);
        l1Next.next = l1NextNext;
        l1.next = l1Next;

        ListNode l2 = new ListNode(2);
        ListNode l2Next = new ListNode(4);
        ListNode l2NextNext = new ListNode(3);
        l2Next.next = l2NextNext;
        l2.next = l2Next;

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode ans = a.addTwoNumbers(l1, l2);
        ListNode l = ans;
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

