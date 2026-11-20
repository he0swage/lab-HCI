import javax.swing.*;
import java.awt.*;

public class WelcomeAppWindow extends JFrame {
    public WelcomeAppWindow() {
        setTitle("Welcome App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JTextField textField = new JTextField("Alice", 15);
        JButton button = new JButton("Say Hello");
        JLabel message = new JLabel("Message: ");

        JPanel top = new JPanel(new FlowLayout());
        top.add(textField);
        top.add(button);

        button.addActionListener(e -> {
            String name = textField.getText();
            message.setText("Message: Welcome " + name + "!");
        });

        add(top, BorderLayout.NORTH);
        add(message, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomeAppWindow().setVisible(true));
    }
}