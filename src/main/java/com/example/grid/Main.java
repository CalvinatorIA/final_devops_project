package com.example.grid;

public class Main {

    public static void main(String[] args) {

        final int WIDTH = 10;
        final int LENGTH = 10;
        final int DEPTH = 10;

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                for (int k = 0; k < DEPTH; k++) {

                    int l = i + j + k;
                    if (l < 10) {
                        System.out.print(" ");
                    }

                    System.out.print(l + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
