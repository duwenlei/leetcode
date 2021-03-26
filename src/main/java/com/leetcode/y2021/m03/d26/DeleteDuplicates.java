package com.leetcode.y2021.m03.d26;

/**
 * @author duwenlei
 **/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode nextNode = head;
        while (nextNode.next != null) {
            if (nextNode.val == nextNode.next.val) {
                nextNode.next = nextNode.next.next;
            } else {
                nextNode = nextNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;

        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(5);
        listNode6.next = listNode7;

        ListNode t = listNode1;
        while (true) {
            System.out.print(t.val + "\t");
            if (t.next == null) {
                break;
            }
            t = t.next;
        }

        System.out.println("--------------------------");
        ListNode listNode = deleteDuplicates.deleteDuplicates(listNode1);

        ListNode tmp = listNode;
        while (true) {
            System.out.print(tmp.val + "\t");
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
    }
}
