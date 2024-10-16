package StackQueue.src;
// The class simulates a simple calculator
public class StackCalculator {
    //The stack is used to store intermediate results
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
        String strWithoutSpaces = str.replace(" ", "");//Removes all spaces from the string
        int res = 0, num = 0;// res: Stores the final result; num: Supports continuous multi-digit numbers
        char operator = '+'; //Stores the most recent operator (default is + for the first number).
        char[] chars = strWithoutSpaces.toCharArray();
        //Tracks whether the last parsed character was a number
        boolean flagPreIsNumber = false;
        // Flags when a negative number is detected (e.g., handling 10+-20)
        boolean flagNegativeNumber = false;
        //Iterates over each character in the expression and classifies each as num, ope, or invalid char
        for(char c : chars) {
            int ct = charType(c);
            if(ct == 1) {// If it's a digit
                flagPreIsNumber = true;
                num = num * 10 + c - '0'; // Convert char to int (multi-digit support)
            } else if (ct == 2){// If it's an operator
                if(flagPreIsNumber && !flagNegativeNumber) { // Normal number case
                    InternalCalc(operator, num);
                    operator = c; //update the operator
                    num = 0;//reset num
                    flagPreIsNumber = false;
                } else if (flagPreIsNumber && flagNegativeNumber){ // Negative number case
                    InternalCalc(operator, -num);
                    operator = c; //update the operator
                    num = 0;//reassign num
                    flagPreIsNumber = false;
                    flagNegativeNumber = false;//update the flag
                } else { // If no valid number is encountered before the operator (e.g., 10++20)
                    if(c == '-') { // Handling cases like 10+-20
                        flagNegativeNumber = true;
                        continue;
                    }
                    throw new Exception("Invalid input: expected a number before the operator!");
                }
            } else if (ct == 0) {
                throw new Exception("String is invalid!");
            }
        }
        // Perform the last calculation
        if(flagPreIsNumber == true && !flagNegativeNumber) { //the last element is a number
            InternalCalc(operator, num);
        } else if (flagPreIsNumber && flagNegativeNumber){
            InternalCalc(operator, -num);
        }else { //the last element isn't a number. eg 10+20+
            throw new Exception("Invalid input: the last element should be a number");
        }

        // Pop the stack and sum up the result
        while(stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
    //Classifies each character in the string
    // Returns character type:  0 for invalid, 1 for number, 2 for operator
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
