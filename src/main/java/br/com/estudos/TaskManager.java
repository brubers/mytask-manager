package br.com.estudos;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(List<Task> tarefas) {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task tarefa) {
        tasks.add(tarefa);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There is no item in the list yet.");
        } else {
            for (Task i : tasks) { //for each
                System.out.println(i);
            }
        }
    }

    public Task searchTaskbyId(int id){
        for(Task i : tasks){
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public boolean completeTaskById(int id){
        Task search = searchTaskbyId(id);
        if (search != null){
            search.done();
            return true;
        }
        return false;
    }

    public boolean removeTask(int id){
        Task search = searchTaskbyId(id);
        if (search != null){
            tasks.remove(search);
            return true;
        }
        return false;
    }
}
