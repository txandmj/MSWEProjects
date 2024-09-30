public class StackCalculator {
    Stack stack = null;
    public StackCalculator() {
        stack = new Stack();
    }

    private void InternalCalc(char op, int num) {
        if (op == '+') {
            stack.push(num);
        } else if (op == '-') {
            stack.push(-num);
        } else if (op == '*') {
            int tmp = (int)stack.pop() * num;
            stack.push(tmp);
        }else if (op == '/') {
            int tmp = (int)stack.pop() / num;
            stack.push(tmp);
        }
    }
    public int calculator(String str) throws Exception {
        if(str == null) {
            throw new Exception("String is empty!");
        }
        int res = 0, num = 0;
        char operand = '+'; //+-*/
        char[] chars = str.toCharArray();
        for(char c : chars) {
            int ct = charType(c);
            if(ct == 1) {
                num = num * 10 + c - '0'; //note: ASCII number calculation!!!!
            } else if (ct == 2){
                InternalCalc(operand, num);
                operand = c;
                num = 0;
            } else if (ct == -1) {
                throw new Exception("String is invalid!");
            }

        }
        InternalCalc(operand, num);
        while(stack.size() > 0) {
            res += (int)stack.pop();
        }
        return res;
    }
    //return -1 means invalid, 0 means space, 1 means number, 2 means +-*/
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
