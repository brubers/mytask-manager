package br.com.estudos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static void main() {

        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        TaskManager taskManager = new TaskManager(tasks);

        menu(sc, taskManager);

    }

    public static void menu(Scanner sc, TaskManager taskManager) {
        while (true) {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1 - Add Task");
            System.out.println("2 - List Tasks");
            System.out.println("3 - Complete Task");
            System.out.println("4 - Remove Task");
            System.out.println("0 - End Program");
            System.out.println();

            int choice = readInt(sc);

            if (choice == 0) break;

            runChoice(choice, taskManager, sc);


        }
    }

    public static void runChoice(int choice, TaskManager taskManager, Scanner sc) {
        switch (choice) {
            case 1:

                System.out.println("ID: ");
                int id = readInt(sc);
                sc.nextLine();

                System.out.print("");
                System.out.println("Title: ");
                String title = sc.nextLine();
                System.out.print("");
                System.out.println("Description: ");
                String description = sc.nextLine();

                taskManager.addTask(new Task(id, title, description));

                break;
            case 2:
                taskManager.listTasks();
                break;
            case 3:
                System.out.println("Which Task ID should be marked as completed?");

                id = readInt(sc);
                sc.nextLine();

                boolean completed = taskManager.completeTaskById(id);
                if (completed) {
                    System.out.println("Task completed");
                } else {
                    System.out.println("ERROR.");
                }
                break;
            case 4:
                System.out.println("Which Task ID should be removed?");

                id = readInt(sc);
                sc.nextLine();

                boolean removed = taskManager.removeTask(sc.nextInt());
                if (removed) {
                    System.out.println("Removed.");
                } else {
                    System.out.println("Error.");
                }
                break;
            default:
                System.out.println("Invalid option. Try Again.");
                break;
        }

    }

    public static int readInt(Scanner sc) {
        int input;
        while (true) {
            try { //try statement -> block of code to be tested for errors while it is being executed
                input = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine(); //important bc i used sc.nextInt() (uses the rest of my invalid line)
                System.out.println("Wrong input. A number is expected"); //catch is responsible in case an error occurs
            }
        }
        return input;
    }

}

