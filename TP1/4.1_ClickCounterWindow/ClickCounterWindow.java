import javax.swing.*;
import java.awt.*;

public class ClickCounterWindow extends JFrame {
    private int count = 0;
    private JLabel label;

    public ClickCounterWindow() {
        setTitle("Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Clicks: 0");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
        label.setForeground(new Color(0x2E7D32));

        JButton button = new JButton("+1 (Click here)");
        button.setBackground(new Color(0x4CAF50));
        button.setForeground(Color.WHITE);

        button.addActionListener(e -> {
            count++;
            label.setText("Clicks: " + count);
        });

        add(label);
        add(button);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClickCounterWindow().setVisible(true));
    }
}