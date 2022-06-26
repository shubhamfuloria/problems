class Solution {

    public List<List<Integer>> combine(int n, int k) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i + 1;
        }
        // A: [1, 2, 3, 4]

        List<List<Integer>> res = new ArrayList<>();
        backtrack(A, k, 0, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int[] A, int k, int start, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr)); // res: [{}]
        }
        for (int i = start; i < A.length; i++) {
            curr.add(A[i]); // [1];
            backtrack(A, k, i + 1, curr, res); // generate all subsets that follows [1]
            // backtrack
            curr.remove(curr.size() - 1); // []
        }
    }
}
