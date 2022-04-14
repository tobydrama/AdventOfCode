import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day1 {
    public static void main(String[] args) throws FileNotFoundException {
        HashSet<Integer> number = new HashSet<>();
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
        int a=0;
        int b=0;
        int c=0;

        while (myReader.hasNextLine()){
            try {
                number.add(myReader.nextInt());
            }catch (InputMismatchException e){
                System.out.println("penis");
            };
        }
        /*
        for (int i:number){
            if(number.contains(2020-i)){
                a=i;
                b=2020-i;
            }
        }

        System.out.println(a*b);
        */
        for(int i :number){
            for(int j:number){
                if(number.contains(2020-i-j)){
                    a=i;
                    b=j;
                    c=2020-i-j;
                }
            }
        }
        System.out.println(a*b*c);
    }
}
