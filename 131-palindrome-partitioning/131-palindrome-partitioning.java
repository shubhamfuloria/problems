class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void backtrack(String s, int start, List<String> curr, List<List<String>> res) {
        
        if(start == s.length()) {
            res.add(new ArrayList<>(curr));
        }
        
        for(int i = start; i < s.length(); i++) {
            if(isPallindrom(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                backtrack(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isPallindrom(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}