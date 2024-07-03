class Solution {
public:

    bool find(vector<int> &arr , int val){
        int start =0, end = arr.size();
        while(start <= end){
            int mid =start + ((end -  start) /2);
            if(arr[mid] == val){
                arr[mid] = -1;
                sort(arr.begin() , arr.end());
                return true;
            }
            else if(arr[mid] > val)
                end = mid-1;
            else if(arr[mid] < val)
                start = mid+1;  
        }
        return false;
    }

    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        bool f= nums1.size()>= nums2.size()?true:false;
        vector<int> res;
        if(f == true){
            sort(nums1.begin(), nums1.end());
            for(int i = 0 ; i< nums2.size() ; i++){
                if(find(nums1 ,nums2[i] )){
                    res.push_back(nums2[i]);
                }
            }
        }
        else{
           sort(nums2.begin(), nums2.end());
            for(int i = 0 ; i< nums1.size() ; i++){
                if(find(nums2 ,nums1[i] )){
                    res.push_back(nums1[i]);
                }
            } 
        }
        return res;    
    }
};