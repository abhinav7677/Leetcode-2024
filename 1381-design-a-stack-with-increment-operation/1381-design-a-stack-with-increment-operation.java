class CustomStack {
    private int stack[];
    private int maxSize;
    private int top=-1;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        this.top=-1;
        this.stack=new int[maxSize];
    }
    
    public void push(int x) {
        if(top==maxSize-1)
        {
            return;
        }
        stack[++top]=x;
    }
    
    public int pop() {
        if(top==-1)
        {
            return -1;
        }
        return stack[top--];
    }
    
    public void increment(int k, int val) {
        int dummytop=-1;
        if(k>maxSize)
        {
            for(int i=0;i<maxSize;i++)
            {
                stack[++dummytop]+=val;
            }
        }
        else{
            for(int i=0;i<k;i++)
            {
                stack[++dummytop]+=val;
            }
        }
    }
}

