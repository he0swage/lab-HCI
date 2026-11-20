import javax.swing.*;
import java.awt.*;

public class RegistrationForm11 extends JFrame {

    private JTextField lastName = new JTextField(15);
    private JTextField firstName = new JTextField(15);
    private JTextField email = new JTextField(15);
    private JPasswordField password = new JPasswordField(15);
    private JComboBox<String> year = new JComboBox<>(new String[] { "L1", "L2", "L3", "M1", "M2" });
    private JSpinner age = new JSpinner(new SpinnerNumberModel(18, 16, 60, 1));

    public RegistrationForm11() {
        super("Registration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        year.setSelectedItem("L3");

        JPanel id = new JPanel(new GridLayout(6, 2, 10, 10));
        id.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        id.add(new JLabel("Last name:"));
        id.add(lastName);
        id.add(new JLabel("First name:"));
        id.add(firstName);
        id.add(new JLabel("Email:"));
        id.add(email);
        id.add(new JLabel("Password:"));
        id.add(password);
        id.add(new JLabel("Year:"));
        id.add(year);
        id.add(new JLabel("Age:"));
        id.add(age);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Identity", id);

        add(tabs, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm11().setVisible(true));
    }
}