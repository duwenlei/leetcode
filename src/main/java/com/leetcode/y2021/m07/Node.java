package com.leetcode.y2021.m07;

import java.util.Comparator;

/**
 * @author duwenlei
 **/
public class Node implements Comparable<Node> {

    private String name;
    private int cost;

    public Node() {
    }

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o2) {
        if (this.cost > o2.cost) {
            return 1;
        } else if (this.cost < o2.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}
