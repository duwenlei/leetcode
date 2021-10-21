package com.leetcode.y2021.m07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author duwenlei
 **/
public class Dijkstra {
    private static Map<String, List<Node>> GRAPH;

    static {
        GRAPH = new HashMap<String, List<Node>>() {{
            put("A", new ArrayList<Node>() {{
                add(new Node("B", 5));
                add(new Node("C", 1));
            }});

            put("B", new ArrayList<Node>() {{
                add(new Node("A", 5));
                add(new Node("C", 2));
                add(new Node("D", 1));
            }});

            put("C", new ArrayList<Node>() {{
                add(new Node("A", 1));
                add(new Node("B", 2));
                add(new Node("D", 4));
                add(new Node("E", 8));
            }});

            put("D", new ArrayList<Node>() {{
                add(new Node("B", 1));
                add(new Node("C", 4));
                add(new Node("E", 3));
                add(new Node("F", 6));
            }});

            put("E", new ArrayList<Node>() {{
                add(new Node("C", 8));
                add(new Node("D", 3));
            }});

            put("F", new ArrayList<Node>() {{
                add(new Node("D", 6));
            }});
        }};

    }

    public static List<Map> dijkstra(Map<String, List<Node>> graph, String startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));

        List<String> seen = new ArrayList<>();

        Map<String, String> parent = new HashMap<>();
        parent.put(startNode, "");
        Map<String, Integer> distance = new HashMap<>();
        for (String key : graph.keySet()) {
            if (key.equals(startNode)) {
                distance.put(startNode, 0);
            } else {
                distance.put(key, Integer.MAX_VALUE);
            }
        }


        while (pq.size() > 0) {
            Node poll = pq.poll();
            seen.add(poll.getName());

            Integer upperDist = distance.get(poll.getName());
            List<Node> nodes = graph.get(poll.getName());
            for (Node node : nodes) {
                if (!seen.contains(node.getName())) {
                    if (upperDist + node.getCost() < distance.get(node.getName())) {
                        distance.put(node.getName(), upperDist + node.getCost());
                        parent.put(node.getName(), poll.getName());
                        pq.add(node);
                    }
                }
            }

        }
        parent.keySet().forEach(e -> {
            System.out.print(e + ":" + parent.get(e) + "\t");
        });
        System.out.println();

        distance.keySet().forEach(e -> {
            System.out.print(e + ":" + distance.get(e) + "\t");
        });
        System.out.println();

        return new ArrayList<Map>() {{
            add(parent);
            add(distance);
        }};
    }

    public static void main(String[] args) {
        String startNode = "A";
        List<Map> resMap = dijkstra(GRAPH, startNode);

        Map<String, String> parent = resMap.get(0);
        Map<String, Integer> distance = resMap.get(1);

        System.out.print("A 到 F 的最短路径是：F ");
        String node = "F";
        while (!"".equals(node)) {
            node = parent.get(node);
            if (!"".equals(node)) {
                System.out.print(" -> " + node);
            }
        }
        System.out.println();
        System.out.println("最短距离：" + distance.get("F"));
    }
}
