package View;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
        String to = "mail";
        String from = "yourmail";
        String password = "yourpass";
        String host = "smtp.gmail.com";
        String subject = "Test email";
        String body = "This is a test email.";

        // Thiết lập các thuộc tính cấu hình cho giao thức SMTP
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");

        // Thiết lập giao thức bảo mật
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        // Tạo một đối tượng Authenticator để xác thực người dùng
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Tạo một đối tượng Session để kết nối với máy chủ SMTP
        Session session = Session.getDefaultInstance(properties, authenticator);

        try {
            // Tạo một đối tượng MimeMessage để đại diện cho email
            MimeMessage message = new MimeMessage(session);

            // Thiết lập thông tin người gửi và người nhận
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Thiết lập tiêu đề và nội dung của email
            message.setSubject(subject);
            message.setText(body);

            // Gửi email
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
