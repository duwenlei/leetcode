package com.leetcode.y2021.du20201130;

import java.util.PriorityQueue;

/**
 * @author duwenlei
 **/
public class ReorganizeStringVersion01 {
    public static String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();
        int[] worlds = new int[26];
        int maxCount = 0;
        for (int i = 0; i < S.length(); i++) {
            worlds[S.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, worlds[S.charAt(i) - 'a']);
        }
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((w1, w2) -> worlds[(char) (w2 - 'a')] - worlds[(char) (w1 - 'a')]);
        for (char i = 'a'; i <= 'z'; i++) {
            if (worlds[i - 'a'] > 0) {
                queue.add(i);
            }
        }

        while (queue.size()>1) {
            char p1 = queue.poll();
            char p2 = queue.poll();
            sb.append(p1);
            sb.append(p2);

            int w1 = p1 - 'a';
            int w2 = p2 - 'a';

            worlds[w1]--;
            worlds[w2]--;

            if (worlds[w1] > 0) {
                queue.add((char) (w1 + 'a'));
            }
            if (worlds[w2] > 0) {
                queue.add((char) (w2 + 'a'));
            }
        }

        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("vvvlo"));
    }
}
