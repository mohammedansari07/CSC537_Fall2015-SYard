import java.util.Stack;
 
public class PostFixEvaluator {
    private Stack<Double> stack = new Stack<>();
 
 public double parseTokens(String expression) {
        String operand = "";
        
        for (int i = 0; i < expression.length(); i++) {
            if (!(i + 1 >= expression.length())) {
                if (expression.charAt(i) == '-' && expression.charAt(i + 1) >= '0' &&
                        expression.charAt(i + 1) <= '9') { 
                    operand = "-";
                    continue;
                }
            }
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') { 
                for (int j = i; ; j++) {
                    operand = operand + expression.charAt(j);
                    if (expression.charAt(j + 1) == ' ') {
                        i = j;
                        stack.push(Double.parseDouble(operand));
                        operand = "";
                        break;
                    }
                }
            } else if (expression.charAt(i) == ' ') {
                continue;
            } else { 
                calculate(expression.charAt(i));
            }
        }
        return stack.pop();
    }
 
    public void calculate(char operator) {
        double num1, num2, interAns;
        num2 = stack.pop();
        num1 = stack.pop();
        switch (operator) {
            case '+':
                interAns = num1 + num2;
                break;
            case '-':
                interAns = num1 - num2;
                break;
            case '*':
                interAns = num1 * num2;
                break;
            case '/':
                interAns = num1 / num2;
                break;
            default:
                interAns = 0;
        }
        stack.push(interAns);
    }
}