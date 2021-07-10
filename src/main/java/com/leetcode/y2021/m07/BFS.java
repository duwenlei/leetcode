package com.leetcode.y2021.m07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author duwenlei
 **/
public class BFS {
    public static void main(String[] args) {
        bfs(GRAPH, "E");
    }

    private static Map<String, List<String>> GRAPH;

    static {
        GRAPH = new HashMap<>(6);
        GRAPH.put("A", new ArrayList<String>() {{
            add("B");
            add("C");
        }});

        GRAPH.put("B", new ArrayList<String>() {{
            add("A");
            add("C");
            add("D");
        }});

        GRAPH.put("C", new ArrayList<String>() {{
            add("A");
            add("B");
            add("D");
            add("E");
        }});

        GRAPH.put("D", new ArrayList<String>() {{
            add("B");
            add("C");
            add("E");
            add("F");
        }});

        GRAPH.put("E", new ArrayList<String>() {{
            add("C");
            add("D");
        }});

        GRAPH.put("F", new ArrayList<String>() {{
            add("D");
        }});
    }

    public static void bfs(Map<String, List<String>> graph, String start) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        List<String> seen = new ArrayList<>();
        seen.add(start);

        while (queue.size() > 0) {
            String curr = queue.poll();

            List<String> nodes = GRAPH.get(curr);
            for (String node : nodes) {
                if (!seen.contains(node)) {
                    queue.add(node);
                    seen.add(node);
                }
            }
            System.out.println(curr);
        }
    }
}
