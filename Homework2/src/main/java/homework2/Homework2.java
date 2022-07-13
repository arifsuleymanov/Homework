package homework2;

import java.util.Random;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        System.out.print("Enter the size for 2D Array: ");
        int size = in.nextInt();
        String[][] array = new String[size][size];
        String line = "-";
        int min = 1;
        int max = size - 1;
        int found = 0;

        System.out.println("All set. Get ready to rumble!");
        int numberOfRandoms = rnd.nextInt(size);

        // initializing empty front array
        String[][] arrayForView = new String[size][size];
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                arrayForView[0][j] = String.valueOf(j);
                arrayForView[i][0] = String.valueOf(i);
                for (int k = 1; k <= size - 1; k++) {
                    for (int l = 1; l <= size - 1; l++) {
                        arrayForView[k][l] = line;
                    }
                }
            }
        }

        // initializing empty back array
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                array[0][j] = String.valueOf(j);
                array[i][0] = String.valueOf(i);
                for (int k = 1; k <= size - 1; k++) {
                    for (int l = 1; l <= size - 1; l++) {
                        array[k][l] = line;
                    }
                }
            }
        }

        // print view array
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                String frontView = String.format(" %s |", array[i][j]);
                System.out.print(frontView);
            }
            System.out.println();
        }

        // adding randoms to back array
        for (int i = 1; i <= numberOfRandoms; i++) {
            array[rnd.nextInt(max - min) + min][rnd.nextInt(max - min) + min] = "o";
        }
        System.out.println("========================");

        // TODO FOR MENTORS: UNCOMMENT THIS FIELD TO SEE BACK OF ARRAY
//         print back array
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                String backView = String.format(" %s |", array[i][j]);
                System.out.print(backView);
            }
            System.out.println();
        }

        // checking process
        for (int k = 1; k <= size - 1; k++) {
            for (int l = 1; l <= size - 1; l++) {
                System.out.print("Enter indexes of 2D array: ");
                int a = in.nextInt();
                int b = in.nextInt();
                if (array[a][b].equals("o")) {
                    arrayForView[a][b] = "x";
                    found++;
                    print(arrayForView, size);
                } else {
                    arrayForView[a][b] = "*";
                    print(arrayForView, size);
                }

                if (found == numberOfRandoms) {
                    System.out.println("You have won!");
                    print(arrayForView, size);
                    k=size-1;
                    break;
                }
            }
        }
    }

    // print the view array
    public static void print(String[][] arrayForView, int size) {
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                System.out.printf(" %s |", arrayForView[i][j]);
            }
            System.out.println();
        }
    }
}

