import javax.swing.*;
import java.awt.*;

public class RegistrationForm12 extends JFrame {

    private JTextField lastName = new JTextField(15);
    private JTextField firstName = new JTextField(15);
    private JTextField email = new JTextField(15);
    private JPasswordField password = new JPasswordField(15);
    private JComboBox<String> year = new JComboBox<>(new String[] { "L1", "L2", "L3", "M1", "M2" });
    private JSpinner age = new JSpinner(new SpinnerNumberModel(18, 16, 60, 1));

    public RegistrationForm12() {
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

        JPanel pref = new JPanel(new GridLayout(0, 1, 5, 5));

        JPanel mode = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton campus = new JRadioButton("On campus", true);
        JRadioButton remote = new JRadioButton("Remote");
        ButtonGroup group = new ButtonGroup();
        group.add(campus);
        group.add(remote);
        mode.add(new JLabel("Mode:"));
        mode.add(campus);
        mode.add(remote);

        JPanel interests = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox prog = new JCheckBox("Programming");
        prog.setSelected(true);
        interests.add(new JLabel("Interests:"));
        interests.add(prog);
        interests.add(new JCheckBox("AI"));
        interests.add(new JCheckBox("Databases"));
        interests.add(new JCheckBox("Networks"));

        JList<String> languages = new JList<>(new String[] { "Java", "Python", "C", "JavaScript" });
        languages.setSelectedIndex(1);

        JPanel level = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSlider slider = new JSlider(0, 10, 5);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        level.add(new JLabel("Level:"));
        level.add(slider);

        JTextArea comments = new JTextArea(4, 25);

        pref.add(mode);
        pref.add(interests);
        pref.add(new JScrollPane(languages));
        pref.add(level);
        pref.add(new JScrollPane(comments));
        tabs.addTab("Preferences", pref);

        add(tabs, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm12().setVisible(true));
    }
}