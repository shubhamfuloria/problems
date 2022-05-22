class Solution {

    public int numDecodings(String code) {
        int[] dp = new int[code.length()];
        
        if(code.charAt(0) == '0') {
            return 0;
        }
        
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            char last_c = code.charAt(i);
            char slast_c = code.charAt(i - 1);

            if (last_c == '0' && slast_c == '0') {
                dp[i] = 0;
            } else if (slast_c == '0' && last_c != '0') {
                dp[i] = dp[i - 1];
            } else if (slast_c != '0' && last_c == '0') {
                if (slast_c == '1' || slast_c == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = dp[i - 1];
                if (Integer.parseInt(code.substring(i - 1, i + 1)) <= 26) {
                    dp[i] += i >= 2 ? dp[i - 2] : 1;
                }
            }
        }
        return dp[code.length() - 1];
    }
}
