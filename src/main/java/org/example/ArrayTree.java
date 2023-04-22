package org.example;

public class ArrayTree {
    public static void main(String[] args) {
        int [] array= intit(40);
        int [] root = new int [4];
        int [] object1=new int [5];
        int [] object2= new int[4];
        int [] object11= new int[1];
        int [] object12= new int[1];
        int [] object21= new int[2];
        int [] object22= new int[2];
        int descendant=2;
        int indexofobject=4;
        createObject(array,root,descendant);
        createObject(array,object1,descendant);
        createObject(array,object2,descendant);
        creatIndex(array,descendant);
        createObject(array,object11,descendant);
        createObject(array,object12,descendant);
        createObject(array,object21,descendant);
        createObject(array,object22,descendant);
        System.out.println(getCount(array,descendant));
        System.out.println(getStart(array,descendant,indexofobject));
        printLines(array);
    }
    public static int [] intit(int size){
        int [] array=new int [size];
        for (int i = 0; i < array.length; i++) {
            array[i]=-1;
        }
        return array;
    }
    public static int [] createObject(int [] array, int [] object,int descendant){
        int start =findStart(array,descendant);
        if (object.length+start+1+descendant<=array.length) {
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
        printLines(array);
        return array;
    }
    public static int[] creatIndex(int [] array, int descendant){
       int start=0;
        for (int i = 1; i < descendant+1; i++) {
            array[i]=findIndex(array,descendant,i,start);
            for (int j = i; j < array.length-1; j++) {
                if(array[j]==-1){
                    start =array[i];
                    break;
                }
            }
        }
        return array;
    }

    public static int findStart(int[] array,int descendant){
        int i=0;
        while (array[i]!=-1) {
            i=i+array[i]+1+descendant;
        }
        return i;
    }
    public static int findIndex(int [] array, int descendant, int i, int start){
        if (start+array[start]+1+descendant<array.length) {
            i = start + array[start] + 1 + descendant;
        }
        return i;
    }
    public static int getCount(int [] array, int descendant){
        int count=-1;
        for (int i = 0; i < array.length; i=i+array[i]+descendant+1) {
            count++;
        }
        return count;
    }
    public static int getStart(int[] array, int descendant,int indexofobject){
        int j=0;
        int count=getCount(array,descendant);
        for (int i = 0; i < array.length; i=i+array[i]+1+descendant) {
            if(array[i]!=-1){
                j++;
                if (j == indexofobject && j <= count) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void printLines(int[] array) {//функция для выведения массива на консоль
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
