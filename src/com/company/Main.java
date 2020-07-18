package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StackItem[] stackItems = new StackItem[20];
        Scanner scan = new Scanner(System.in);

        while (true){

            System.out.println("Enter the stack number...(1 / 2 / 3)");
            int stackNo = scan.nextInt();

            System.out.println("Choose action...(PUSH / POP)");
            String action = scan.next();

            if(action.equals("PUSH")){
                System.out.println("Enter the number...");
                int number = scan.nextInt();
                push(stackNo,number,stackItems);
            }else{
                pop(stackNo,stackItems);
            }

            printStackItemByStackNo(stackItems,1);
            printStackItemByStackNo(stackItems,2);
            printStackItemByStackNo(stackItems,3);
            System.out.println("--- All Array ---");
            for (int i = 0; i<getItemCount(stackItems)+1;i++) {
                System.out.print(stackItems[i].getNumber() + " - ");
            }
            System.out.println("");
        }
    }

    private static void push(int stackNo, int number, StackItem[] stackItems){

        int endStack = searchStackEndItemByStackNo(stackNo,stackItems);

        // if stack exist a item
        if(endStack != -1){
            int endArray = getItemCount(stackItems);
            StackItem stackItem = new StackItem();
            stackItem.setNextItem(null);
            stackItem.setNumber(number);
            stackItem.setStackNo(stackNo);
            stackItem.setPreviousItem(stackItems[endStack]);
            stackItems[endArray + 1] = stackItem;
            stackItems[endStack].setNextItem(stackItem);
        }else{
            int endArray = getItemCount(stackItems);

            //if stack not exist a item, add number to end of array
            if(endArray != -1){
                StackItem stackItem = new StackItem();
                stackItem.setNextItem(null);
                stackItem.setNumber(number);
                stackItem.setStackNo(stackNo);
                stackItem.setPreviousItem(stackItems[endArray]);
                stackItems[endArray + 1] = stackItem;

            }else{ // //if array not exist a item, add number to start of array
                StackItem stackItem = new StackItem();
                stackItem.setNextItem(null);
                stackItem.setNumber(number);
                stackItem.setStackNo(stackNo);
                stackItem.setPreviousItem(null);
                stackItems[0] = stackItem;
            }
        }
    }

    private static void pop(int stackNo,StackItem[] stackItems){
        int index = searchStackEndItemByStackNo(stackNo,stackItems);
        stackItems[index].getPreviousItem().setNextItem(null);
        stackItems[index] = null;
    }

    // For found end item of array by stack no
    private static int searchStackEndItemByStackNo(int stackNo,StackItem[] stackItems){
        int index = -1;
        for(int i = 0;i < getItemCount(stackItems) + 1; i++){
            if(stackItems[i].getStackNo() == stackNo && stackItems[i].getNextItem() == null){
                index = i;
                break;
            }
        }
        return index;
    }

    private static void printStackItemByStackNo(StackItem[] stackItems, int stackNo){
        System.out.println("--- "+stackNo + "'nolu stack"+" ---");
        int index = -1;
        for(int i = 0;i < getItemCount(stackItems) + 1; i++){
            if(stackItems[i].getStackNo() == stackNo){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Empty");
        }else{
            StackItem stackItem = stackItems[index];
            while(stackItem != null){
                System.out.print(stackItem.getNumber() + " - ");
                stackItem = stackItem.getNextItem();
            }
            System.out.println("");
        }
    }

    private static int getItemCount(StackItem[] stackItems){
        int count = -1;
        for(int i = 0;i < stackItems.length; i++){
            if(stackItems[i] == null){
                break;
            }
            count ++;
        }
        return count;
    }

}
