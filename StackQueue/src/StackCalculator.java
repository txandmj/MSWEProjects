public class StackCalculator {
    Stack<Object> stack = null;
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
            int tmp = (int)stack.pop() * num;
            stack.push(tmp);
        }else if (op == '/') {
            if(num == 0) {
                throw new ArithmeticException("Division by zero!");
            }
            int tmp = (int)stack.pop() / num;
            stack.push(tmp);
        }
    }
    // Main calculator function to evaluate the expression
    public int calculator(String str) throws Exception {
        if(str == null) {
            throw new Exception("String is empty!");
        }
        int res = 0, num = 0;
        char operand = '+'; //+-*/
        char[] chars = str.toCharArray();
        int countOperands = 0;
        boolean flagPreIsNum = false; //avoid multiple operands together
        //boolean flagPreIsOperand = true;
        for(char c : chars) {
            int ct = charType(c);
            if(ct == 1) {// If it's a digit
                flagPreIsNum = true;
                //flagPreIsOperand = false;

                num = num * 10 + c - '0'; // ASCII conversion to int!!!
            } else if (ct == 2){// If it's an operator
                if(flagPreIsNum) {
                    countOperands++;
                    InternalCalc(operand, num);
                    operand = c;
                    num = 0;
                    flagPreIsNum = false;
                    //flagPreIsOperand = true;
                } else {
                    throw new Exception("The element before the operand is not a number!");
                }

            } else if (ct == 0) { // If it's a space, skip it
                continue;
            } else if (ct == -1) {
                throw new Exception("String is invalid!");
            }

        }
        // Perform the last calculation
        InternalCalc(operand, num);
        // Pop the stack and sum up the result
        while(stack.size() > 0) {
            res += (int)stack.pop();
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
