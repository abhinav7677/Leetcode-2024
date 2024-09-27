class MyCalendarTwo {
     ArrayList<ArrayList<Integer>>s;
     ArrayList<ArrayList<Integer>>d;
    public MyCalendarTwo() {
        s=new ArrayList<>();
        d=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(s.size()==0){
            ArrayList<Integer>a=new ArrayList<>();
             a.add(start);
             a.add(end);
             s.add(a);
             return true;

        }
for(ArrayList<Integer>a:d){
            if(Math.min(end,a.get(1))>Math.max(start,a.get(0))){
                return false;
            }
        }
        for(ArrayList<Integer>a:s){
            if(Math.min(end,a.get(1))>Math.max(start,a.get(0))){
                ArrayList<Integer>l=new ArrayList<>();
              l.add(Math.max(start,a.get(0)));
             l.add(Math.min(end,a.get(1)));
             d.add(l);
            }
        }
         ArrayList<Integer>a=new ArrayList<>();
             a.add(start);
             a.add(end);
             s.add(a);
        return true;
    }
}
