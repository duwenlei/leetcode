package com.leetcode.y2021.m03.d23;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author duwenlei
 **/
public class NestedIterator implements Iterator<Integer> {
    private Deque<Iterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            Iterator<NestedInteger> peek = stack.peek();
            if (!peek.hasNext()){
                stack.pop();
                continue;
            }

            NestedInteger next = peek.next();
            if (next.isInteger()){
                List<NestedInteger> temp = new ArrayList<>();
                temp.add(next);
                stack.push(temp.iterator());
                return true;
            }
            stack.push(next.getList().iterator());
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    public static void main(String[] args) {
        List<NestedInteger> argument = new ArrayList<>();
        NestedIntegerImpl n1 = new NestedIntegerImpl();
        n1.getInteger = 1;
        n1.isInteger = true;
        argument.add(n1);

        NestedIntegerImpl n2 = new NestedIntegerImpl();
        n2.getInteger = 2;
        n2.isInteger = true;

        NestedIntegerImpl n3 = new NestedIntegerImpl();
        n3.getInteger = 3;
        n3.isInteger = true;

        List<NestedInteger> arg = new ArrayList<>();
        arg.add(n2);
        arg.add(n3);

        NestedIntegerImpl n4 = new NestedIntegerImpl();
        n4.isInteger = false;
        n4.getList = arg;

        argument.add(n4);

        NestedIterator nestedIterator = new NestedIterator(argument);

        while (nestedIterator.hasNext()){
            System.out.println(nestedIterator.next());
        }
    }
}
