class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashSet<String> unique = new HashSet<>();
        HashSet<String> common = new HashSet<>();

        String[] str1 = s1.split(" "); 
        String[] str2 = s2.split(" ");

        for(String str: str1){
            if(!unique.add(str))
            common.add(str);
        } 
        for(String str: str2){
            if(!unique.add(str))
            common.add(str);
        } 

        unique.removeAll(common);

        return unique.toArray(new String[unique.size()]);

    }
}