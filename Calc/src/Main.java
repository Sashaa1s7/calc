import java.util.Scanner;
//на вход принимаются значения от 1 до 10 то есть однозначные числа и 10 блин,
// поэтому имеется  число1 операция число2, между которыми могут стоять,
// а могут не стоять пробелы..

public class Main {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String mathExpres;
        mathExpres= scan.nextLine();
        // хотелось бы чтобы не возникала ошибка если вдруг чел решил за чем-то поставить пробелы
        // или вообще решил что пробелы это не его
        mathExpres = mathExpres.replace(" ", "");

        System.out.println(calc(mathExpres));

    }

    public static String calc(String args) {
        String[] inputValues = readInput( args);
        String result = "";
        int x = 0, y = 0;
        char op = inputValues[0].charAt(0);

        if(op == '/' || op == '*' || op == '-' || op == '+')
        {
            if ((inputValues[1].equals("1") ||  inputValues[1].equals("2") || inputValues[1].equals("3")
                    || inputValues[1].equals("4") || inputValues[1].equals("5") || inputValues[1].equals("6")
                    || inputValues[1].equals("7") || inputValues[1].equals("8") || inputValues[1].equals("9")
                    || inputValues[1].equals("10") )
                    && (inputValues[2].equals("1") ||  inputValues[2].equals("2") || inputValues[2].equals("3")
                    || inputValues[2].equals("4") || inputValues[2].equals("5") || inputValues[2].equals("6")
                    || inputValues[2].equals("7") || inputValues[2].equals("8") || inputValues[2].equals("9")
                    || inputValues[2].equals("10") ))
            {
                x = Integer.parseInt(inputValues[1]);
                y = Integer.parseInt(inputValues[2]);
                result = result + calculator(x, y, op);
                //System.out.println(calculator(x, y, op));

            }
            else if((inputValues[1].equals("I") ||  inputValues[1].equals("II") || inputValues[1].equals("III")
                    || inputValues[1].equals("IV") ||  inputValues[1].equals("V") || inputValues[1].equals("VI")
                    || inputValues[1].equals("VII") ||  inputValues[1].equals("VIII") || inputValues[1].equals("IX")
                    || inputValues[1].equals("X"))
                    && (inputValues[2].equals("I") ||  inputValues[2].equals("II") || inputValues[2].equals("III")
                    || inputValues[2].equals("IV") ||  inputValues[2].equals("V") || inputValues[2].equals("VI")
                    || inputValues[2].equals("VII") ||  inputValues[2].equals("VIII") || inputValues[2].equals("IX")
                    || inputValues[2].equals("X")))
            {
                x = numberTranslate(inputValues[1]);
                y = numberTranslate(inputValues[2]);

                if (calculator(x, y, op) > 0) {
                    result = "" + numberTranslate23(calculator(x, y, op));
                    //System.out.println(numberTranslate23(calculator(x, y, op)));
                }
                else {
                    result = "throws Exception";
                    //System.out.println("throws Exception");
                }

            }
            else {
                result = "throws Exception";
                //System.out.println("throws Exception");
            }
        }
        else {
            result = "throws Exception";
            //System.out.println("throws Exception");
        }

        return result;
    }


    public static String[] readInput(String mathExpression) {
        String[] inputValues = new String[3];

        inputValues[0] = "";
        inputValues[1] = "";
        inputValues[2] = "";
        char tmp;
        int f = 0;

        for(int i = 0; i < mathExpression.length(); i++ ) {
            tmp =(char) mathExpression.charAt(i);
            if(f == 1 ) {
                inputValues[2] = inputValues[2] + tmp;
            }
            if((tmp == '/'  || tmp == '*' || tmp == '+'|| tmp == '-') && i!=0) {
                inputValues[0] =inputValues[0]+ tmp;
                f = 1;
            }
            if(f == 0) {
                inputValues[1] = inputValues[1] + tmp;
            }
        }

        return inputValues;
    }


    public static int numberTranslate(String number) {
        int num = 0;
        switch (number) {
            case "I":
                num = 1; break;
            case "II":
                num = 2; break;
            case "III":
                num = 3; break;
            case "IV":
                num = 4; break;
            case "V":
                num = 5; break;
            case "VI":
                num = 6; break;
            case "VII":
                num = 7; break;
            case "VIII":
                num = 8; break;
            case "IX":
                num = 9; break;
            case "X":
                num = 10; break;
            default:
                System.out.println("хз что случилось^^!");
        }

        return num;
    }


    public static int calculator(int num1, int num2, char op) {
        int result = 0; // работает только с целыми значит и ответ целый
        if(op == '/') {result = num1 / num2;}
        if(op == '*') {result = num1 * num2;}
        if(op == '-') {result = num1 - num2;}
        if(op == '+') {result = num1 + num2;}

        return result;
    }

    // переводит араб в римск (от 1 до 10)
    public static String numTrans2(int number) {
        String num = "";
        switch (number) {
            case 1:
                num = "I"; break;
            case 2:
                num = "II"; break;
            case 3:
                num = "III"; break;
            case 4:
                num = "IV"; break;
            case 5:
                num = "V"; break;
            case 6:
                num = "VI"; break;
            case 7:
                num = "VII"; break;
            case 8:
                num = "VIII"; break;
            case 9:
                num = "IX"; break;
            case 10:
                num = "X"; break;
            default:
                System.out.println("опс хз что случилось^^!");
        }

        return num;
    }

    // переводит араб в римск (от 1 до 100) блин
    public static String numberTranslate23(int num) {

        String strNum = "";
        if (num <= 10) {
            strNum = numTrans2(num);
        }
        else if (num <= 20 && num > 10) {
            strNum = "X" + numTrans2(num%10);
        }
        else if (num == 20 ) {
            strNum = "XX";
        }
        else if (num <= 30 && num > 20) {
            strNum = "XX" + numTrans2(num%20);
        }
        else if (num < 40 && num > 30) {
            strNum = "XXX" + numTrans2(num%30);
        }
        else if (num == 40) {
            strNum = "XL" ;
        }
        else if (num < 50 && num > 40) {
            strNum = "XL" + numTrans2(num%40);
        }
        else if (num == 50 ) {
            strNum = "L";
        }
        else if (num <= 60 && num > 50) {
            strNum = "L" + numTrans2(num%50);
        }
        else if (num <= 70 && num > 60) {
            strNum = "LX" + numTrans2(num%60);
        }
        else if (num <= 80 && num > 70) {
            strNum = "LXX" + numTrans2(num%70);
        }
        else if (num < 90 && num > 80) {
            strNum = "LXXX" + numTrans2(num%80);
        }
        else if (num == 90) {
            strNum = "XC" ;
        }
        else if (num < 100 && num > 90) {
            strNum = "XC" + numTrans2(num%90);
        }
        else if (num == 100) {
            strNum = "C" ;
        }
        return strNum;
    }
}
