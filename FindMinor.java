//First we need to import the Scanner class in order to get imputs from the user
import java.util.Scanner;
// Here we start building our class by its declaration
public class FindMinor {
    public static void main(String[] args) {
        //initialisation of a new scanner 
        Scanner s = new Scanner(System.in);
        // This line ask to the user to input the numbers separated by an space
        System.out.println("Please write the numbers separated by an space:");
        //This line builds an array where the numbers are stored. The method split() helps the system to identify the components of the list 
        String[] numberList= s.nextLine().split(" ");
        // We create a variable named minor that will store the first element of the numberList array
        // this is used to store the minor number that will be found by the for loop
        int minor = Integer.parseInt(numberList[0]);
        // The for loop will naviage through all the elements of the numberList array and will compare them one by one
        // to then asign the minor number to the variable minor
        for (int i = 1; i < numberList.length; i++) {
            int num = Integer.parseInt(numberList[i]);
            if (num < minor) {
                minor = num;
            }
        }
        // Displays the lower number
        System.out.println(minor);
        // Close the scanner
        s.close();
    }
}
