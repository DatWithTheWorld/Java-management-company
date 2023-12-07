package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Camera extends JFrame implements Runnable, ThreadFactory {

    private JPanel contentPane;
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private JPanel panelcamera;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Camera frame = new Camera();
                    frame.setVisible(true);
                    Thread thread = new Thread(frame);
                    thread.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setBounds(0, 0, 470, 300);
        panelcamera.add(panel);
    }

    /**
     * Create the frame.
     */
    public Camera() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 530, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelcamera = new JPanel();
        panelcamera.setLayout(null);
        panelcamera.setBounds(10, 10, 700, 400);
        contentPane.add(panelcamera);
        initWebcam();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "Thread");
        t.setDaemon(true);
        return t;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, e);
                Thread.currentThread().interrupt();
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap map = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(map);
            } catch (NotFoundException e) {
                Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, e);
            }
            if (result != null) {
               MainPageView.getTfpasswordlogin().setText(result.getText());
                System.out.println(result.getText());
              
            }
        }
    }

}