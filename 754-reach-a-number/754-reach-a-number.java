class Solution {
    public int reachNumber(int target) {
        
        target = Math.abs(target);
        
        int step = 0;
        int pos = 0;
        
        while(pos < target) {
            pos += ++step;
        }
        
        if(pos == target || (pos - target) % 2 == 0) {
            return step;
        } 
        
        while((pos - target) % 2 != 0) {
            pos += ++step;
        }
        
        return step;
        
    }
}