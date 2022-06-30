class Solution {

    public List<List<Integer>> subsetsWithDup(int[] A) {
        HashSet<List<Integer>> subsets = new HashSet<>();
        Arrays.sort(A);
        backtrack(A, 0, subsets, new ArrayList<>());

        List<List<Integer>> res = new ArrayList<>(subsets);

        return res;
    }

    public static void backtrack(int[] A, int index, HashSet<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < A.length; i++) {
            curr.add(A[i]);
            backtrack(A, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
