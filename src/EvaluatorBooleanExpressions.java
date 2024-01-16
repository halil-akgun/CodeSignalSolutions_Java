import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
String expression = "2>0&&-1>-2||-1>0";
String expression = "2>=2.0&&2<=1.0||3>=3.0";
String expression = "5-1>=4.0||(5-1<=4.0&&4-2>2.0)";
String expression = "5-1<4.0||(5-1>4.0&&5-1<=4.0)";
String expression = -2>11.0 || (26>25.0 && 124<125.0)
String expression = "false || (false && 124<125.0)"
String expression = "1-2>1.0||(1-3>=-2.0&&2>1.0&&3>=3.0)";
String expression = "1/3>0.33&&3/2>=1.5&&1/2<=0.5&&2-1<=1.0";
String expression = "1/3>0.33&&(3/2<=1.5)";

Note:
In order for evaluateJsBooleanExpression to function, the JAR files from the link below need to be added to the project.
https://jar-download.com/?search_box=OpenJDK%20Nashorn
 */
public class EvaluatorBooleanExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Evaluate predefined expressions");
        System.out.println("2. Enter a custom expression manually");

        int option = scanner.nextInt();

        if (option == 1) {
            evaluatePredefinedExpressions();
        } else if (option == 2) {
            scanner.nextLine(); // consume the newline character

            System.out.print("Enter a boolean expression: ");
            String customExpression = scanner.nextLine();
            boolean result = eval(customExpression);

            System.out.println("Result: " + result + "\tExpected: " + evaluateJsBooleanExpression(customExpression));
        } else {
            System.out.println("Invalid option. Exiting...");
        }

        scanner.close();
    }

    private static void evaluatePredefinedExpressions() {
        String[] expressions = {
                "2>0&&-1>-2||-1>0",
                "2>=2.0&&2<=1.0||3>=3.0",
                "5-1>=4.0||(5-1<=4.0&&4-2>2.0)",
                "5-1<4.0||(5-1>4.0&&5-1<=4.0)",
                "-2>11.0||(26>25.0&&124<125.0)",
                "false||(false&&124<125.0)",
                "1-2>1.0||(1-3>=-2.0&&2>1.0&&3>=3.0)",
                "1/3>0.33&&(3/2<=1.5&&(true && 1==1 && (true && !false && 3-2==1)))" // sample inner parenthesis
        };

        int successfulTests = 0;
        int failedTests = 0;

        for (String expression : expressions) {
            boolean expected = evaluateJsBooleanExpression(expression);
            boolean result = eval(expression);

//            System.out.println("Result: " + result + " => Expression: " + expression);
            System.out.println("Result: " + result + "\tExpected: " + evaluateJsBooleanExpression(expression) + "\tExpression: " + expression);

            if (result == expected) {
                successfulTests++;
            } else {
                failedTests++;
            }
        }
        System.out.println();

        if (failedTests == 0) {
            System.out.println("All tests passed successfully!");
        } else {
            System.out.println(successfulTests + " tests passed successfully.");
            System.out.println(failedTests + " tests failed.");
        }
    }

    static boolean eval(String expression) {
        // standardize logical operators
        expression = expression.replaceAll("\\|\\|", "|").replaceAll("&&", "&");
        // remove spaces from the expression
        expression = expression.replaceAll("\\s", "");

        // Check if the expression contains only valid characters
        if (!expression.matches("[()0-9+\\-*/><=!&|." + Pattern.quote("true") + Pattern.quote("false") + "]+")) {
            throw new IllegalArgumentException("Invalid characters in expression: " + expression);
        }
        try {
            return evaluateExpressionHelper(expression);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean evaluateExpressionHelper(String expression) {
        List<String> expressions = getExpressions(expression);
        Object[] result = new Object[expressions.size()];

        for (int i = 0; i < expressions.size(); i++) {
            if (expressions.get(i).length() > 1 && (expressions.get(i).contains("|") || expressions.get(i).contains("&"))) {
                result[i] = evaluateExpressionHelper(expressions.get(i));
            } else if (expressions.get(i).length() == 1) {
                result[i] = expressions.get(i);
            } else {
                result[i] = evaluateExpression(expressions.get(i));
            }
        }

        return evaluateBooleanExpressions(result);
    }

    private static boolean evaluateBooleanExpressions(Object[] o) {
        boolean result = false;
        for (int i = 1; i < o.length; i += 2) {
            if (o[i].equals("&")) {
                result = (boolean) o[i - 1] && (boolean) o[i + 1];
            } else {
                result = (boolean) o[i - 1] || (boolean) o[i + 1];
            }
        }
        return result;
    }

    private static List<String> getExpressions(String expression) {
        List<String> expressions = new ArrayList<>();
        if (expression.charAt(0) == '(' && expression.charAt(expression.length() - 1) == ')') {
            expression = expression.substring(1, expression.length() - 1);
        }

        int startIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ((expression.charAt(i) == '|' || expression.charAt(i) == '&') && checkParenthesis(expression.substring(startIndex, i))) {
                expressions.add(expression.substring(startIndex, i));
                expressions.add(String.valueOf(expression.charAt(i)));
                startIndex = i + 1;
            }
        }
        expressions.add(expression.substring(startIndex)); // last expression
        return expressions;
    }

    private static boolean evaluateExpression(String s) {
        if (s.contains("(") && s.contains(")")) {
            s = s.replaceAll("[()]", "");
        }

        if (s.equals("true") || s.equals("false")) {
            return Boolean.parseBoolean(s);
        } else if (s.equals("!true")) {
            return false;
        } else if (s.equals("!false")) {
            return true;
        } else if (s.contains("<=")) {
            String[] tokens = s.split("<=");
            return getValue(tokens[0]) <= getValue(tokens[1]);
        } else if (s.contains(">=")) {
            String[] tokens = s.split(">=");
            return getValue(tokens[0]) >= getValue(tokens[1]);
        } else if (s.contains("<")) {
            String[] tokens = s.split("<");
            return getValue(tokens[0]) < getValue(tokens[1]);
        } else if (s.contains(">")) {
            String[] tokens = s.split(">");
//            var value1 = tokens[0].contains(".") ? getValue(tokens[0]) : (int) getValue(tokens[0]);
//            var value2 = tokens[1].contains(".") ? getValue(tokens[1]) : (int) getValue(tokens[1]);
//            return value1 > value2; // for java (1/3>0.33)
            return getValue(tokens[0]) > getValue(tokens[1]);
        } else if (s.contains("==")) {
            String[] tokens = s.split("==");
            return getValue(tokens[0]) == getValue(tokens[1]);
        } else {
            String[] tokens = s.split("!=");
            return getValue(tokens[0]) != getValue(tokens[1]);
        }
    }

    private static double getValue(String token) {
        if (token.contains("+")) {
            String[] tokens = token.split("\\+");
            return getValue(tokens[0]) + getValue(tokens[1]);
        } else if (token.substring(1).contains("-")) { // substring(1) to remove the "-" for negative numbers
            String[] tokens = token.split("-");
            return getValue(tokens[0]) - getValue(tokens[1]);
        } else if (token.contains("*")) {
            String[] tokens = token.split("\\*");
            return getValue(tokens[0]) * getValue(tokens[1]);
        } else if (token.contains("/")) {
            String[] tokens = token.split("/");
            return getValue(tokens[0]) / getValue(tokens[1]);
        } else {
            return Double.parseDouble(token);
        }
    }

    private static boolean checkParenthesis(String substring) {
        int openParenthesis = substring.length() - substring.replaceAll("\\(", "").length();
        int closeParenthesis = substring.length() - substring.replaceAll("\\)", "").length();
        return openParenthesis == closeParenthesis;
    }


    // method 2
    private static boolean evaluateJsBooleanExpression(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        if (engine != null) {
            try {
                Object result = engine.eval(expression);
                return (boolean) result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("JavaScript engine not found!");
        }
        return false;
    }
}
