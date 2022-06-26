class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combs = new ArrayList<>();
        // backtrack(k, n, 1, new ArrayList<>(), combs);
        backtrack1(k, n, 1, 0, new ArrayList<>(), combs);
        return combs;
    }

    public static void backtrack1(int k, int n, int start, int sum, List<Integer> curr, List<List<Integer>> combs) {
        if (curr.size() == k && sum == n) {
            combs.add(new ArrayList<>(curr));
        }

        for (int i = start; i <= 9; i++) {
            curr.add(i); // [1]
            backtrack1(k, n, i + 1, sum + i, curr, combs);
            curr.remove(curr.size() - 1); // []
        }
    }
}
