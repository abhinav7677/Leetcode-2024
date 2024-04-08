class Solution {
    public int countStudents(int[] stu, int[] sand) {
        int one = 0, zero = 0;
        for (int i : stu) {
            one += i;
            zero += (1 - i);
        }
        for (int i : sand) {
            if (i == 1 && one > 0) {
                one--;
            } else if (i == 0 && zero > 0) {
                zero--;
            } else {
                break;
            }
        }
        return one + zero;
    }
}