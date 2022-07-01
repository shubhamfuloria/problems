class Solution {

    public List<List<Integer>> combinationSum(int[] A, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(A, 0, target, new ArrayList<>(), res);
        return res;
    }


    private static void backtrack(int[] A, int pos, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } else if (pos == A.length || target < 0) {
            return;
        }

        // incluing current element
        curr.add(A[pos]);
        backtrack(A, pos, target - A[pos], curr, res);
        curr.remove(curr.size() - 1);

        // exclude current element
        backtrack(A, pos + 1, target, curr, res);
    }
}
