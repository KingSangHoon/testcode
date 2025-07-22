package com.test;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaymentApiClient {

    private static final String API_URL = "https://payment.company.com/api/test";

    /**
     * 결제 API 호출 메서드
     *
     * @param orderId 주문 ID
     * @param amount 금액 (예: 1000)
     * @param currency 통화 (예: "KRW")
     * @param description 설명
     * @return 응답 문자열
     * @throws Exception 예외 발생 시
     */
    public String sendPaymentRequest(String orderId, int amount, String currency, String description) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = String.format(
                "{\"orderId\":\"%s\",\"amount\":%d,\"currency\":\"%s\",\"description\":\"%s\"}",
                orderId, amount, currency, description
        );

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = conn.getResponseCode();
        InputStream is = (code >= 200 && code < 300) ? conn.getInputStream() : conn.getErrorStream();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }
}
