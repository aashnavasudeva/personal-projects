package entities;

import java.util.*;

public class Household {
    private UUID id;
    private String homeName;
    private List<String> members = new ArrayList<>();
    private GroceryList groceryList = new GroceryList();
    private List<Expenses> expenses = new ArrayList<>();
    private List<Reminder> rems = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public Household(String name) {
        this.homeName = name;
        this.id = UUID.randomUUID();
    }

    public List<String> getMembers(){
        return this.members;
    }

    public void addMember(String userName){
        this.members.add(userName);
    }

    public GroceryList getGroceryList(){
        return this.groceryList;
    }

    public List<Expenses> getExpenses(){
        return this.expenses;
    }

    public void addExpense(Expenses expenses){
        this.expenses.add(expenses);
    }

    public List<Reminder> getRems(){
        return this.rems;
    }

    public void addReminder(Reminder rem){
        this.rems.add(rem);
    }

    public List<Task> getTasks(){
        return this.tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }
}
