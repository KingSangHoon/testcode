# GitHub 커밋 분석 테스트 프로젝트

이 프로젝트는 LLM 기반 정적분석 시스템을 테스트하기 위한 Java 코드입니다.

## 포함된 에러 패턴들

### 보안 취약점
- SQL Injection 위험 코드
- 하드코딩된 API 키/패스워드

### 메모리/리소스 관리
- Null Pointer Exception 위험
- 리소스 누수
- Division by zero

### 로직 에러
- 무한루프 가능성
- 동시성 문제
- 예외 처리 부족

## 컴파일 및 실행

```bash
javac -d bin src/main/java/com/test/*.java
java -cp bin com.test.Main