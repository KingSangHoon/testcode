package com.test;

public class UserService {
    
    public void processUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("사용자명은 null일 수 없습니다");
        }
        
        System.out.println("사용자 처리 중: " + username);
        
        // 의도적인 에러 상황들 (LLM 분석용)
        String[] userData = null;
        // System.out.println(userData.length); // Null Pointer Exception 위험
        
        validateUser(username);
    }
    
    private void validateUser(String username) {
        // SQL Injection 위험 코드 (테스트용)
        String query = "SELECT * FROM users WHERE name = '" + username + "'";
        System.out.println("실행할 쿼리: " + query);
        
        // 하드코딩된 민감정보 (보안 취약점)
        String apiKey = "sk-1234567890abcdef"; // 하드코딩된 API 키
        String password = "admin123"; // 하드코딩된 패스워드
    }
    
    public User getUser(Long id) {
        // Null 체크 없음 (잠재적 위험)
        return findUserById(id);
    }
    
    private User findUserById(Long id) {
        // 실제로는 DB에서 조회
        return null; // null 반환 가능성
    }
}