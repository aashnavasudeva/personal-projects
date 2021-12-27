package entities;

import java.util.*;

public class GroceryList {
    private List<GroceryItem> list = new ArrayList<>();

    public GroceryList(){}

    public void addToList(GroceryItem item) {
        this.list.add(item);
    }

    public List<GroceryItem> getList() {
        return this.list;
    }
}
