package org.example;

public class ObjectTree {
    ObjectTreeItem root = null;
    boolean startAdding = true;

    public ObjectTree() {
        root = new ObjectTreeItem();
    }

    public ObjectTree(int index) {
        root = new ObjectTreeItem(index, new Payload(10));
    }

    public void add(ObjectTreeItem item, ObjectTreeItem root1) {
        startAdding = true;
        addItem(item, root1);
    }

    private void addItem(ObjectTreeItem item, ObjectTreeItem root1) {
        if (!startAdding) return;
        if (item.payload.sum < root1.payload.sum) {
            int i = 0;
            if( root1.items[i] != null) {
                addItem(item, root1.items[i]);
            }
            else {
                root1.items[i] = item;
                startAdding = false;
            }
        }else {

        }
        int i = 0;
        while (i < root1.items.length && root1.items[i] != null) {
            i++;
        }
        if (i < root1.items.length) {
            root1.items[i] = item;
            startAdding = false;
        } else {
            for (int k = 0; k < root1.items.length; k++) {
                addItem(item, root1.items[k]);
            }
        }
    }
}


