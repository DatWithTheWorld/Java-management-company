package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebCrawler extends JFrame {

    private JTextField urlField;
    private JTextArea resultArea;

    public WebCrawler() {
        setTitle("Web Crawler");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tạo phần đầu của giao diện
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Web Crawler");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Tạo phần chính của giao diện
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel urlLabel = new JLabel("URL:");
        urlField = new JTextField();
        JButton crawlButton = new JButton("Crawl");
        inputPanel.add(urlLabel, BorderLayout.WEST);
        inputPanel.add(urlField, BorderLayout.CENTER);
        inputPanel.add(crawlButton, BorderLayout.EAST);
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        // Xử lý sự kiện khi nhấn nút Crawl
        crawlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crawl();
            }
        });
    }

    private void crawl() {
        try {
            String url = urlField.getText();
            Document doc = Jsoup.connect(url).get();

            // Lấy danh sách các bài viết trên trang web
            Elements articles = doc.select("div.porta-article-item");

            // Hiển thị các bài viết lên JTextArea
            resultArea.setText("");
            for (Element article : articles) {
                Element titleElement = article.selectFirst("h3.porta-header-text a");
                String title = titleElement.text();
                String link = titleElement.attr("href");
                Elements content = article.select("div.message-body");
                String contents = content.text();
                resultArea.append("Title: " + title + "\n");
                resultArea.append("Link: " + link + "\n");
                resultArea.append("Content: " + contents + "\n");
                resultArea.append("===============================================================================================================================================\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebCrawler crawler = new WebCrawler();
                crawler.setVisible(true);
            }
        });
    }
}