package com.tnsif.memorynum;

import java.util.Scanner;

class MemoryGameHelper {
    static void processQueries(int[] numbers, int Q) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < Q; i++) {
            int query = scanner.nextInt();
            int count = 0;
            for (int num : numbers) {
                if (num == query) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println(count);
            } else {
                System.out.println("NOT PRESENT");
            }
        }
        scanner.close();
    }
}

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        int Q = scanner.nextInt();
        
        MemoryGameHelper.processQueries(numbers, Q);
        
        scanner.close();
    }
}
