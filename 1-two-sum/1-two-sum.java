class Solution {

    public int[] twoSum(int[] A, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(target - A[i])) {
                int[] res = { map.get(target - A[i]), i };
                return res;
            } else {
                map.put(A[i], i);
            }
        }

        return null;
    }
}
