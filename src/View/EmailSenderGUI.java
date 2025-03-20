package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailSenderGUI extends JFrame implements ActionListener {

    private JTextField toTextField;
    private JTextField subjectTextField;
    private JTextArea bodyTextArea;
    private JTextField attachmentTextField;

    public EmailSenderGUI() {
        super("Email Sender");
        JLabel toLabel = new JLabel("To:");
        toTextField = new JTextField(30);
        JLabel subjectLabel = new JLabel("Subject:");
        subjectTextField = new JTextField(30);
        JLabel bodyLabel = new JLabel("Body:");
        bodyTextArea = new JTextArea(10, 30);
        JScrollPane bodyScrollPane = new JScrollPane(bodyTextArea);
        JLabel attachmentLabel = new JLabel("Attachment:");
        attachmentTextField = new JTextField(30);
        JButton attachmentButton = new JButton("Browse");
        attachmentButton.addActionListener(this);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(toLabel, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(toTextField, c);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        panel.add(subjectLabel, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(subjectTextField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.NONE;
        panel.add(bodyLabel, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        panel.add(bodyScrollPane, c);
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        panel.add(attachmentLabel, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;
        panel.add(attachmentTextField, c);
        c.gridx = 2;
        c.fill = GridBagConstraints.NONE;
        panel.add(attachmentButton, c);
        c.gridx = 1;
        c.gridy = 4;
        c.fill = GridBagConstraints.NONE;
        panel.add(sendButton, c);
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Browse")) {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                attachmentTextField.setText(file.getAbsolutePath());
            }
        } else if (e.getActionCommand().equals("Send")) {
            String to = toTextField.getText();
            String subject = subjectTextField.getText();
            String body = bodyTextArea.getText();
            String attachmentPath = attachmentTextField.getText();
            if (to.isEmpty() || subject.isEmpty() || body.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter all required information.");
                return;
            }
            String from = "yourmail";
            String password = "yourpass";
            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.port", "587");
            properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            };
            Session session = Session.getDefaultInstance(properties, authenticator);

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(subject);
                MimeBodyPart bodyPart = new MimeBodyPart();
                bodyPart.setText(body);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(bodyPart);
                if (!attachmentPath.isEmpty()) {
                    MimeBodyPart attachmentPart = new MimeBodyPart();
                    File attachmentFile = new File(attachmentPath);
                    attachmentPart.attachFile(attachmentFile);
                    multipart.addBodyPart(attachmentPart);
                }
                message.setContent(multipart);
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, password);
                transport.sendMessage(message, message.getAllRecipients());
                JOptionPane.showMessageDialog(this, "Email sent successfully.");
            } catch (MessagingException | IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to send email.");
            }
        }
    }

    public static void main(String[] args) {
        EmailSenderGUI gui = new EmailSenderGUI();
        gui.setVisible(true);
    }
}
