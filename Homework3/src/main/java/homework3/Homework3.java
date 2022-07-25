package homework3;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        boolean retry = false;
        String[][] schedule = new String[m][n];
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        addDaysOfWeek(schedule, m, daysOfWeek);
        addTasks(schedule);
        printTasks(schedule, n, daysOfWeek, false);
    }

    // add days of the week
    public static void addDaysOfWeek(String[][] schedule, int m, String[] daysOfWeek) {
        for (int i = 0; i <= m - 1; i++) {
            schedule[i][0] = daysOfWeek[i];
        }
    }

    // add tasks day of the week
    public static void addTasks(String[][] schedule) {
        schedule[0][1] = "go to the courses";
        schedule[0][2] = "have a sport";
        schedule[1][1] = "buy a new store";
        schedule[1][2] = "visit a dostor";
        schedule[2][1] = "argue with a lawyer";
        schedule[2][2] = "read the books";
        schedule[3][1] = "travel to Astara";
        schedule[3][2] = "go to the theatre";
        schedule[4][1] = "buy a new store";
        schedule[4][2] = "read the books";
        schedule[5][1] = "go to the cinema";
        schedule[5][2] = "have a sport";
        schedule[6][1] = "go to the courses";
        schedule[6][2] = "visit a dostor";

    }

    // print the tasks of the certain day of the week
    public static void printTasks(String[][] schedule, int n, String[] daysOfWeek, boolean retry) {
        retry = true;
        while (retry) {
            Scanner in = new Scanner(System.in);
            System.out.print("Please, input the day of the week: ");
            String dayy = in.nextLine().toLowerCase();
            String firstSymbol = String.valueOf(dayy.charAt(0)).toUpperCase();
            String day = firstSymbol + dayy.substring(1);

            switch (day) {
                case "Sunday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf("%s; ", schedule[0][i]);
                    }
                    retry = false;
                    break;
                case "Monday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf(" %s; ", schedule[1][i]);
                    }
                    retry = false;
                    break;
                case "Tuesday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf(" %s; ", schedule[2][i]);
                    }
                    retry = false;
                    break;
                case "Wednesday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf(" %s; ", schedule[3][i]);
                    }
                    retry = false;
                    break;
                case "Thursday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf(" %s; ", schedule[4][i]);
                    }
                    retry = false;
                    break;
                case "Friday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf(" %s; ", schedule[5][i]);
                    }
                    retry = false;
                    break;
                case "Saturday":
                    System.out.printf("Your task for %s: ", day);
                    for (int i = 1; i <= n - 1; i++) {
                        System.out.printf(" %s; ", schedule[6][i]);
                    }
                    retry = false;
                    break;
                default:
                    checker(schedule, daysOfWeek, day, retry);
                    if (day.equals("Exit")) {
                        retry = false;
                        break;
                    } else if (day.contains("change")) {
                        retry = false;
                        break;
                    }
            }
        }
    }

    // checking the String and updating task
    public static void checker(String[][] schedule, String[] daysOfWeek, String day, boolean retry) {
        Scanner in = new Scanner(System.in);
        // checking
        for (int i = 0; i <= 6; i++) {
            if (!day.equals(daysOfWeek[i])) {
                retry = true;
                continue;
            }
        }

        // operation with change
        for (int i = 0; i <= 6; i++) {
            if (!day.contains("Exit")) {
                String updatedDay = day.toLowerCase();
                String change = updatedDay.substring(0, 7);
                String firstSymbol = String.valueOf(day.charAt(7)).toUpperCase();
                String concatStrings = change + firstSymbol + day.substring(8);
                if (concatStrings.equals("change " + daysOfWeek[i])) {
                    System.out.print("You have " + (schedule[i].length - 1) + " tasks. \nPlease, input the index of task to change: ");
                    int taskNumber = in.nextInt();
                    System.out.print("Please, input new tasks for " + daysOfWeek[i] + ". ");
                    in.nextLine();
                    schedule[i][taskNumber] = in.nextLine();
                    System.out.println("Task updated for " + daysOfWeek[i]);
                    retry = false;
                    break;
                }
            }
        }

        if (day.equals("Exit")) {
            retry = false;
        } else if (day.contains("Change")) {
            retry = false;
        } else {
            System.out.println("Sorry, I don't understand you, please try again.");
        }
    }
}


