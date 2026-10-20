package br.com.estudos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Task task = new Task(1, "Mimir", "Dritar e mimir");
        Task task2 = new Task(2, "Comer", "papar almoço");

        List<Task> list = new ArrayList<>();

        TaskManager taskManager = new TaskManager(list);

        taskManager.addTask(task);
        taskManager.addTask(task2);

        taskManager.searchTaskbyId(0);
        taskManager.searchTaskbyId(1);

    }
}
