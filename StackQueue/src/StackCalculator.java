package StackQueue.src;

public class StackCalculator {
    Stack<Integer> stack = null;
    public StackCalculator() {
        stack = new Stack();
    }
    // Perform the internal calculation based on the operator and number
    private void InternalCalc(char op, int num) {
        if (op == '+') {
            stack.push(num);
        } else if (op == '-') {
            stack.push(-num);
        } else if (op == '*') {
            int tmp = stack.pop() * num;
            stack.push(tmp);
        } else if (op == '/') {
            if(num == 0) {
                throw new ArithmeticException("Division by zero!");
            }
            int tmp = stack.pop() / num;
            stack.push(tmp);
        }
    }
    // Main calculator function to evaluate the expression
    public int calculator(String str) throws Exception {
        if(str == null || str.length() == 0) {
            throw new Exception("String is empty!");
        }
        int res = 0, num = 0;
        char operator = '+'; //default to addition for the first number
        char[] chars = str.toCharArray();
        //To avoid multiple numbers and operators together
        //flagPre[0] for number, flag[1] for space
        boolean[] flagPre = {true, false};
        for(char c : chars) {
            int ct = charType(c);
            if(ct == 1) {// If it's a digit
                if(flagPre[0] && flagPre[1]) { //there are spaces between numbers
                    throw new Exception("Invalid input: there are multiple numbers put together!");
                }
                flagPre[0] = true;
                num = num * 10 + c - '0'; // ASCII conversion to int!!!
                flagPre[1] = false;
            } else if (ct == 2){// If it's an operator
                if(flagPre[0]) { //previous element is a number
                    InternalCalc(operator, num);
                    operator = c; //update the operator
                    num = 0;//reassign num
                    flagPre[0] = false;
                } else { //previous element isn't a number,edge case: 10 ++ 20
                    throw new Exception("Invalid input: expected a number before the operator!");
                }
            } else if (ct == 0) { // If it's a space, skip it
                flagPre[1] = true; //update flagPre[1](for space)
                continue;
            } else if (ct == -1) {
                throw new Exception("String is invalid!");
            }
        }
        // Perform the last calculation
        if(flagPre[0] == true) { //the last element is a number
            InternalCalc(operator, num);
        } else { //the last element isn't a number. eg 10+20+
            throw new Exception("Invalid input: the last element should be a number");
        }

        // Pop the stack and sum up the result
        while(stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
    // Returns character type: -1 for invalid, 0 for space, 1 for number, 2 for operator
    public int charType(char c) {
        if(c >= '0' && c <= '9') {
            return 1;
        } else if(c == '+' || c == '-' || c == '*' || c == '/') {
            return 2;
        } else if(c == ' '){
            return 0;
        }
        return -1;
    }
}
