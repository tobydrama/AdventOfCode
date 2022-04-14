import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class advent_calander_day6 {
    public static void doStuff(String groups,HashMap<Character,Integer> yesNo){
        for(int i=0; i<groups.length();i++){
            Character a = groups.charAt(i);
            if(!yesNo.containsKey(a)){
                yesNo.put(a,1);
            }
            else {
                yesNo.put(a,yesNo.get(a)+1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Integer,Integer> groupCount = new HashMap<>();
        HashMap<Character,Integer> yesNo = new HashMap<>();
        int group=1;
        File myObj = new File("jakobInput6.txt");
        Scanner myReader = new Scanner(myObj);
        int peopleInAgroup=0;
        while (myReader.hasNextLine()){
            try {
                String groups = myReader.nextLine();
                if(!myReader.hasNextLine()){//fixed last group issus
                    int b=0;
                    doStuff(groups,yesNo);
                    peopleInAgroup++;
                    for(Character a:yesNo.keySet()){
                        if(yesNo.get(a)==peopleInAgroup){
                            b++;
                        }
                    }
                    groupCount.put(group,b);
                    group++;
                    yesNo = new HashMap<>();
                    continue;
                }
                if(groups.isEmpty()){//when one group is finished
                    int b=0;
                    for(Character a:yesNo.keySet()){
                        if(yesNo.get(a)==peopleInAgroup){
                            b++;
                        }
                    }
                    peopleInAgroup=0;
                    groupCount.put(group,b);
                    group++;
                    yesNo = new HashMap<>();
                    continue;
                }
                doStuff(groups,yesNo);
                peopleInAgroup++;


            }catch (InputMismatchException e){
                System.out.println("penis");
            };
        }
        int a=0;
        for (int i:groupCount.keySet()) {
            //System.out.println(groupCount.get(i));
            a+=groupCount.get(i);
        }
        //System.out.println("Reeeeeeeee");
        System.out.println(a);

    }
}


