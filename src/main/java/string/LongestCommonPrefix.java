package string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 更优解二分
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int left = 0, right = prefix.length() - 1;
        while (left <= right) {
            boolean same = true;
            int middle = (left + right) / 2;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() - 1 < middle || prefix.charAt(middle) != strs[i].charAt(middle)) {
                    same = false;
                    break;
                }
            }
            if (same) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return prefix.substring(0, left);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
