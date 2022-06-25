class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res, 0);
        return res;
    }

    private static void backtrack(int[] A, List<Integer> curr, List<List<Integer>> res, int start) {
        // every array contains an empty subset {}
        res.add(new ArrayList<>(curr)); // curr: []

        for (int i = start; i < A.length; i++) {
            curr.add(A[i]); // curr: [1]
            // generate all subsets starting with 1
            backtrack(A, curr, res, i + 1);
            // backtrack (remove 1 from the curr)
            curr.remove(curr.size() - 1); // []
        }
    }
}
