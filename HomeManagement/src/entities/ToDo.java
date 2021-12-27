package entities;

import java.util.Date;

public class ToDo {
    private String what;
    private Date due;
    private String addedBy;
    private String addedFor;

    public ToDo(String what, Date due, String addedBy){
        this.what = what;
        this.due = due;
        this.addedBy = addedBy;
        this.addedFor = "null";
    }

    public void setAddedFor(String addedFor) {
        this.addedFor = addedFor;
    }

    public void changeWhat(String what) {
        this.what = what;
    }

    public void changeDue(Date due) {
        this.due = due;
    }

    public String getWhat() {
        return this.what;
    }

    public Date getDue() {
        return this.due;
    }

    public String getAddedBy() {
        return this.addedBy;
    }
    public String getAddedFor() {
        return this.addedFor;
    }
}
