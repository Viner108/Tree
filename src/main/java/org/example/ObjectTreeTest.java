package org.example;

public class ObjectTreeTest {
    public static int[] array={5,2,3,6,8,3,1};
    public static void main(String[] args) {
        createTest();
    }

    public static void createTest() {
        ObjectTree tree = new ObjectTree(2);
        for (int i = 0; i < array.length; i++) {
            tree.add(new ObjectTreeItem(2, new Payload(array[i])), tree.root);
        }
        System.out.println(tree.searchItem(new ObjectTreeItem(2, new Payload(0)),tree.root));
    }
}
