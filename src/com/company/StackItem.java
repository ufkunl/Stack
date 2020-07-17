package com.company;

public class StackItem {

    private StackItem previousItem;

    private int number;

    private StackItem nextItem;

    private int stackNo;

    public int getStackNo() {
        return stackNo;
    }

    public void setStackNo(int stackNo) {
        this.stackNo = stackNo;
    }

    public StackItem getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(StackItem previousItem) {
        this.previousItem = previousItem;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public StackItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(StackItem nextItem) {
        this.nextItem = nextItem;
    }
}
