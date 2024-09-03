class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to a number string
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            sb.append(val);
        }
        
        // Convert the string builder to a numeric string for summing digits
        String numStr = sb.toString();
        
        // Step 2: Calculate the sum of digits k times
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (char c : numStr.toCharArray()) {
                sum += c - '0';
            }
            numStr = String.valueOf(sum);
        }
        
        return sum;
    }
}