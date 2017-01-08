package problems.codingtest.skyscanner;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Task1 {
    public Task1() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _count = Integer.parseInt(in.nextLine());
        OutputMostPopularDestination(_count, in);
    }

    static void OutputMostPopularDestination(int count, Scanner in) {
        Hashtable destinationMap = new Hashtable();

        for(int mostSearchedDestination = 0; mostSearchedDestination < count; ++mostSearchedDestination) {
            String searchedNumber = in.nextLine();
            if(destinationMap.containsKey(searchedNumber)) {
                destinationMap.put(searchedNumber, Integer.valueOf(((Integer)destinationMap.get(searchedNumber)).intValue() + 1));
            } else {
                destinationMap.put(searchedNumber, Integer.valueOf(1));
            }
        }

        String var7 = "";
        int var8 = 0;
        Iterator var5 = destinationMap.keySet().iterator();

        while(var5.hasNext()) {
            String destination = (String)var5.next();
            if(var8 < ((Integer)destinationMap.get(destination)).intValue()) {
                var7 = destination;
                var8 = ((Integer)destinationMap.get(destination)).intValue();
            }

            if(var8 == ((Integer)destinationMap.get(destination)).intValue()) {
                var7 = var7 + "," + destination;
            }
        }

    }
}
