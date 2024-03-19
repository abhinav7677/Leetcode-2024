class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char, int> freqMap;
        int maxFreq = 0, maxCount = 0;
        
        // Count the frequency of each task
        for (char task : tasks) {
            freqMap[task]++;
            maxFreq = max(maxFreq, freqMap[task]);
        }
        
        // Count the number of tasks with maximum frequency
        for (const auto& entry : freqMap) {
            if (entry.second == maxFreq) {
                maxCount++;
            }
        }
        
        // Calculate the minimum number of intervals required
        int minIntervals = (maxFreq - 1) * (n + 1) + maxCount;
        
        // Return the maximum of minimum intervals and the total number of tasks
        return max(minIntervals, static_cast<int>(tasks.size()));
    }
};