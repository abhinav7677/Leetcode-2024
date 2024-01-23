
class Solution {

    public int maxLength(List<String> arr) {
        String str="";
        int idx = 0;
        return getMax(arr,str,idx);
    }

    public static int getMax(List<String> list, String str, int idx){
        if(idx==list.size()) return str.length();
        int taken=0;
        if(canTake(list.get(idx),str)) {
            taken = getMax(list,str+list.get(idx),idx+1);
        }
        int notTaken = getMax(list,str,idx+1);

        return Math.max(taken, notTaken);
    }

    public static boolean canTake(String cur, String str){
        if(!sanityCheckPassed(cur)) return false;
        for (char c : cur.toCharArray()) {
            if (str.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean sanityCheckPassed(String str){
        Set<Character> set = new HashSet();
        for(int i=0;i<str.length();i++) set.add(str.charAt(i));
        return(str.length()==set.size());
    }
}