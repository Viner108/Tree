package org.example;

public class ObjectTreeTest {
    public static void main(String[] args) {
        createTest();
    }

    public static void createTest() {
        ObjectTree tree = new ObjectTree(2);
        tree.add(new ObjectTreeItem(2, new Payload(11)), tree.root);
        tree.add(new ObjectTreeItem(2, new Payload(12)), tree.root);
        tree.add(new ObjectTreeItem(2, new Payload(13)), tree.root);
        tree.add(new ObjectTreeItem(2, new Payload(14)), tree.root);
        tree.add(new ObjectTreeItem(2, new Payload(15)), tree.root);
        tree.add(new ObjectTreeItem(2, new Payload(16)), tree.root);
    }
}
