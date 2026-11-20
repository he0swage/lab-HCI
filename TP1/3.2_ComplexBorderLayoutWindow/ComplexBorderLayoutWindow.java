import javax.swing.*;
import java.awt.*;

public class ComplexBorderLayoutWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Complex BorderLayout");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(10, 10));

            JLabel header = new JLabel("[NORTH] Application Header", SwingConstants.CENTER);
            header.setOpaque(true);
            header.setBackground(new Color(0x2196F3));
            header.setForeground(Color.WHITE);
            header.setFont(header.getFont().deriveFont(Font.BOLD));
            frame.add(header, BorderLayout.NORTH);

            JLabel menu = new JLabel("[WEST] Menu", SwingConstants.CENTER);
            menu.setOpaque(true);
            menu.setBackground(new Color(0xFFEB3B));
            frame.add(menu, BorderLayout.WEST);

            JLabel content = new JLabel("[CENTER] Main Content Area", SwingConstants.CENTER);
            content.setOpaque(true);
            content.setBackground(Color.WHITE);
            frame.add(content, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            bottomPanel.setBackground(new Color(0xE0E0E0));
            bottomPanel.add(new JButton("[SOUTH] Cancel"));
            bottomPanel.add(new JButton("[SOUTH] OK"));
            frame.add(bottomPanel, BorderLayout.SOUTH);

            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}