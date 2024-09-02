package com.test_tgid.project_tgid.notication;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

public class EmailNotification {
    private static final String API_KEY = "YOUR_MAILGUN_API_KEY";
    private static final String DOMAIN = "YOUR_MAILGUN_DOMAIN";

    public static void enviarEmail(String to, String subject, String body) {
        String url = "https://api.mailgun.net/v3/" + DOMAIN + "/messages";
        String userPass = "api:" + API_KEY;
        String auth = "Basic " + new String(Base64.getEncoder().encode(userPass.getBytes()));

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", auth);
            connection.setDoOutput(true);

            String postData = "from=lgusta333@gmail.com&to=" + URLEncoder.encode(to, "UTF-8") +
                    "&subject=" + URLEncoder.encode(subject, "UTF-8") +
                    "&text=" + URLEncoder.encode(body, "UTF-8");

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
