class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

int mask=0;
for(int i=0;i<allowed.length();i++){
    int num=(allowed.charAt(i)-'a');
    mask=mask|(1<<num);

}
System.out.println(mask);
int dummy;
int count=0;
for(String str:words){
    boolean flag=true;
    for(int i=0;i<str.length();i++){

int val=str.charAt(i)-'a';
dummy=mask>>val;
dummy=dummy&1;
if(dummy!=1){
    flag=false;
    
}





    }


    if(flag){
        count++;
    }
}

return count;
    }
}