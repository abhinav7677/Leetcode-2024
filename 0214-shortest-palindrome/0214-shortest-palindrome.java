class Solution {
    public String shortestPalindrome(String s) {
        /**
         * KMP Algorithm for Pattern Searching
         */
        String newString = s + "@" + new StringBuilder(s).reverse();
        int[] pi = new int[newString.length()];
        int i = 1;
        int k = 0;
        while (i < newString.length()) {
            if (newString.charAt(i) == newString.charAt(k)) {
                k++;
                pi[i] = k;
                i++;
            } else {
                if (k > 0) {
                    k = pi[k - 1];
                } else {
                    pi[i] = 0;
                    i++;
                }
            }
        }
        int index = pi[newString.length() - 1];

        return new StringBuilder(s.substring(index)).reverse() + s;


        /**
         * Simple way to solve this problem but its taking time to complete
         */
//        StringBuilder res = new StringBuilder();
//
//        if (s.contentEquals(new StringBuilder(s).reverse())) return s;
//        for (int i = 0; i < s.length(); i++) {
//            res.append(s.charAt(s.length() - 1 - i));
//            if ((res + s).contentEquals(new StringBuilder(res + s).reverse())) {
//                return res.append(s).toString();
//            }
//        }
//
//        return "";
    }
}