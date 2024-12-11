package gradebook.pkg1;

import java.util.Scanner;

public class Gradebook {

    static double[] mathGrades = null;
    static double[] scienceGrades = null;
    static double[] historyGrades = null;
    static double[] artGrades = null;

    public static void menu() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease choose from one of the following options:\n"
                + "\n1. Initialize a new class"
                + "\n2. Enter/edit grades"
                + "\n3. Display min, max, and average grades"
                + "\n4. Quit\n");
        System.out.print("Type your choice here (1-4): ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                initClass();
                break;
            case 2:
                enterGrades();
                break;
            case 3:
                minMax();
                break;
            case 4:
                System.out.println("Thanks for using gradebook!");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static String initClass() {

        Scanner input = new Scanner(System.in);
        String className = "";
        double[] choiceArray = null;

        System.out.println("\nWhat is the subject of the class you want to initialize?"
                + "\nPlease choose from one of the following options:\n"
                + "\n1. Math"
                + "\n2. Science"
                + "\n3. History"
                + "\n4. Art\n");
        System.out.print("Type your choice here (1-4): ");
        int choice = input.nextInt();

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid entry");

            return initClass();
        }

        else {
            switch (choice) {

                case 1:
                    className = "Math";
                    System.out.print("\nHow many students are in the " + className.toLowerCase() + " class?: ");
                    int classSize = input.nextInt();
                    mathGrades = new double[classSize];
                    choiceArray = mathGrades;
                    break;

                case 2:
                    className = "Science";
                    System.out.print("\nHow many students are in the " + className.toLowerCase() + " class?: ");
                    classSize = input.nextInt();
                    scienceGrades = new double[classSize];
                    choiceArray = scienceGrades;
                    break;

                case 3:
                    className = "History";
                    System.out.print("\nHow many students are in the " + className.toLowerCase() + " class?: ");
                    classSize = input.nextInt();
                    historyGrades = new double[classSize];
                    choiceArray = historyGrades;
                    break;

                case 4:
                    className = "Art";
                    System.out.print("\nHow many students are in the " + className.toLowerCase() + " class?: ");
                    classSize = input.nextInt();
                    artGrades = new double[classSize];
                    choiceArray = artGrades;
                    break;

                default:
                    className = "Unknown";
                    break;
            }
        }

        System.out.println("\nOkay, you have initialized: " + className + " class, with space for "
                + choiceArray.length + " students." +
                "\nWhat would you like to do next?");
        menu();
        return className;
    }

    public static void enterGrades() {

        Scanner input = new Scanner(System.in);
        double choiceArray[] = null;

        System.out.println("\nWhich class would you like to enter grades for?\n" +
                "\nPlease choose from one of the following options:\n" +
                "1. Math\n" +
                "2. Science\n" +
                "3. History\n" +
                "4. Art\n");
        System.out.print("Type your choice here (1-4): ");

        int choice = input.nextInt();
        String className = "";
        boolean keepGoing = true;
        int index = 1;

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid entry");
            enterGrades();
        }

        else if (choice == 1) {
            choiceArray = mathGrades;
        }
        else if (choice == 2) {
            choiceArray = scienceGrades;
        }
        else if (choice == 3) {
            choiceArray = historyGrades;
        }
        else if (choice == 4) {
            choiceArray = artGrades;
        }

        if (choiceArray == null) {
            System.out.println("\nThe selected class has not been initialized yet. Please initialize the class first, then enter grades.");
            initClass();
            return;
        }

        else {
            switch (choice) {

                case 1:
                className = "Math";
                while (keepGoing) {
                    System.out.print("\nOkay, which index would you like to modify? (1 to "
                            + (mathGrades.length) + "): ");
                    index = input.nextInt();

                    if (index < 1 || index > mathGrades.length) {
                        System.out.println("Invalid index. Try again.");
                        continue;
                    }

                    int actualIndex = index - 1;

                    System.out.print("\nEnter the new value for index " + index + ": ");
                    int newGrade = input.nextInt();
                    mathGrades[actualIndex] = newGrade;
                    System.out.println("\nUpdated gradebook for " + className.toLowerCase() + " class: "
                            + displayArray(mathGrades));
                    String yn = "";
                    do {
                        System.out.print("\nDo you want to modify another value? (yes/no): ");
                        yn = input.next().trim().toLowerCase();
            
                        if (!yn.equals("yes") && !yn.equals("no")) {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    } while (!yn.equals("yes") && !yn.equals("no"));
            
                    if (yn.equals("no")) {
                        keepGoing = false;
                        System.out.println("\nExiting grade entry.");
                        menu();
                    }
                }
                break;

                case 2:
                className = "Science";
                while (keepGoing) {
                    System.out.print("\nOkay, which index would you like to modify? (1 to "
                            + (scienceGrades.length) + "): ");
                    index = input.nextInt();

                    if (index < 1 || index > scienceGrades.length) {
                        System.out.println("Invalid index. Try again.");
                        continue;
                    }

                    int actualIndex = index - 1;

                    System.out.print("\nEnter the new value for index " + index + ": ");
                    int newGrade = input.nextInt();
                    scienceGrades[actualIndex] = newGrade;
                    System.out.println("\nUpdated gradebook for " + className.toLowerCase() + " class: "
                            + displayArray(scienceGrades));
                    String yn = "";
                    do {
                        System.out.print("\nDo you want to modify another value? (yes/no): ");
                        yn = input.next().trim().toLowerCase();
            
                        if (!yn.equals("yes") && !yn.equals("no")) {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    } while (!yn.equals("yes") && !yn.equals("no"));
            
                    if (yn.equals("no")) {
                        keepGoing = false;
                        System.out.println("\nExiting grade entry.");
                        menu();
                    }
                }
                break;
                case 3:
                className = "History";
                while (keepGoing) {
                    System.out.print("\nOkay, which index would you like to modify? (1 to "
                            + (historyGrades.length) + "): ");
                    index = input.nextInt();

                    if (index < 1 || index > historyGrades.length) {
                        System.out.println("Invalid index. Try again.");
                        continue;
                    }

                    int actualIndex = index - 1;

                    System.out.print("\nEnter the new value for index " + index + ": ");
                    int newGrade = input.nextInt();
                    historyGrades[actualIndex] = newGrade;
                    System.out.println("\nUpdated gradebook for " + className.toLowerCase() + " class: "
                            + displayArray(historyGrades));
                    String yn = "";
                    do {
                        System.out.print("\nDo you want to modify another value? (yes/no): ");
                        yn = input.next().trim().toLowerCase();
            
                        if (!yn.equals("yes") && !yn.equals("no")) {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    } while (!yn.equals("yes") && !yn.equals("no"));
            
                    if (yn.equals("no")) {
                        keepGoing = false;
                        System.out.println("\nExiting grade entry.");
                        menu();
                    }
                }
                break;
                case 4:
                    className = "Art";
                    while (keepGoing) {
                        System.out.print("\nOkay, which index would you like to modify? (1 to "
                                + (artGrades.length) + "): ");
                        index = input.nextInt();

                        if (index < 1 || index > artGrades.length) {
                            System.out.println("Invalid index. Try again.");
                            continue;
                        }

                        int actualIndex = index - 1;

                        System.out.print("\nEnter the new value for index " + index + ": ");
                        int newGrade = input.nextInt();
                        artGrades[actualIndex] = newGrade;
                        System.out.println("\nUpdated gradebook for " + className.toLowerCase() + " class: "
                                + displayArray(artGrades));
                        String yn = "";
                        do {
                            System.out.print("\nDo you want to modify another value? (yes/no): ");
                            yn = input.next().trim().toLowerCase();
                
                            if (!yn.equals("yes") && !yn.equals("no")) {
                                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                            }
                        } while (!yn.equals("yes") && !yn.equals("no"));
                
                        if (yn.equals("no")) {
                            keepGoing = false;
                            System.out.println("\nExiting grade entry.");
                            menu();
                        }
                    }
                    break;

            
            default:
            className = "Unknown";}}
            
    }

    public static String displayArray(double[] arr) {
        StringBuilder result = new StringBuilder();
        for (double element : arr) {
            result.append(element).append(" ");
        }
        return result.toString();
    }

    public static void minMax() {

        Scanner input = new Scanner(System.in);
        String className = "";
        double[] choiceArray = null;

        System.out.println("\nWhich class would you like to display the min, max, and average of?" +
                "\nPlease choose from one of the following options:\n" +
                "\n1. Math" +
                "\n2. Science" +
                "\n3. History" +
                "\n4. Art\n");
        System.out.print("Type your choice here (1-4): ");
        int choice = input.nextInt();

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid entry");
            minMax();
        }

        else {
            switch (choice) {

                case 1:
                    className = "Math";
                    choiceArray = mathGrades;
                    break;

                case 2:
                    className = "Science";
                    choiceArray = scienceGrades;
                    break;

                case 3:
                    className = "History";
                    choiceArray = historyGrades;
                    break;

                case 4:
                    className = "Art";
                    choiceArray = artGrades;
                    break;

                default:
                    className = "Unknown";
                    return;

            }
        }

        if (choiceArray == null || choiceArray.length == 0) {
            System.out
                    .println("\nThe selected class has no grades. Please initialize the class and enter grades first.");
            menu();
            return;
        }

        double min = choiceArray[0];
        double max = choiceArray[0];
        double sum = 0;

        for (double i : choiceArray) {

            if (i < min) {
                min = i;
            }

            if (i > max) {
                max = i;
            }
            sum += i;
        }

        double average = sum / choiceArray.length;

        System.out.println("\nThe minimum grade for " + className + " is " + min);
        System.out.println("The maximum grade for " + className + " is " + max);
        System.out.println("The average grade for " + className + " is " + average);

        System.out.println("\nWhat would you like to do next?");
        menu();
    }

    public static void main(String[] args) {

        System.out.println("Welcome to gradebook!");
        menu();

    }
}