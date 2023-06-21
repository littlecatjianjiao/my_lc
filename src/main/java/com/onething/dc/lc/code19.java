package com.onething.dc.lc;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 */
public class code19 {

    public ListNode test(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre,end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    //1 - 2 - 3 - 4 - 5     n = 5  =>  2 - 3 - 4 - 5
    //1 - 2 - 3 - 4 - 5     n = 2  =>  1 - 2 - 3 - 5
    //1 - 2 - 3 - 4 - 5     n = 3  =>  1 - 2 - 4 - 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}

