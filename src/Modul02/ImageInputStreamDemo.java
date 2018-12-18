package Modul02;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageInputStreamDemo {
    public static void main(String[] args) {
        Image image = null;
        try {
            File sourceImage = new File("/home/alfa/NetBeansProjects/Sister/src/modul02/image.jpg");
            image = ImageIO.read(sourceImage);

            InputStream is = new BufferedInputStream(new FileInputStream(sourceImage));
            image = ImageIO.read(is);
        } catch (Exception e) {
        }

        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
}
