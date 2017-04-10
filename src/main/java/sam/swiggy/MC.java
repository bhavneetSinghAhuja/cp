package sam.swiggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MC {

    private static String highstOrderInLastKMinutes;

    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s+");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static HashSet<String> allSubsets = new HashSet<>();

    private static final String token = " ";

    public static void main(String[] args) throws IOException {
        System.out.println("Add the value of minutes");
        BufferedReader br = getBufferedReader();
        String line = br.readLine();
        Integer k = getIntegerFromString(line);
        System.out.println("Select the following options:-");
        System.out.println("1:- For adding a new order");
        System.out.println("2:- For printing highest value order in last k minutes");
        System.out.println("3:- exit");

        Integer option;
        while (true) {
            line = br.readLine();
            option = getIntegerFromString(line);
            if (option == 1) {
                System.out.println("Add timestamp and cost with space in between. For ex:- ");
                line=br.readLine();
                addNewOrder(line);

            } else if (option == 2) {
                System.out.println("Highest order in last k minutes:- " + getHighstOrderInLastKMinutes());
            } else if (option == 3) {
                System.out.println("Exiting System");
                System.exit(1);
            } else {
                System.out.println("Wrong input:- " + option);
            }
        }

    }

    private static void addNewOrder(String line) {

    }

    public static String getHighstOrderInLastKMinutes() {
        return highstOrderInLastKMinutes;
    }
}
