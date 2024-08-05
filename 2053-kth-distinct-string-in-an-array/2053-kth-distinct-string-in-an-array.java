class Solution {
    public String kthDistinct(String[] arr, int k) {
        // ArrayList to store distinct strings in order of appearance
        ArrayList<String> ch = new ArrayList<>();
        
        if(arr.length == 0) {
            return "";
        }    
        
        // HashMap to count occurrences of each string
        Map<String, Integer> map = new HashMap<>();
        
        // Count occurrences of each string in the array
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        
        System.out.println(map);
        
        // Collect distinct strings in order of appearance
        for(int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == 1) {
                ch.add(arr[i]);
            }
        }
        
        // If k is greater than the number of distinct strings, return empty string
        if(k > ch.size()) {
            return "";
        }
        
        // Return the kth distinct string (k is 1-indexed, so we use k-1)
        return ch.get(k-1);
    }
}