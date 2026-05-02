import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProfilePanel extends StepPanel {
    private JTextField userNameField;
    private JTextField schoolField;
    private JTextField sessionNameField;
    private JButton nextButton;

    public ProfilePanel(ActionListener nextListener) {
        super("Profile");

        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.add(new JLabel("Username: "));
        formPanel.add(userNameField = new JTextField(20));

        formPanel.add(new JLabel("School: "));
        formPanel.add(schoolField = new JTextField(20));

        formPanel.add(new JLabel("Session Name: "));
        formPanel.add(sessionNameField = new JTextField(20));

        add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton = new JButton("Next"));
        nextButton.setPreferredSize(new Dimension(120, 40));
        nextButton.setBackground(new Color(90, 181, 86));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        nextButton.addActionListener(nextListener);
        nextButton.setActionCommand("ProfileNext");

        userNameField.addActionListener(e -> schoolField.requestFocus());
        schoolField.addActionListener(e -> sessionNameField.requestFocus());
        sessionNameField.addActionListener(e -> nextButton.doClick());

    }

    public UserProfile getEnteredProfile() {
        return new UserProfile(
                userNameField.getText().trim(),
                schoolField.getText().trim(),
                sessionNameField.getText().trim());
    }

    public boolean validateFields() {
        return !userNameField.getText().trim().isEmpty() &&
                !schoolField.getText().trim().isEmpty() &&
                !sessionNameField.getText().trim().isEmpty();
    }

    public void showValidationError() {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

}
