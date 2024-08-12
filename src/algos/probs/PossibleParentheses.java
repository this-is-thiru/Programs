package algos.probs;

import java.util.ArrayList;
import java.util.List;

public class PossibleParentheses {

    private static void helper(String str, int num1, int num2, int n, List<String> list) {

        if (num1 == n && num1 == num2) {
            list.add(str);
            return;
        }

        if (num1 > n || num2 > n) {
            return;
        }

        if (num1 > num2) {
            helper(str + "(", num1 + 1, num2, n, list);
            helper(str + ")", num1, num2 + 1, n, list);
        } else {
            helper(str + "(", num1 + 1, num2, n, list);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String init = "";
        List<String> ans = new ArrayList<>();
        helper(init, 0, 0, n, ans);

        System.out.print("Printing all possible valid parenthesis of size " + 2 * n + ": ");
        ans.forEach(str -> System.out.print(str + " "));
    }
}
