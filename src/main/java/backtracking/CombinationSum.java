package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总数
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new LinkedList<>(), candidates, target, 0);
        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> selected, int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            answer.add(new ArrayList<>(selected));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            selected.add(candidates[i]);
            dfs(answer, selected, candidates, target - candidates[i], i);
            selected.remove(Integer.valueOf(candidates[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
