class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combs = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), combs);
        return combs;
    }

    public static void backtrack(int k, int n, int start, List<Integer> curr, List<List<Integer>> combs) {
        if (curr.size() == k && sum(curr) == n) {
            combs.add(new ArrayList<>(curr));
        }

        for (int i = start; i <= 9; i++) {
            curr.add(i); // [1]
            backtrack(k, n, i + 1, curr, combs);
            curr.remove(curr.size() - 1); // []
        }
    }

    public static int sum(List<Integer> A) {
        int sum = 0;
        for (int el : A) {
            sum += el;
        }
        return sum;
    }
}
