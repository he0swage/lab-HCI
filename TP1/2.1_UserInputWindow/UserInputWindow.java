import javax.swing.*;
import java.awt.*;

public class UserInputWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("User Input");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 1, 5, 5));

            JLabel label = new JLabel("Enter your name:");
            JTextField textField = new JTextField(15);
            JButton button = new JButton("Submit");

            frame.add(label);
            frame.add(textField);
            frame.add(button);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}