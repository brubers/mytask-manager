package br.com.estudos;

import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        if (searchTaskById(task.getId()) == null) {
            tasks.add(task);
        } else {
            System.out.println("ID has already been registered");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There is no item in the list yet.");
        } else {
            System.out.println(" ");
            for (Task i : tasks) { //for each
                System.out.println(i);
                System.out.println(" ");
            }
        }
    }

    public Task searchTaskById(int id) {
        for (Task i : tasks) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public boolean completeTaskById(int id) {
        Task search = searchTaskById(id);
        if (search != null) {
            search.done();
            return true;
        }
        return false;
    }

    public boolean removeTask(int id) {
        Task search = searchTaskById(id);
        if (search != null) {
            tasks.remove(search);
            return true;
        }

        return false;
    }
}
