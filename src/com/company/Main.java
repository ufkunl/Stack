package com.company;

import java.util.Scanner;

public class Main {

    StackItem[] stackItems = new StackItem[20];

    public void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Stack Numarası giriniz.");
        int stackNo = scan.nextInt();

        System.out.println("İşlem Seçiniz.(PUSH / POP)");
        String action = scan.next();

        if(action.equals("PUSH")){
            System.out.println("Numara giriniz.");
            int number = scan.nextInt();
            push(number);
        }else{
            pop();
        }

    }

    private int push(int number){
        return 0;
    }

    private int pop(){
        return 0;
    }
}
