class Solution {

    public List<List<Integer>> subsetsWithDup(int[] A) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(A);
        backtrack(A, 0, subsets, new ArrayList<>());

        return subsets;
    }

    public static void backtrack(int[] A, int index, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < A.length; i++) {
            if (i > index && A[i] == A[i - 1]) continue;
            curr.add(A[i]);
            backtrack(A, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
