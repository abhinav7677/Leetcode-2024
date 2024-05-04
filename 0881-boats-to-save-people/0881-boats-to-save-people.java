
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        // Simple Greedy Algorithm fails

        // Arrays.sort(people);
        // int i = 0;
        // while (i < people.length) {

        // if (i + 1 < people.length && people[i] + people[i + 1] <= limit) {
        // i = i + 2;
        // } else {
        // i++;
        // }

        // boats++;

        // }
        // return boats;

        // using two pointer approach
        Arrays.sort(people);
        int i = 0, j = people.length-1;
        while (i <= j) {
            //consider light and heavy
            if (people[i] + people[j] <= limit) {
                boats++;
                i++;
                j--;
            } else {
                //consider only heavy
                boats++;
                j--;
            }

        }
        return boats;

    }

}