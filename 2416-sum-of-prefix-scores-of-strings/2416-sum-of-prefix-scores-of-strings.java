class Trie{
    Trie[] links=new Trie[26];
    int cp=0,ew=0;
    boolean containsKey(char ch){
        return this.links[ch-'a']!=null;
    }
    void put(char ch){
        this.links[ch-'a']=new Trie();
    }

    void update(){this.cp++;}

    Trie get(char ch){
        return this.links[ch-'a'];
    }
    void set(){
        this.ew++;
    }
    boolean isEnd(){
        return this.ew>0;
    }

}
class Solution {
    Trie root;
    public void insert(String s){
        Trie node=root;
        for(char ch:s.toCharArray()){
            if(!node.containsKey(ch)) node.put(ch);
            node=node.get(ch);
            node.update();
        }
        node.set();

    }
    public int find(String s){
        int c=0;
        Trie node=root;
        for(char ch:s.toCharArray()){
            if(!node.containsKey(ch)) return c;
            node=node.get(ch);
            c+=node.cp;
        }
        return c;
    }
    public int[] sumPrefixScores(String[] words) {
        root=new Trie();
        for(String s:words) insert(s);
        int[] ans=new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i]=find(words[i]);
        }
        return ans;
    }
}