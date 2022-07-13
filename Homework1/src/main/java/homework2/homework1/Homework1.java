package homework2.homework1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int[] input = new int[20];
        boolean select;
        int assumingNumber;
        int generatedNumber;
        int whileIteration = 0;
        int reverseArraySize;

        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        System.out.println("***********************\n* Let the game begin! *\n***********************");

        do {
            System.out.println("\n\nGenerated number is ??");
            generatedNumber = rnd.nextInt(100);

            do {
                System.out.print("Please enter the number: ");

                assumingNumber = in.nextInt();
                input[whileIteration] = assumingNumber;
                whileIteration++;
                reverseArraySize=whileIteration;

                if (assumingNumber>generatedNumber) {
                    System.out.println("Your number is too big, please try again.");
                } else if (assumingNumber<generatedNumber) {
                    System.out.println("Your number is too small. Please, try again");
                } else if (assumingNumber==generatedNumber) {
                    System.out.println("\n\n*************************\n* Congratulations, "+ name+" *\n*************************");
                }
            }while(generatedNumber!=assumingNumber);

            select = true;
            if (select) {
                System.out.print("\nDo you want to play again?\nYES - press 1    ||    NO  - press 0:  ");
                int selectNum = in.nextInt();

                if (selectNum == 0) {
                    int [] view = Arrays.copyOfRange(input,0,reverseArraySize);
                    int [] reversedView = new int[reverseArraySize];
                    Arrays.sort(view);

                    for (int i = 0; i <= view.length-1; i++) {
                        reversedView[i] =  view[view.length-1-i];
                    }

                    System.out.println("\n\nYour inputs: "+ Arrays.toString(reversedView));

                    System.out.println("\n\n***************************\n* Game has been finished! *\n***************************");
                    break;
                }
            }
        }while (true);
    }
}
