package com.leetcode.du20201214;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duwenlei
 **/
public class GroupAnagramsVersion01 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            if (strs[i] == "") {
                continue;
            }
            list.add(strs[i]);
            String str = strs[i];
            strs[i] = "";
            for (int j = i; j < strs.length; j++) {
                boolean flag = true;
                for (int k = 0; k < strs[j].length(); k++) {
                    int index = str.indexOf(strs[j].charAt(k));
                    if (index == -1) {
                        flag = false;
                        break;
                    }
                    str = str.substring(0, index) + str.substring(index, str.length() - 1);
                }
                if (flag && strs[j] != "" && str.length() == 0) {
                    list.add(strs[j]);
                    strs[j] = "";
                }
            }
            if (list.size() > 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }
}
