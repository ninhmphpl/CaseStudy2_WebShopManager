package Input;

import java.time.LocalDate;
import java.util.Scanner;
import String.EditString;

public class Input {
    public static Scanner input = new Scanner(System.in);

    public static int inputInt(String title){
        System.out.print(title);
        try{
            return Integer.parseInt(input.nextLine());
        }catch(Exception e){
            System.out.println(e.getMessage() + "- Illegal, try again!");
            return inputInt(title);
        }
    }

    public static boolean inputChoice(String title){
        char a = inputString(title).charAt(0);
        return switch (a){
            case 'y', 'Y' -> true;
            case 'n', 'N' -> false;
            default -> inputChoice("Illegal, try again! \n" + title);
        };
    }
    public static int inputRange(String title, int min, int max){
        int a = inputInt(title);
        if (a < min || a > max){
            System.out.println("Illegal, try again!");
            return inputRange(title, min, max);
        }else{
            return a;
        }

    }

    public static long inputLong(String title){
        System.out.print(title);
        try{
            return Integer.parseInt(input.nextLine());
        }catch(Exception e){
            System.out.println(e.getMessage() + "- Illegal, try again!");
            return inputInt(title);
        }
    }

    public static float inputFloat(String title){
        System.out.print(title);
        try{
            return Float.parseFloat(input.nextLine());
        }catch(Exception e){
            System.out.println(e.getMessage() + "- Illegal, try again!");
            return inputFloat(title);
        }
    }

    public static String inputString(String title){
        System.out.print(title);
        return input.nextLine();
    }
    public static String inputName(String title){
        return EditString.upperCaseAlphabetOfWord2(inputString(title));
    }
    public static char inputChar(String title){
        System.out.print(title);
        return input.nextLine().charAt(0);
    }
    public static String inputPassword(String title){
        System.out.println("Request from 6 - 32 character:");
        String string = inputString(title);
        if (string.length() < 6 || string.length() > 32){
            System.out.println("Illegal, try again!: ");
            inputPassword(title);
        }
        return string;
    }




    public static LocalDate inputDate(){
        try {
            int day = inputInt("Date: ");
            if(day <= 0 || day > 31 ) throw new Exception("Date Illegal, try again!");
            int month = inputInt("Month: ");
            if((month>12) || (month < 1)) throw new Exception("Month Illegal, try again!");
            int year = inputInt("Year: ");
            if(year<1) throw new Exception("Year Illegal, try again!");
            return LocalDate.of(year,month,day);
        }catch (Exception e){
            System.out.println(e.getMessage()+",Illegal, try again!");
            return inputDate();
        }
    }
}
