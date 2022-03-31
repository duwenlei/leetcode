package com.leetcode.y2021.du20201120;

/**
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author duwenlei
 **/
public class InsertionSortListVersion01 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode lastSorted = head, curr = lastSorted.next;
        while (curr != null) {
            if (lastSorted.val > curr.val) {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;

            } else {
                lastSorted = lastSorted.next;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        ListNode head2 = new ListNode(1);
        head1.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;

        ListNode next = head;
        while (next != null) {
            System.out.print(next.val);
            System.out.print("\t");
            next = next.next;
        }
        System.out.println();

        ListNode listNode = insertionSortList(head);
        next = listNode;
        while (next != null) {
            System.out.print(next.val);
            System.out.print("\t");
            next = next.next;
        }
    }
}

