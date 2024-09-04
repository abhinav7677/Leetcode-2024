class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<String, Integer> map=new HashMap();
        for(int i=0; i<obstacles.length; i++){
            map.put(String.valueOf(obstacles[i][0]).concat(",").concat(String.valueOf(obstacles[i][1])), 1);
        }
                
        String direction="north";
        int x=0, y=0;
        int maxDistance=0, cnt=0;
        for(int i=0; i<commands.length; i++){
            //Direction Checking for turn: -1, -2
            if(commands[i]<0){ direction=getDirection(direction,commands[i]);  }
            
            //Moving towards direction for turn: 1 to 9
            if(commands[i]>0){ 
                if(direction.equals("north") || direction.equals("south")){  
                    y = getXorY(direction, commands[i], x, y, map); 
                }
                if(direction.equals("east") || direction.equals("west") ){ 
                    x = getXorY(direction, commands[i], x, y, map); 
                }                
            }
            maxDistance=Math.max(maxDistance, x*x+y*y);
        }
                                
        return maxDistance;
    }    
    
    int getXorY(String direction, int val, int x, int y, Map<String, Integer> map){
        if(direction.equals("north")){ //y+                        
            for(int i=0; i<val; i++){
                int ny=y+1;
                String key=String.valueOf(x).concat(",").concat(String.valueOf(ny));
                if(!map.isEmpty() && map.get(key)!=null && map.get(key)==1){ break; }
                y=ny;                
            }
            return y;
        }
        if(direction.equals("east")){ //x+            
            for(int i=0; i<val; i++){
                int nx=x+1;
                String key=String.valueOf(nx).concat(",").concat(String.valueOf(y));
                if(!map.isEmpty() && map.get(key)!=null && map.get(key)==1){ break; }
                x=nx;                
            }
            return x;
        }
        if(direction.equals("south")){ //y-            
            for(int i=0; i<val; i++){
                int ny=y-1;
                String key=String.valueOf(x).concat(",").concat(String.valueOf(ny));
                if(!map.isEmpty() && map.get(key)!=null && map.get(key)==1){ break; }
                y=ny;                
            }
            return y;
        }
        if(direction.equals("west")){ //x-            
            for(int i=0; i<val; i++){
                int nx=x-1;
                String key=String.valueOf(nx).concat(",").concat(String.valueOf(y));
                if(!map.isEmpty() && map.get(key)!=null && map.get(key)==1){ break; }
                x=nx;                
            }
            return x;
        }

        return -1;
    }
    
    
    String getDirection(String direction, int turn){
        if(turn==-1){  //Turn right 90 degrees
            if(direction.equals("north")){ direction="east"; }
            else if(direction.equals("east")){ direction="south"; }
            else if(direction.equals("south")){ direction="west"; }
            else if(direction.equals("west")){ direction="north"; }
        }
        else if(turn==-2){  //Turn left 90 degrees
            if(direction.equals("north")){ direction="west"; }
            else if(direction.equals("east")){ direction="north"; }
            else if(direction.equals("south")){ direction="east"; }
            else if(direction.equals("west")){ direction="south"; }
        }
        
        return direction;
    }
}