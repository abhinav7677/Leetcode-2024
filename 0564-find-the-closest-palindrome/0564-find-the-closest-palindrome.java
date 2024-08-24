class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        long candidate1 = (long) Math.pow(10, len - 1) - 1;
        long candidate2 = (long) Math.pow(10, len) + 1;
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        long candidate3 = getPalindrome(prefix, len % 2 == 0);
        long candidate4 = getPalindrome(prefix + 1, len % 2 == 0);
        long candidate5 = getPalindrome(prefix - 1, len % 2 == 0);    
        long[] candidates = {candidate1, candidate2, candidate3, candidate4, candidate5};
        long closest = -1;
        for (long candidate : candidates) {
            if (candidate == num) continue;
            if (closest == -1 || 
                Math.abs(candidate - num) < Math.abs(closest - num) ||
                (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                closest = candidate;
            }
        }
        
        return String.valueOf(closest);
    }
    
    private long getPalindrome(long prefix, boolean evenLength) {
        String str = Long.toString(prefix);
        StringBuilder sb = new StringBuilder(str);
        if (!evenLength) sb.deleteCharAt(sb.length() - 1);
        return Long.parseLong(str + sb.reverse().toString());
    }
}