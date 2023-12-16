// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.lang.model.type.NullType;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ScannerException, NumberException, LeghtExceptin {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String input = scanner.nextLine().replaceAll(" ", "");
        try {
            calc(input);
        }
        catch (ArithmeticException e){
            System.out.println("На 0 делить нельзя!");
        }

        System.out.println(calc(input));
    }

    public static String calc (String input) throws ScannerException, NumberException, LeghtExceptin  {

        String [] args = input.split("[+-/*]");

        if(args.length<2){
            throw new LeghtExceptin("Введенная строка не является математической операцией");
        }
        else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            int c=0;
            Pattern p = Pattern.compile("\\d+[+-/*]\\d+");
            Matcher m = p.matcher(input);
            if (m.matches() == true) {
                if (a >= 0 && a <= 10 && b >= 0 && b <= 10) {
                    if (input.indexOf(42) == 1 || input.indexOf(42) == 2) {
                        c = a * b;
                    } else if (input.indexOf(47) == 1 || input.indexOf(47) == 2) {
                        c = a / b;
                    } else if (input.indexOf(43) == 1 || input.indexOf(43) == 2) {
                        c = a + b;
                    } else if (input.indexOf(45) == 1 || input.indexOf(45) == 2) {
                        c = a - b;
                    }
                    String result = Integer.toString(c);
                    return result;
                } else {
                    throw new NumberException("Один из введенных операндов не попадает в диапазон от 0 до 10");
                }
            } else {
                throw new ScannerException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) или введенные значения не являются целочисленными");
            }
        }

    }
}