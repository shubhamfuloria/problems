class Solution {

    public int dfs(String S, HashMap<String, Integer> store) {
        if (S.isEmpty()) {
            return 1;
        } else if (S.charAt(0) == '0') {
            return 0;
        } else if (S.length() == 1) {
            return 1;
        } else if(store.containsKey(S)) {
            return store.get(S);
        }

        int op1 = dfs(S.substring(1), store);
        int op2 = 0;

        String firstTwo = S.substring(0, 2);

        int num = Integer.parseInt(firstTwo);

        if (num <= 26) {
            if (S.length() == 2) {
                op2 = 1;
            } else {
                op2 = dfs(S.substring(2), store);
            }
        }
        store.put(S, op1 + op2);
        return op1 + op2;
    }

    public int numDecodings(String S) {
        return dfs(S, new HashMap<String, Integer>());
    }
}
