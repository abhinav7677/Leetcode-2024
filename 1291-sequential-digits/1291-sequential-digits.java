class Solution {
    List<Integer> res;
    private String getNewStart(char c,int n){
        String s = ""+c;
        for(int i=1;i<n;i++){
            c = (char)(c+1);
            s= s + c;
        }
        return s;
    }
    private void rec(int high, String cur,int n){
        int v = Integer.parseInt(cur);
        if(v>high)return;
        res.add(v);
        if(cur.charAt(n-1)=='9'){
            if(n==9)return;
            String next = getNewStart('1',n+1);
            rec(high,next,n+1);
        }else if((cur.charAt(0)-'0')+n <= 9){
            String next = getNewStart((char)(cur.charAt(0)+1),n);
            rec(high,next,n);
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        String l = Integer.toString(low);
        res = new ArrayList<>();
        int n = l.length();
        char next = l.charAt(0);
        if(l.charAt(1)-l.charAt(0) > 1){
            next = (char)(l.charAt(0)+1);
        }
        String s = "";
        if((next-'0'+n)<=10){
            s = getNewStart(next,n);
        } else {
            if(++n >9)return res;
            s = getNewStart('1',n);
        }
        rec(high,s,n);
        return res;
    }
}