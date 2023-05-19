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
            extracted(item, root1, i);
        } else {
            i++;
            extracted(item, root1, i);
        }

        count++;
    }

    private void extracted(ObjectTreeItem item, ObjectTreeItem root1, int i) {
        if (root1.items[i] != null) {
            addItem(item, root1.items[i]);
        } else {
            root1.items[i] = item;
            startAdding = false;
        }
    }

    public boolean searchItem(ObjectTreeItem item, ObjectTreeItem root2) {
        int i = 0;
        if (item.payload.sum == root2.payload.sum) {
            return true;
        } else if (item.payload.sum < root2.payload.sum) {
            if (extracted2(item, root2, i)) return true;
        }else {
            i++;
            if (extracted2(item, root2, i)) return true;
        }
        return false;
    }

    private boolean extracted2(ObjectTreeItem item, ObjectTreeItem root2, int i) {
        if(root2.items[i]!=null&&searchItem(item, root2.items[i])) {
            return true;
        }
        return false;
    }
}


