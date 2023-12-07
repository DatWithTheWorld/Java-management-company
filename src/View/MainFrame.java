package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton addButton;
    private JPanel containerPanel;

    public MainFrame() {
        setTitle("Java Swing Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        addButton = new JButton("Thêm layout");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewLayout();
            }
        });
        mainPanel.add(addButton, BorderLayout.NORTH);

        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void addNewLayout() {
        JPanel newLayout = new JPanel();
        newLayout.setLayout(new FlowLayout());

        JLabel label = new JLabel("Label:");
        JTextField textField = new JTextField(20);

        newLayout.add(label);
        newLayout.add(textField);

        containerPanel.add(newLayout);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}