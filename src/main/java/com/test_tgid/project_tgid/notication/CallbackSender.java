package com.test_tgid.project_tgid.notication;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallbackSender {
    public static void enviarCallback(String webhookUrl, String jsonPayload) throws Exception {
        URL url = new URL(webhookUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonPayload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = connection.getResponseCode();
        System.out.println("Resposta do Webhook: " + code);
    }
}
