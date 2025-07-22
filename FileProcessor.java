package com.test;

import java.io.*;
import java.util.*;

public class FileProcessor {
    
    public void processFile(String filename) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            processData(fis);
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + filename);
        } finally {
            // 리소스 누수 위험 - finally에서 close 안함
            // if (fis != null) {
            //     try {
            //         fis.close();
            //     } catch (IOException e) {
            //         e.printStackTrace();
            //     }
            // }
        }
    }
    
    private void processData(FileInputStream fis) {
        byte[] buffer = new byte[1024];
        try {
            fis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> readLines(String filename) {
        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // scanner.close() 호출 안함 - 리소스 누수
        
        return lines;
    }
    
    // 동시성 문제 가능성
    private static int counter = 0;
    
    public void incrementCounter() {
        counter++; // Thread-safe하지 않음
    }
    
    public int getCounter() {
        return counter;
    }
}