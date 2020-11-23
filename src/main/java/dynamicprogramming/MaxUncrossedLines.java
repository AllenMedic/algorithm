package dynamicprogramming;

/**
 * 不相交的线(最长公共子串)
 * <p>
 * 我们在两条独立的水平线上按给定的顺序写下A和B中的整数。
 * 现在，我们可以绘制一些连接两个数字A[i]和B[j]的直线，只要A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 * <p>
 * 示例 1：
 * 输入：A = [1,4,2], B = [1,2,4]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * 输出：2
 */
public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        int[][] dp = new int[lengthA + 1][lengthB + 1];
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lengthA][lengthB];
    }

    public static void main(String[] args) {
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }
}
