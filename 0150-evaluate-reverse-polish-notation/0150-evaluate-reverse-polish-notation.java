import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String val : tokens) {
            if (val.length() == 1 && (val.charAt(0) < 48)) {
                int x2 = st.pop();
                int x1 = st.pop();

                if (val.charAt(0) == '+') {
                    st.add(x1 + x2);
                } else if (val.charAt(0) == '-') {
                    st.add(x1 - x2);
                } else if (val.charAt(0) == '*') {
                    st.add(x1 * x2);
                } else {
                    st.add(x1 / x2);
                }
            } else {
                st.push(Integer.parseInt(val));
            }
        }


        return st.pop();
    }
}