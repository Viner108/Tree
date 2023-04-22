package org.example;

public class ArrayTree {
    public static void main(String[] args) {
        int [] array= intit(22);
        int [] root = new int [4];
        int [] object1=new int [5];
        int [] object2= new int[4];
        int descendant=2;
        createObject(array,root,descendant);
        createObject(array,object1,descendant);
        createObject(array,object2,descendant);
        creatIndex(array,descendant);
        System.out.println(count(array,descendant));
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
        int start =findStart(array);
        array[start]=object.length;
        int j=0;
        for (int i = start+1; i < object.length+start+1+descendant; i++) {
            if(i<start+1+descendant) {
                array[i]=-1;
            }else {
                array[i]=object[j];
                j++;
            }
        }
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

    public static int findStart(int[] array){
        int i=0;
        while (array[i]!=-1) {
            i=i+array[i]+1;
        }
        return i;
    }
    public static int findIndex(int [] array, int descendant, int i, int start){
        if (start+array[start]+1+descendant<array.length) {
            i = start + array[start] + 1 + descendant;
        }
        return i;
    }
    public static int count(int [] array, int descedant){
        int count=0;
        for (int i = 0; i < array.length; i=i+array[i]+descedant+1) {
            count++;
        }
        return count;
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
