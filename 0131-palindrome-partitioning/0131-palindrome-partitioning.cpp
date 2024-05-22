class Solution {
public:
vector<vector<string>>v;
bool check(string s)
{
    string p=s;
    reverse(s.begin(),s.end());
    if(p==s)
    return true;
    return false;
}
void help(string s,int i,vector<string>&p)
{
    if(i==s.size()){
    v.push_back(p);
    return;
    }
    for(int j=i+1;j<=s.size();j++)
    {
        if(check(s.substr(i,j-i))){
            p.push_back(s.substr(i,j-i));
            help(s,j,p);
            p.pop_back();
        }
         
    }
}
    vector<vector<string>> partition(string s) {
        vector<string>p;
        help(s,0,p);
        return v;
    }
};