class Solution {
        
    public int totalWealth(int[] A) {
        int total = 0;
        
        for(int el : A) {
            total += el;
        }
        return total;
    }
    
    public int maximumWealth(int[][] accounts) {
        
        int max_wealth = 0;
        for(int[] banks : accounts) {
            
            int currWealth = totalWealth(banks);
            max_wealth = Math.max(currWealth, max_wealth);
        }
        
        return max_wealth;
    }
}