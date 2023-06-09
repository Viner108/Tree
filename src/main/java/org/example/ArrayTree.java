package org.example;

public class ArrayTree {
    public static void main(String[] args) {
        int[] array = intit(40);
        int[] root = new int[4];
        int[] object1 = new int[5];
        int[] object2 = new int[4];
        int[] object11 = new int[1];
        int[] object12 = new int[1];
        int[] object21 = new int[2];
        int[] object22 = new int[2];
        int descendant = 2;
        printLines(array);
        System.out.println(getCount(array, descendant));
        int[] array2 = arrayAdress(array, descendant);
        printLines(array2);
    }

    public static int[] intit(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        return array;
    }

    public static int[] createObject(int[] array, int[] object, int descendant, int objectindex) {
        int start = findStart(array, descendant);
        if (array[start + 1] == -1 || array[start + descendant] == -1) {
            if (object.length + start + 1 + descendant <= array.length) {
                array[start] = object.length;
                int j = 0;
                for (int i = start + 1; i < object.length + start + 1 + descendant; i++) {
                    if (i < start + 1 + descendant) {
                        array[i] = -1;
                    } else {
                        array[i] = object[j];
                        j++;
                    }
                }
            }
        }
        return array;
    }



    public static int findStart(int[] array, int descendant) {
        int i = 0;
        while (array[i] != -1) {
            i = i + array[i] + 1 + descendant;
        }
        return i;
    }

    public static int getCount(int[] array, int descendant) {
        int count = -1;
        for (int i = 0; i < array.length; i = i + array[i] + descendant + 1) {
            count++;
        }
        return count;
    }

    //    public static int getStart(int[] array, int descendant,int indexofobject){
//        int j=-1;
//        int count=getCount(array,descendant);
//        for (int i = 0; i < array.length; i=i+array[i]+1+descendant) {
//            if(array[i]!=-1){
//                j++;
//                if (j == indexofobject && j <= count) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }


    public static int[] arrayAdress(int[] array, int descendant) {
        int size = getCount(array, descendant);
        int[] adress = new int[size + 1];
        int j = 0;
        for (int i = 0; i < array.length && array[i] != -1; i = i + array[i] + descendant + 1) {
            adress[j] = i;
            j++;
        }
        return adress;
    }



    public static void printLines(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(String.format(" %2d", array[i]));
        }
        System.out.println("]");
    }
}
