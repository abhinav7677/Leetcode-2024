import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> newmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            newmap.putIfAbsent(s.charAt(i), 0);
            newmap.replace(s.charAt(i), newmap.get(s.charAt(i)) + 1);
        }

        int[] sizes = new int[newmap.size()];

        char[] chars = new char[newmap.size()];

        for (char key : newmap.keySet()) {
            int x = newmap.get(key);

            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i] < x) {
                    if (sizes[i] != 0) { // shift everything to right
                        int temp;
                        int temp2 = sizes[i];
                        char tempp1;
                        char tempp2 = chars[i];

                        for (int j = i; j + 1 < sizes.length; j++) {
                            if (sizes[j] == 0)
                                break;

                            temp = sizes[j + 1];
                            sizes[j + 1] = temp2;
                            temp2 = temp;

                            tempp1 = chars[j + 1];
                            chars[j + 1] = tempp2;
                            tempp2 = tempp1;
                        }
                    }

                    sizes[i] = x;
                    chars[i] = key;
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < sizes.length; i++) {
            int len = sizes[i];

            for (int j = 0; j < len; j++) {
                res.append(chars[i]);
            }
        }


        return res.toString();
    }
}