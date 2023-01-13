import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(duplicates("foobar"));
        System.out.println(histogram(new int[] {1,10, 3}, '+'));
        System.out.println(primorial(3));
        System.out.println(capSpace("ILoveMyTeaPot"));
        System.out.println(isTriplet(12,13,5));
        System.out.println(littleBig(5));
        System.out.println(littleBig(6));
        System.out.println(littleBig(4));
        System.out.println(littleBig(28));
    }

    public static int duplicates (String str) {
        ArrayList  letters = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!(letters.contains(str.charAt(i)))) {
                letters.add(str.charAt(i));
            }
            else counter++;
        }
        return counter;
    }

    public static String histogram (int[] num, char ch) {
        String str = "";
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i]; j++) {
                str += ch;
            }
            str += "\n";
        }
        return str;
    }

    public static int primorial(int num) {
        if (num == 0) {return 0;}
        int answer = 2;
        int currentNum = 3; // первое простое число после двух
        boolean check = true;
        for (int i = 1; i < num; i++) {
            for (int j = 2; j < currentNum / 2; j++) {
                if (currentNum % j == 0)
                    check = false;
                }
                if (check) {
                    answer *= currentNum;
                }
            currentNum += 2;
        }
        return answer;
    }

    public static String capSpace (String str) {
        String ans = "";
        int ind = 0;
        for(int i = 1; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                ans += str.substring(ind, i) + " " + Character.toLowerCase(str.charAt(i));
                i ++;
                ind = i;
            }
            if (i == str.length() - 1) {
                ans += str.substring(ind);
            }
        }
        return ans;
    }

    public static boolean isTriplet (int a, int b, int c) {
        return a * a + b * b == c * c || a * a + c * c == b * b || a * a == b * b + c * c;
    }

    public static int littleBig (int num) {
        int little = 5;
        int big = 100;
        if (num % 2 == 0) {
            int n = num / 2 - 1;
            return big * (int)Math.pow(2, n);
        }
        else{
            return little + num / 2;
        }
    }
}
