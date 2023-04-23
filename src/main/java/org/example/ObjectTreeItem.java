package org.example;

public class ObjectTreeItem {
    ObjectTreeItem[] items = null;
    Payload payload;

    public ObjectTreeItem() {
        items = new ObjectTreeItem[2];
    }

    public ObjectTreeItem(int size, Payload payload) {
        items = new ObjectTreeItem[size];
        this.payload = payload;
    }

}
