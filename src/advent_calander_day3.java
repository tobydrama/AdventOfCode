import java.io.File;
import java.io.FileNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day3 {
    public static void main(String[] args) throws FileNotFoundException {
        int position = 1;
        int numberOfTreesPassed=0;

        //63
        //254
        //62
        //56
        //30
        File myObj = new File("input3.txt");
        Scanner myReader = new Scanner(myObj);
        String line1 = myReader.nextLine();

        while (myReader.hasNextLine()){
            try {
                String line3 = myReader.nextLine();
                String line2 = myReader.nextLine();
                String skog = line2;
                while (skog.length()<=position) {
                    skog += line2;
                }
                if (skog.charAt(position) == '#') {
                    numberOfTreesPassed++;
                }
                position += 1;

            }catch (InputMismatchException e){
                System.out.println("penis");
            };
        }
        System.out.println(numberOfTreesPassed);
        System.out.println(63*254*62*56*30);

    }
}
