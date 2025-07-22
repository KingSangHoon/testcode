package com.test;

public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int divide(int a, int b) {
        // Division by zero 체크 없음
        return a / b; // ArithmeticException 위험
    }
    
    public double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수의 제곱근은 계산할 수 없습니다");
        }
        return Math.sqrt(number);
    }
    
    // 무한루프 위험
    public void infiniteLoop() {
        while (true) {
            System.out.println("무한루프...");
            // break 조건 없음
        }
    }
}