import java.util.*;
import java.io.*;
public class NameFunctions {

public static String RandomName (String f) throws FileNotFoundException {
    File file = new File(f);        
    Scanner sc = new Scanner(file);
            Scanner sc1 = new Scanner(file);
            ArrayList<Integer> timesUsed = new ArrayList<Integer>();
            ArrayList<String> names = new ArrayList<String>();
            int totalPeople = 0;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                //System.out.println(str.substring(str.indexOf("-")+1, str.length()));
                timesUsed.add(Integer.parseInt(str.substring(str.indexOf(":")+1, str.length())));
            }
            //System.out.println(Arrays.toString(timesUsed.toArray()));
                while (sc1.hasNextLine()) {
                String str = sc1.nextLine();
                //System.out.println(str.substring(0, str.indexOf("-")));
                names.add(str.substring(0, str.indexOf(":")));
            }
            //System.out.println(names);

            for (int i = 0; i < timesUsed.size(); i++) {
                totalPeople += timesUsed.get(i);
            }

            Random randomNum = new Random();
            int result = randomNum.nextInt(totalPeople - 1) + 1;
            //System.out.println(result);
            //int randomNum = ThreadLocalRandom.current().nextInt(1, totalPeople + 1);
            int currentSum = 0;
            String name = "";
           for (int i = 0; i < timesUsed.size(); i++) {
            currentSum += timesUsed.get(i);
               if (currentSum - result >= 0 && currentSum - result < timesUsed.get(i)) {
                name = names.get(i);
                break;
               }
               
                }
            sc.close();
            sc1.close();
            return name;
    }

    public static void main (String []args) throws FileNotFoundException {
        System.out.println(RandomName("AfricanAmericanSurnames.txt"));
    }
}