package algos.fifty.twopointers;

public class ValidPalindrome {
    private static boolean isValidPalindrome(String s) {
        if (s == null || s.length() ==0) {
            return true;
        }

        int left = 0, right = s.length()-1;
        while (left<=right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (s.charAt(left) != s.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean ans = isValidPalindrome(str.toLowerCase());
        System.out.println(ans);
    }
}
