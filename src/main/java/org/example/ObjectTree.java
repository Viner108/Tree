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
        checkingConditionsAndAdding(item, root1);
    }

    private void checkingConditionsAndAdding(ObjectTreeItem item, ObjectTreeItem root1) {
        if (!startAdding) {
            return;
        }
        int i = 0;
        if (item.payload.sum < root1.payload.sum) {
            addItem(item, root1, i);

        } else {
            i++;
            addItem(item, root1, i);
        }

        count++;
    }

    private void addItem(ObjectTreeItem item, ObjectTreeItem root1, int i) {
        if (root1.items[i] != null) {
            checkingConditionsAndAdding(item, root1.items[i]);
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
            if (checkingBranches(item, root2, i)) return true;
        } else {
            i++;
            if (checkingBranches(item, root2, i)) return true;
        }
        return false;
    }

    private boolean checkingBranches(ObjectTreeItem item, ObjectTreeItem root2, int i) {
        if (root2.items[i] != null && searchItem(item, root2.items[i])) {
            return true;
        }
        return false;
    }
}


