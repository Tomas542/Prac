import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(duplicates("foobar"));
        System.out.println(histogram(new int[] {1,10, 3}, '+'));
        System.out.println(primorial(8));
        System.out.println(capSpace("ILoveMyTeaPot"));
        System.out.println(isTriplet(12,13,5));
        System.out.println(littleBig(28));
    }

    public static int duplicates (String str) {
        ArrayList<Object> letters = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!(letters.contains(str.charAt(i)))) {
                letters.add(str.charAt(i)); //добавляем наш символ в список
            }
            else counter++; //символ в списке есть, увеличиваем счёт
        }

        return counter;
    }

    public static String histogram (int[] num, char ch) {
        String str = "";
        for (int i = 0; i < num.length; i++) {

            for (int j = 0; j < num[i]; j++) {
                str += ch; //добавляем символы в строку, пока не кончится
            }

            str += "\n"; //новая строка
        }
        return str;
    }

    public static int primorial(int num) {
        if (num == 0) {return 0;}
        int answer = 2; //первое простое число в задаче
        int currentNum = 3; // первое простое число после двух
        int i = 1;

        while (i < num) {
            boolean check = true;
            for (int j = 2; j < currentNum / 2; j++) {
                if (currentNum % j == 0){
                    check = false; //проверка на простое число
                    break;
                }
                }
                if (check) {
                    answer *= currentNum; //умножаем простые числа
                    i ++;
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
                ans += str.substring(ind, i) + " " + Character.toLowerCase(str.charAt(i)); //добавляем все символы строки до заглавной
                i ++;
                ind = i; //запоминаем индекс последней заглавной буквы
            }

            if (i == str.length() - 1) {
                ans += str.substring(ind); //добавляем конец изначальной строки
            }
        }

        return ans;
    }

    public static boolean isTriplet (int a, int b, int c) {
        return a * a + b * b == c * c || a * a + c * c == b * b || a * a == b * b + c * c; //проверка на тройку Пифагора в лоб
    }

    public static int littleBig (int num) {
        int little = 5;
        int big = 100;
        if (num % 2 == 0) { //чётные меняются как 100 * 2 ^ (num / 2 - 1)
            int n = num / 2 - 1;
            return big * (int)Math.pow(2, n);
        }
        else{ //нечётные меняются как 5 + num / 2
            return little + num / 2;
        }
    }
}
