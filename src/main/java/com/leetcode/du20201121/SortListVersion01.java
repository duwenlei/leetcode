package com.leetcode.du20201121;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duwenlei
 **/
public class SortListVersion01 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode lastSorted = head;
        ListNode curr = lastSorted.next;
        while (curr != null) {
            if (lastSorted.val > curr.val) {
                ListNode prev = dummyNode;
                while (prev.next.val < curr.val) {
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
        return dummyNode.next;
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

        ListNode listNode = sortList(head);
        next = listNode;
        while (next != null) {
            System.out.print(next.val);
            System.out.print("\t");
            next = next.next;
        }
        System.out.println();
    }

}
