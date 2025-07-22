package com.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.util.UUID;

public class PaymentService {

    private static final String PAYMENT_GATEWAY_URL = "https://payment.company.com/api/v1/process";

    /**
     * 결제 처리 요청
     */
    public boolean processPayment(String cardNumber, int amountWon) {
        try {
            URL url = new URL(PAYMENT_GATEWAY_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // 거래 ID 생성 (멱등성 키로 사용)
            String transactionId = UUID.randomUUID().toString();

            // JSON 본문 구성
            String jsonPayload = String.format(
                "{" +
                "\"cardNumber\":\"%s\"," +
                "\"amount\":%d," +
                "\"transactionId\":\"%s\"" +
                "}",
                maskCardNumber(cardNumber), amountWon, transactionId
            );

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonPayload.getBytes());
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            return responseCode == 200;

        } catch (Exception e) {
            System.err.println("결제 처리 실패: " + e.getMessage());
            return false;
        }
    }

    /**
     * 카드 번호 마스킹 처리 (보안 이슈 방지)
     */
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() < 4) return "****";
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}
