package org.example.database;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public final List<String> items;
    public Database(){
        this.items = new ArrayList<>(List.of("Item 1", "Item 2"));
    }
}
