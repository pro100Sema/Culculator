import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
        static int a,b;
        static char operation;
        static int result;
    public static void main(String[] args)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическую операцию");
        String str = scanner.nextLine();
        char [] chars = new char[10];
        for (int i = 0;i<str.length();i++){
            chars[i]= str.charAt(i);
            if (chars[i] =='+'){
                operation = '+';
            }
            if (chars[i] == '-') {
                operation = '-';
            }
            if (chars[i] == '*') {
                operation = '*';
            }
            if (chars[i] == '/') {
                operation = '/';
            }
        }
        String charsString = String.valueOf(chars);
        String[] blacks = charsString.split("[+-/*]");
        String s = blacks[0];
        String s1 = blacks[1];
        String s3 = s1.trim();
        a = romanToNumber(s);
        b = romanToNumber(s3);
        if (a<0 && b< 0) {
            result = 0;
        } else {
            result = calculated(a,b,operation);
            String resultRoman = convertNumToRoman(result);
            System.out.println("Output");
            System.out.println(resultRoman);

        }

        a = Integer.parseInt(s);
        b = Integer.parseInt(s3);
        result = calculated(a,b,operation);
        System.out.println("Output");
        System.out.println(result);
    }
    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"0", "I", "II", "III", "VI", "V", "VI", "VII", "VIII", "XI", "X"};
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")){
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
               return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            }else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("XI")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        }catch (InputMismatchException e) {
            throw new InputMismatchException("Вы ввели неверный формат данных");
        }
        return -1;
    }

    public static int calculated(int a ,int b, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result=a*b;
                break;
            case '/':
                try {
                    result=a/b;
                }catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception :"+e);
                    break;
                }
                break;

        }
        return result;
    }
}
