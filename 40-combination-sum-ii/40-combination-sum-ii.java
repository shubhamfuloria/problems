class Solution {

    public List<List<Integer>> combinationSum2(int[] A, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(A);
        backtrack2(A, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack2(int[] A, int pos, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } else if(target < 0) {
            return;
        }

        for (int i = pos; i < A.length; i++) {
            if(i > pos && A[i - 1] == A[i])
                continue;
            curr.add(A[i]);
            backtrack2(A, i + 1, target - A[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
