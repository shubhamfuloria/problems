class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        solve(s, new ArrayList<>(), res);
        return res;
    }

    public void solve(String s, List<String> curr, List<List<String>> res) {
        
        
        if(s.length() == 0) {
            res.add(new ArrayList<>(curr));
        }
        
        //aab
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1); //a
            String suffix = s.substring(i + 1); //ab
            
            if(isPallindrom(prefix, 0, prefix.length() - 1)) {
                curr.add(prefix);
                solve(suffix, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPallindrom(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
