import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day4 {
public static void penishore(HashMap<String, String> passport, String line, ArrayList a){

    while(!line.isEmpty()){
        String key = line.substring(0,line.indexOf(":"));
        String value ="";
        int lineEnd=0;

        if(line.contains(" ")) {
            value = line.substring(line.indexOf(":") + 1, line.indexOf(" "));
            lineEnd= line.indexOf(" ")+1;
        }
        else {
            value = line.substring(line.indexOf(":") + 1);
            lineEnd= line.length();
        }



        switch (key){
            case "byr":
                int val = Integer.parseInt(value);
                if(val>= 1920 && val <=2002){
                    passport.put(key,value);

                }
                break;
            case "iyr":
                int val2 = Integer.parseInt(value);
                if(val2>= 2010 && val2 <=2020){
                    passport.put(key,value);
                }
                break;
            case "eyr":
                int val3 = Integer.parseInt(value);
                if(val3>= 2020 && val3 <=2030){
                    passport.put(key,value);
                }
                break;
            case "hgt":
                if(value.charAt(value.length()-1)=='n'||value.charAt(value.length()-1)=='m') {
                    int val4 = Integer.parseInt(value.substring(0, value.length() - 2));
                    String height = value.substring(value.length()-2);
                    if (height.equals("in")) {
                        if (val4 >= 59 && val4 <= 76) {
                            passport.put(key, value);
                        }
                    } else {
                        if (val4 >= 150 && val4 <= 193) {
                            passport.put(key, value);
                        }
                    }
                }

                break;
            case "hcl":
                if(value.matches("#[a-fA-F0-9]{6}")){
                    passport.put(key,value);
                }

                break;
            case "ecl":
                if(value.equals("amb")||value.equals("blu")||value.equals("brn")||value.equals("gry")||value.equals("grn")||value.equals("hzl")||value.equals("oth")){
                    passport.put(key,value);
                }
                break;
            case "pid":
                if(value.length()==9){
                    passport.put(key,value);
                }
                break;
            case "cid":
                    passport.put(key,value);
                break;
        }

        line=line.substring(lineEnd);
    }


}

public static void main(String[] args) throws FileNotFoundException {

int pass = 0;

File myObj = new File("input4.txt");
Scanner myReader = new Scanner(myObj);

HashMap<String,String>passport = new HashMap<>();

    ArrayList<String> a = new ArrayList<>();




while (myReader.hasNextLine()) {
    try {
        String line = myReader.nextLine();
        while (!line.isEmpty()) {
            penishore(passport, line,a);
            if(myReader.hasNextLine()) {
                line = myReader.nextLine();
            }
            else{
                line = "";
            }
        }
        if(passport.size()==8){
            pass++;
            passport = new HashMap<>();
        }
        else if(!passport.containsKey("cid")&& passport.size()==7){
            passport = new HashMap<>();
            pass++;
        }
        else{
            passport = new HashMap<>();
        }

    } catch (InputMismatchException e) {
        System.out.println("penis");
}
    ;
}

    for (String a1231231:a) {
        System.out.println(a1231231);
    }
System.out.println(pass);

}
}
