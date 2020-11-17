package com.leetcode.du20201116;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duwenlei
 **/
public class LengthOfLongestSubstringVersion01 {
    /**
     * 原本自己写的是一个暴力破解，但是看到了这个位大哥写的，很牛逼，放上去，大家学习
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, res = 0, max = 0;
        //start记录当前子串起点，res记录当前子串长度，max记录前N-1个不重复子串长度最大值
        //子串即为start~i之间的字符串
        for (int i = 0; i < s.length(); ++i) {
            //如果第i个字符在子串中出现过，则重新开始新的一轮(第N轮)不重复子串
            if (s.indexOf(s.charAt(i), start) < i) {
                //记录前N-1个不重复子串长度最大值
                max = Math.max(max, res);
                //开始第N个不重复子串
                start = s.indexOf(s.charAt(i), start) + 1;
                //修改为第N个不重复子串的当前长度
                res = i - start;
            }
            ++res;
        }
        return Math.max(max, res);
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
