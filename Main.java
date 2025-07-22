javapackage com.test;

public class Main {
    public static void main(String[] args) {
        System.out.println("GitHub 커밋 분석 테스트 프로젝트");
        
        UserService userService = new UserService();
        userService.processUser("testUser");
        
        Calculator calc = new Calculator();
        int result = calc.add(10, 20);
        System.out.println("계산 결과: " + result);
        
        FileProcessor processor = new FileProcessor();
        processor.processFile("test.txt");
    }
}