package entities;

public class GroceryItem {
    private String grocName;
    private int grocQuan;
    private String addedBy;
    private String addedFor;

    public GroceryItem(String name, int qtt, String addedBy){
        this.grocName = name;
        this.grocQuan = qtt;
        this.addedBy = addedBy;
        this.addedFor = "null";
    }

    public void setGrocQuan(int qtt) {
        this.grocQuan = qtt;
    }

    public void setAddedFor(String name){
        this.addedFor = name;
    }

    public void changeName(String grocName) {
        this.grocName = grocName;
    }

    public int getGrocQuan(){
        return this.grocQuan;
    }

    public String getGrocName() {
        return this.grocName;
    }

    public String getAddedBy() {
        return this.addedBy;
    }

    public String getAddedFor() {
        return this.addedFor;
    }
}
