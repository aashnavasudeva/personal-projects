package entities;

import java.util.Date;

public class Task extends ToDo{
    public Task(String what, Date due, String addedBy) {
        super(what, due, addedBy);
    }
}
