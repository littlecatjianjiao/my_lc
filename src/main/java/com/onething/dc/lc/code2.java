package com.onething.dc.lc;

import akka.remote.artery.aeron.AeronSink;
import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 9999999 + 9999 = 10,009,998
 * <p>
 * 2,3,3     2,2,2
 * 332 + 222 =554
 * [455]
 */
public class code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int noderes = x + y + carry;
            int yushu = noderes % 10;
            carry = noderes / 10;
            cur.next = new ListNode(yushu);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }

        return listNode.next;
    }

    public ListNode test(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int res = x + y + carry;
            carry = res / 10;
            cur.next = new ListNode(res % 10);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        System.out.println(listNode);
        System.out.println(cur);
        System.out.println(cur == listNode);
        cur.next = new ListNode(1);
        System.out.println(listNode.val);
        System.out.println(cur.val);
    }

    public static class ListNode {
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
}


/**
 * ListNode dummy = new ListNode(0);
 * int carry = 0;
 * ListNode cur = dummy;
 * while (l1 != null || l2 != null || carry != 0) {
 * int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
 * carry = s / 10;
 * cur.next = new ListNode(s % 10);
 * cur = cur.next;
 * l1 = l1 == null ? null : l1.next;
 * l2 = l2 == null ? null : l2.next;
 * }
 * return dummy.next;
 */