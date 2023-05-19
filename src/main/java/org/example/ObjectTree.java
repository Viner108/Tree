package org.example;

public class ObjectTree {
    ObjectTreeItem root = null;
    boolean startAdding = true;
    static int count = 0;

    public ObjectTree() {
        root = new ObjectTreeItem();
    }

    public ObjectTree(int index) {
        root = new ObjectTreeItem(index, new Payload(5));
    }

    public void add(ObjectTreeItem item, ObjectTreeItem root1) {
        startAdding = true;
        addItem(item, root1);
    }

    private void addItem(ObjectTreeItem item, ObjectTreeItem root1) {
        if (!startAdding) {
            return;
        }
        int i = 0;
        if (item.payload.sum < root1.payload.sum) {
            if (root1.items[i] != null) {
                addItem(item, root1.items[i]);
            } else {
                root1.items[i] = item;
                startAdding = false;
            }
        } else {
            i++;
            if (root1.items[i] != null) {
                addItem(item, root1.items[i]);
            } else {
                root1.items[i] = item;
                startAdding = false;
            }
        }
        count++;
    }

    public boolean searchItem(ObjectTreeItem item, ObjectTreeItem root2) {
        int i = 0;
        if (item.payload.sum == root2.payload.sum) {
            return true;
        } else if (item.payload.sum < root2.payload.sum) {
            if(root2.items[i]!=null&&searchItem(item, root2.items[i])) {
                return true;
            }
        }else {
            i++;
            if(root2.items[i]!=null&&searchItem(item,root2.items[i])){
                return true;
            }
        }
        return false;
    }
}


