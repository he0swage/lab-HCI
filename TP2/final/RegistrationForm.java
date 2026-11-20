import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RegistrationForm extends JFrame {

    // Fields = attributes (reused in the next steps)
    private JTextField lastName = new JTextField(15);
    private JTextField firstName = new JTextField(15);
    private JTextField email = new JTextField(15);
    private JPasswordField password = new JPasswordField(15);
    private JComboBox<String> year = new JComboBox<>(new String[] { "L1", "L2", "L3", "M1", "M2" });
    private JSpinner age = new JSpinner(new SpinnerNumberModel(18, 16, 60, 1));

    // Preferences components used by the listeners
    private JRadioButton campus = new JRadioButton("On campus", true);
    private JRadioButton remote = new JRadioButton("Remote");
    private JTextArea comments = new JTextArea(4, 25);

    // Table model as an attribute so the Submit listener can see it
    private DefaultTableModel model = new DefaultTableModel(
            new String[] { "Last name", "First name", "Year", "Mode" }, 0);

    public RegistrationForm() {
        super("Registration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        year.setSelectedItem("L3");

        // ===== Menu bar: File (New, Save, Exit) and Help (About) =====
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        JMenuItem miNew = new JMenuItem("New");
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        JMenuItem miAbout = new JMenuItem("About");
        file.add(miNew);
        file.add(miSave);
        file.addSeparator();
        file.add(miExit);
        help.add(miAbout);
        bar.add(file);
        bar.add(help);
        setJMenuBar(bar);

        // ===== Tab "Identity": 6 rows x 2 columns =====
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

        // ===== Tab "Preferences": one component per row =====
        JPanel pref = new JPanel(new GridLayout(0, 1, 5, 5));

        // Mode: radio buttons linked by a ButtonGroup (only one selectable)
        JPanel mode = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup group = new ButtonGroup();
        group.add(campus);
        group.add(remote);
        mode.add(new JLabel("Mode:"));
        mode.add(campus);
        mode.add(remote);

        // Interests: independent check boxes (no ButtonGroup)
        JPanel interests = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox prog = new JCheckBox("Programming");
        prog.setSelected(true);
        interests.add(new JLabel("Interests:"));
        interests.add(prog);
        interests.add(new JCheckBox("AI"));
        interests.add(new JCheckBox("Databases"));
        interests.add(new JCheckBox("Networks"));

        // Languages: a list (Python selected)
        JList<String> languages = new JList<>(new String[] { "Java", "Python", "C", "JavaScript" });
        languages.setSelectedIndex(1);

        // Level: a slider 0..10, ticks every 5
        JPanel level = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSlider slider = new JSlider(0, 10, 5);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        level.add(new JLabel("Level:"));
        level.add(slider);

        pref.add(mode);
        pref.add(interests);
        pref.add(new JScrollPane(languages));
        pref.add(level);
        pref.add(new JScrollPane(comments));
        tabs.addTab("Preferences", pref);

        // ===== Tab "Registered": table updated by Submit =====
        tabs.addTab("Registered", new JScrollPane(new JTable(model)));

        add(tabs, BorderLayout.CENTER);

        // ===== Bottom panel: main action last, on the right =====
        JCheckBox terms = new JCheckBox("I accept the terms");
        JButton reset = new JButton("Reset");
        JButton submit = new JButton("Submit");
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.add(terms);
        south.add(reset);
        south.add(submit);
        add(south, BorderLayout.SOUTH);

        // Submit disabled until the terms are accepted (error prevention)
        submit.setEnabled(false);
        terms.addActionListener(e -> submit.setEnabled(terms.isSelected()));

        // ===== Events =====
        reset.addActionListener(e -> clear());
        miNew.addActionListener(e -> clear());
        miExit.addActionListener(e -> System.exit(0));
        miAbout.addActionListener(e -> JOptionPane.showMessageDialog(this, "Registration v1.0"));
        submit.addActionListener(e -> {
            String modeText = campus.isSelected() ? "On campus" : "Remote";
            model.addRow(new Object[] { lastName.getText(), firstName.getText(),
                    year.getSelectedItem(), modeText });
            JOptionPane.showMessageDialog(this,
                    "Welcome " + firstName.getText() + " (" + age.getValue() + ")");
        });

        pack();
        setLocationRelativeTo(null);
    }

    // Empties the text fields (used by Reset and New)
    private void clear() {
        lastName.setText("");
        firstName.setText("");
        email.setText("");
        password.setText("");
        comments.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}