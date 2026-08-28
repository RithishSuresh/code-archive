import java.util.*;

public class TextCalculator {

    static boolean validateExpression(String expr) {
        int balance = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!(Character.isDigit(c) || "+-*/() ".indexOf(c) >= 0)) return false;
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    static int parseAndEvaluate(String expr, StringBuilder steps) {
        expr = expr.replaceAll(" ", "");
        while (expr.contains("(")) {
            int close = expr.indexOf(")");
            int open = expr.lastIndexOf("(", close);
            String sub = expr.substring(open + 1, close);
            int val = parseAndEvaluate(sub, steps);
            expr = expr.substring(0, open) + val + expr.substring(close + 1);
            steps.append("After solving (").append(sub).append("): ").append(expr).append("\n");
        }
        return evaluateFlat(expr, steps);
    }

    static int evaluateFlat(String expr, StringBuilder steps) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < expr.length();) {
            if (Character.isDigit(expr.charAt(i))) {
                int j = i;
                while (j < expr.length() && Character.isDigit(expr.charAt(j))) j++;
                numbers.add(Integer.parseInt(expr.substring(i, j)));
                i = j;
            } else {
                ops.add(expr.charAt(i));
                i++;
            }
        }
        for (int i = 0; i < ops.size();) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                int a = numbers.get(i), b = numbers.get(i+1);
                int res = (op == '*') ? a*b : a/b;
                steps.append(a).append(" ").append(op).append(" ").append(b).append(" = ").append(res).append("\n");
                numbers.set(i, res);
                numbers.remove(i+1);
                ops.remove(i);
            } else i++;
        }
        while (!ops.isEmpty()) {
            char op = ops.remove(0);
            int a = numbers.remove(0), b = numbers.remove(0);
            int res = (op == '+') ? a+b : a-b;
            steps.append(a).append(" ").append(op).append(" ").append(b).append(" = ").append(res).append("\n");
            numbers.add(0, res);
        }
        return numbers.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mathematical expressions (type 'exit' to quit):");
        while (true) {
            String expr = sc.nextLine();
            if (expr.equalsIgnoreCase("exit")) break;
            if (!validateExpression(expr)) {
                System.out.println("Invalid Expression!");
                continue;
            }
            StringBuilder steps = new StringBuilder();
            steps.append("Original Expression: ").append(expr).append("\n");
            int result = parseAndEvaluate(expr, steps);
            steps.append("Final Result: ").append(result).append("\n");
            System.out.println(steps);
        }
    }
}
