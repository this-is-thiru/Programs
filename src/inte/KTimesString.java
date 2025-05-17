package inte;

import java.util.Stack;

public class KTimesString {
    public static String kTimesString(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                integerStack.push(ch - '0');
            } else if (ch == '(') {
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
            } else if (ch == ')') {
                int times = integerStack.pop();
                String tempStr = String.valueOf(currentString).repeat(times);
                currentString = new StringBuilder(tempStr);

//                // prev string
                String temp = stringStack.pop();
                temp += currentString.toString();
//                stringStack.push(temp);
                currentString = new StringBuilder(temp);
            } else {
                currentString.append(ch);
            }
        }

        stringStack.pop();
        return currentString.toString();
    }

    public static void main(String[] args) {
//        String str = "3(a2(b))";
        String str = "2(abc)";
        System.out.println(kTimesString(str));
    }
}
