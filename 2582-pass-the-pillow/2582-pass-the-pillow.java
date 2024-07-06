class Solution {
    public int passThePillow(int n, int time) {
       int ans=1;
       boolean flag=false;
       while(time>0){
        if(ans<n && flag==false){
            
            ans++;
        }
        else if(ans==1 && flag==true){
            flag=false;
            ans++;
        }
        else{
            flag=true;
            ans--;
        }
        time--;
       }
       return ans;
    }
}