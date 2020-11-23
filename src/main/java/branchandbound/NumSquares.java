package branchandbound;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 完全平方数
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * <p>
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class NumSquares {
    public int numSquares(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            while (size > 0) {
                int val = queue.poll();
                for (int i = 1; i * i <= val; i++) {
                    if (val == i * i) {
                        return answer;
                    }
                    queue.offer(val - i * i);
                }
                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
        System.out.println(new NumSquares().numSquares(13));
    }
}
