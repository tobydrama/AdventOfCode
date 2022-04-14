import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day7 {


        public static void main(String[] args) throws FileNotFoundException {


            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> bags =new ArrayList<>();
            HashMap<String,Boolean> bagsOK= new HashMap<>();

            while (myReader.hasNextLine()){
                try {
                    String bag = myReader.nextLine();
                    ArrayList<String> bagsTemp = new ArrayList<>();
                    if(bag.contains("shiny gold bag")){
                        String a = bag.substring(0,bag.indexOf("contain")-1);
                        bagsOK.put(a,true);
                    }
                    String temp = bag;
                    while (!temp.isEmpty()){
                        if(temp.contains("contain")){
                            String asd = temp.substring(0,temp.indexOf("contain")-1);
                            temp=temp.substring(temp.indexOf("contain")+10);
                            bagsTemp.add(asd);
                        }
                        if(temp.contains(",")){
                            String b = temp.substring(0,temp.indexOf(","));
                            temp = temp.substring(temp.indexOf(",")+3);
                            bags.add(b);
                        }

                    }




                }catch (InputMismatchException e){
                    System.out.println("penis");
                };
            }


        }
    }




