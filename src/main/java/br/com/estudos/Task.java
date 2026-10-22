package br.com.estudos;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;

    public Task(int id, String titulo, String descricao) {
        this.id = id;
        this.title = titulo;
        this.description = descricao;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void done() {
        done = true;
    }

    @Override
    public String toString() {
        String status;

        if (done) {
            status = "Completed";
        } else {
            status = "Pending";
        }

        return "ID: " + id +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nStatus: " + status;
    }
}

