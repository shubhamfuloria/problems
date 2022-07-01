class Solution {

    public List<List<Integer>> permute(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(A, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] A, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == A.length) {
            res.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < A.length; i++) {
            if (curr.contains(A[i])) {
                continue;
            }
            curr.add(A[i]);
            backtrack(A, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
