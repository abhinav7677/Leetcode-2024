#include<bits/stdc++.h>

class Solution {
public:
    string reverseParentheses(string s) 
    {
        stack<pair<char, int>> st; 
        multiset<pair<int, pair<int, int>>> ms;
        for(int i = 0; i < s.size(); i++)
        {
            if(s[i] == '(')
            {
                st.push({'(', i});
            }   
            else if(s[i] == ')')
            {
                pair<char, int> p = st.top();
                st.pop();
                ms.insert({i - p.second, {p.second, i}});
            }
        }
        for(auto it = ms.begin(); it != ms.end(); it++)
        {
            pair<int, int> indices = it->second;
            reverse(s.begin() + indices.first + 1, s.begin() + indices.second);
        }
        string ans = "";
        for(int i = 0; i < s.size(); i++)
        {
            if(s[i] != '(' && s[i] != ')')
            {
                ans += s[i];
            }
        }
        return ans;
    }
};