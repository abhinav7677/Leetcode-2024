class Solution {
    public String fractionAddition(String expression) {
        if(expression.length()==1)return ""+expression.charAt(0)+"/"+"1";
        expression=expression.replaceAll("-","+-");
       
        String frac[]=expression.split("\\+");
        int den=1;
        for(int i=0;i<frac.length;i++)
        {
            if(frac[i].length()!=0)
            {
                den*=Integer.parseInt(frac[i].split("/")[1]);
            }
        }

       
        int num=0;
        for(int i=0;i<frac.length;i++)
        {
            if(frac[i].length()!=0)
            {
               int mul=den/Integer.parseInt(frac[i].split("/")[1]);
               
                    num=num+(Integer.parseInt(frac[i].split("/")[0])*mul);
               
              
            }
        }
         
        //we have the final num and den
        int hcf=gcd(Math.abs(num),den);
        num=num/hcf;
        den=den/hcf;
        return String.valueOf(num)+"/"+String.valueOf(den);


    }
    public int gcd(int a,int b)
    {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}