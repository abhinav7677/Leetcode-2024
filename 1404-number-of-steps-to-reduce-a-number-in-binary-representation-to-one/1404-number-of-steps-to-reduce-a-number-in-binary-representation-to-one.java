class Solution {
    public int numSteps(String s) {
        char[] c = s.toCharArray();
        int ans = 0, i = c.length - 1;
        // i points to the rightmost bit
        while (i > 0) {
            //even
            if (c[i] == '0') {
                i--; // remove rightmost bit
                ans++;
            }
            //odd
            else if (c[i] == '1') {
                int j = i;
                while (j >= 0 && c[j] == '1') j--;
                ans += (i - j + 1);
                if (j >= 0) c[j] = '1';
                i = j;
            }
        }
        return ans;
    }
}