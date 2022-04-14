import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day2 {

public static void main(String[] args) throws FileNotFoundException {
    int ok = 0;
    int min = 0;
    int max = 0;
    char rule = 'a';
    String password ="";
    String password2 ="";
    File myObj = new File("input2.txt");
    Scanner myReader = new Scanner(myObj);

    while (myReader.hasNextLine()){
        try {
            password=myReader.nextLine();
            min =  Integer.parseInt(password.substring(0,password.indexOf('-')));
            max =  Integer.parseInt(password.substring(password.indexOf('-')+1,password.indexOf(':')-2));
            rule = password.charAt(password.indexOf(':')-1);
            password2 = password.substring(password.indexOf(':')+2);

            if(password2.charAt(min-1)==rule&&password2.charAt(max-1)!=rule){
                ok++;
            }
            else if (password2.charAt(min-1)!=rule&&password2.charAt(max-1)==rule){
                ok++;
            }


        }catch (InputMismatchException e){
            System.out.println("penis");
        };
    }
    System.out.println(ok);

}
}

