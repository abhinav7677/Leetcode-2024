public class Solution {
    class Pair{
       char ch;
       int freq;
       public Pair(char ch, int freq){
        this.ch=ch;
        this.freq=freq;
       } 
    }
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
           // System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            pq.add(new Pair(entry.getKey(), entry.getValue() ));
        }
        int clicks=0;
        int counter=0;
        while(!pq.isEmpty()){
            Pair p =pq.poll();
            int level =counter/8 + 1;
           // System.out.println(level);
            clicks+=p.freq*level;// * (counter%8 + 1);
            counter++;
        }
        return clicks;
    }
}