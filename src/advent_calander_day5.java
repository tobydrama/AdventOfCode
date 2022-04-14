import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day5 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String,Double> seatID = new HashMap<>();
        HashSet<Double> seatNum = new HashSet<>();
        File myObj = new File("jakobInput5.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()){
            try {
                String seat = myReader.nextLine();
                double rowsTop=127;
                double rowsBot=0;
                double row=0;
                double columnsTop=7;
                double columnsBot=0;
                double column=0;
                for(int i=0; i<seat.length();i++){
                    if(seat.charAt(i)=='F'){
                        if(seat.charAt(i+1)!='F'&&seat.charAt(i+1)!='B'){
                            row=rowsBot;
                        }
                        else {
                            rowsTop=Math.floor((rowsTop+rowsBot)/2);
                        }
                    }
                    else if(seat.charAt(i)=='B'){
                        if(seat.charAt(i+1)!='F'&&seat.charAt(i+1)!='B'){
                            row=rowsTop;
                        }
                        else {
                            rowsBot=Math.ceil((rowsTop+rowsBot)/2);
                        }
                    }
                    else if(seat.charAt(i)=='L'){
                        if(i==seat.length()-1){
                            column=columnsBot;
                        }
                        else {
                            columnsTop=Math.floor((columnsTop+columnsBot)/2);
                        }
                    }
                    else{
                        if(i==seat.length()-1){
                            column=columnsTop;
                        }
                        else {
                            columnsBot=Math.ceil((columnsTop+columnsBot)/2);
                        }
                    }

                }
                seatID.put(seat,(row*8+column));
                seatNum.add((row*8+column));

            }catch (InputMismatchException e){
                System.out.println("penis");
            };
        }
        double samll=100;
        for (String seat:seatID.keySet()) {
            if(seatID.get(seat)<=samll){
                samll=seatID.get(seat);
            }
        }
        //System.out.println(samll);


        for(double i=13.0;i<859.0;i++){
            if(!seatNum.contains(i)){
                System.out.println(i);
            }
        }


        /*
        double a = 0.0;
        for (String c:seatID.keySet()) {
            if(seatID.get(c)>=a){
                a=seatID.get(c);
            }
        }
        System.out.println(a);

         */
    }
}
