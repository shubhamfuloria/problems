class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("(", 1, 0, n, res);
        return res;
    }
    
    private void backtrack(String s, int open, int close, int n, List<String> res) {

        if(s.length() == 2 * n) {
            res.add(s);
            return;
        }
        
        if(open < n)    backtrack(s + "(", open + 1, close, n, res);
        if(close < open) backtrack(s + ")", open, close + 1, n, res);
    }
}