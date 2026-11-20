import javax.swing.*;
import java.awt.*;

public class FormLayoutWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Form Layout");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 2, 10, 10));

            frame.add(new JLabel("Label 1"));
            frame.add(new JTextField(15));

            frame.add(new JLabel("Label 2"));
            frame.add(new JTextField(15));

            frame.add(new JLabel("Label 3"));
            frame.add(new JTextField(15));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}