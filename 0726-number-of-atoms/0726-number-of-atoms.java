class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> st=new Stack<>();
        st.push(new HashMap<>());
        int len=formula.length();
        for(int i=0;i<formula.length();){
            if(formula.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i)==')'){
                Map<String,Integer> top=st.pop();
                i++;
                int start=i;
                while(i<len && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multiplier=start<i?Integer.parseInt(formula.substring(start,i)):1;
                for(String key:top.keySet()){
                    st.peek().put(key,st.peek().getOrDefault(key,0)+top.get(key)*multiplier);
                }
            }
            else{
                int start=i;
                i++;
                while(i<len && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String ele=formula.substring(start,i);
                start=i;
                while(i<len && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int count=start<i?Integer.parseInt(formula.substring(start,i)):1;
                st.peek().put(ele,st.peek().getOrDefault(ele,0)+count);
            }
        }
        Map<String,Integer> res=st.pop();
        List<String> ele=new ArrayList<>(res.keySet());
        Collections.sort(ele);
        StringBuilder sb=new StringBuilder();
        for(String s:ele){
            sb.append(s);
            int c=res.get(s);
            if(c>1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}