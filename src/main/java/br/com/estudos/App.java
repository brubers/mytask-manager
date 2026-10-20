package br.com.estudos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static void main(){

        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        TaskManager taskManager = new TaskManager(tasks);

        menu(sc, taskManager);

    }

    public static void menu(Scanner sc, TaskManager taskManager){
        while(true){
            System.out.println();
            System.out.println("MENU");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Listas Tarefas");
            System.out.println("3 - Concluir Tarefas");
            System.out.println("4 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.println();

            int choice = sc.nextInt();

            if (choice == 0) break;

            runChoice(choice, taskManager, sc);

        }
    }

    public static void runChoice(int choice, TaskManager taskManager, Scanner sc){
        switch (choice){
            case 1:
                System.out.println("ID: ");
                int id = sc.nextInt();
                System.out.print("");
                System.out.println("Título: ");
                String title = sc.next();
                System.out.print("");
                System.out.println("Description: ");
                String description = sc.next();

                taskManager.addTask(new Task(id, title, description));
                break;
            case 2:
                taskManager.listTasks();
                break;
            case 3:
                System.out.println("Qual ID da tarefa que deverá ser concluida?");
                boolean completed = taskManager.completeTaskById(sc.nextInt());
                if (completed){
                    System.out.println("Tarefa concluída");
                } else{
                    System.out.println("Erro.");
                }
                break;
            case 4:
                System.out.println("Qual ID da tarefa que deverá ser removida?");
                boolean removed = taskManager.removeTask(sc.nextInt());
                if (removed){
                    System.out.println("Removido com sucesso.");
                } else {
                    System.out.println("Erro.");
                }
                break;
            default:
                System.out.println("Opção Invalida.");
                break;
        }

    }
}

