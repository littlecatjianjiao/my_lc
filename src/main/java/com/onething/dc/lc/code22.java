package com.onething.dc.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/6
 */
public class code22 {
    /**
     * 深度
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        ArrayList<String> resList = new ArrayList<>();
        if (n == 0) {
            return resList;
        }
        dfs1("", n, n, resList);
        dfs2("", 0, 0, n, resList);

        return resList;
    }

    /**
     * 广度
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        ArrayList<String> resList = new ArrayList<>();
        if (n == 0) {
            return resList;
        }

        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.offer(new Node("", n, n));

        while (!linkedList.isEmpty()) {
            Node curNode = linkedList.poll();
            if (curNode.left == 0  && curNode.right == 0) {
                resList.add(curNode.res);
            }
            if (curNode.left > 0) {
                linkedList.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                linkedList.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }

        return resList;
    }

    /**
     * 深度优先遍历:减法
     */
    public void dfs1(String curstr, int left, int right, List<String> resList) {
        if (left == 0 && right == 0) {
            resList.add(curstr);
            return;
        }

        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs1(curstr + "(", left - 1, right, resList);
        }

        if (right > 0) {
            dfs1(curstr + ")", left, right - 1, resList);
        }
    }

    /**
     * 加法
     *
     * @param curstr
     * @param left
     * @param right
     * @param resList
     */
    public void dfs2(String curstr, int left, int right, int n, List<String> resList) {
        if (left == 0 && right == 0) {
            resList.add(curstr);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs2(curstr + "(", left + 1, right, n, resList);
        }

        if (right > 0) {
            dfs2(curstr + ")", left, right + 1, n, resList);
        }
    }

    /**
     * 广度优先
     */

//    public void
}
