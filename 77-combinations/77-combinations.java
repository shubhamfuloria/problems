class Solution {

    public List<List<Integer>> combine(int n, int k) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i + 1;
        }
        // A: [1, 2, 3, 4]

        List<List<Integer>> res = new ArrayList<>();
        generateCombinations(A, k, 0, new ArrayList<>(), res);
        return res;
    }

    public static void generateCombinations(int[] A, int k, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == A.length) {
            if (curr.size() == k) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        // excluding current element
        generateCombinations(A, k, index + 1, curr, res);

        // including current element
        curr.add(A[index]);
        generateCombinations(A, k, index + 1, curr, res);
        curr.remove(curr.size() - 1);
    }
}
