class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& arr) {
        int N = arr.size(); // Number of customers
        int current_start_time = arr[0][0]; // Initialize current start time to the arrival time of the first customer
        double waiting_time = 0; // Initialize total waiting time
        int end_time = 0; // Initialize end time

        for (int i = 0; i < N; i++) {
            if (current_start_time >= arr[i][0]) {
                // If the chef is ready before or exactly when the customer arrives
                end_time = current_start_time + arr[i][1]; // Calculate end time for current customer
                waiting_time += end_time - arr[i][0]; // Add the waiting time for current customer
                current_start_time = end_time; // Update the start time for the next customer
            } else {
                // If the customer arrives before the chef is ready
                end_time = arr[i][0] + arr[i][1]; // Calculate end time for current customer
                waiting_time += end_time - arr[i][0]; // Add the waiting time for current customer
                current_start_time = end_time; // Update the start time for the next customer
            }
        }
        return waiting_time / (double)N; // Return the average waiting time
    }
};