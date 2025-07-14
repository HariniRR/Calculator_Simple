package projectCalculators;

import java.util.Scanner;

class InvalidExpressionException extends Exception {
    public InvalidExpressionException(String message) {
        super(message);
    }
}

public class CalculatorInterface {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression (for ex, 2*8/66+7) : ");
        String expression = scanner.nextLine();

        try {
            double result = evaluateExpression(expression);
            System.out.println("The result is: " + result);
        } catch (InvalidExpressionException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double evaluateExpression(String expression) throws InvalidExpressionException {
        // Check if the expression ends with a number
        if (!Character.isDigit(expression.charAt(expression.length() - 1))) {
            throw new InvalidExpressionException("Expression must end with a number.");
        }

        String[] tokens = expression.split("(?=[-+*/])|(?<=[-+*/])");
        double result = 0;
        double currentNumber = 0;
        String currentOperation = "+";

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;

            if (isOperator(token)) {
                currentOperation = token;
            } else {
                try {
                    currentNumber = Double.parseDouble(token);
                    result = applyOperation(result, currentNumber, currentOperation);
                } catch (NumberFormatException e) {
                    throw new InvalidExpressionException("Invalid character in expression: " + token);
                }
            }
        }
        return result;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double applyOperation(double result, double currentNumber, String operation) {
        switch (operation) {
            case "+":
                return result + currentNumber;
            case "-":
                return result - currentNumber;
            case "*":
                return result * currentNumber;
            case "/":
                if (currentNumber == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return result / currentNumber;
            default:
                return result;
        }
    }
	

}
/* output
Enter an expression (for ex, 2*8/66+7) : 45*6+9-85/4
The result is: 48.5
*/