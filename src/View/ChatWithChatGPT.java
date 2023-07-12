package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatWithChatGPT {
    private static final String API_KEY = "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";
    private static final String ENDPOINT = "https://api.openai.com/v1/engines/davinci-codex/completions";

    private static String chatId = null;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("> ");
            String message = reader.readLine();

            String response = sendMessage(message);

            System.out.println(response);
        }
    }

    private static String sendMessage(String message) throws IOException {
        if (chatId == null) {
            chatId = createChat();
        }

        URL url = new URL(ENDPOINT);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY);

        String requestBody = "{\"prompt\":\"" + message + "\",\"chat_history\":\"" + chatId + "\"}";

        conn.setDoOutput(true);
        conn.getOutputStream().write(requestBody.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        conn.disconnect();

        return sb.toString();
    }

    private static String createChat() throws IOException {
        URL url = new URL(ENDPOINT + "/conversations");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY);

        String requestBody = "{\"temperature\":0.5,\"max_tokens\":1024}";

        conn.setDoOutput(true);
        conn.getOutputStream().write(requestBody.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        conn.disconnect();

        return sb.toString().substring(17, 49);
    }
}