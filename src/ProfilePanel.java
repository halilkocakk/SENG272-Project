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

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username: "));
        userNameField = new JTextField();
        add(userNameField);

        add(new JLabel("School: "));
        schoolField = new JTextField();
        add(schoolField);

        add(new JLabel("Session Name: "));
        sessionNameField = new JTextField();
        add(sessionNameField);

        nextButton = new JButton("Next");
        add(new JLabel());
        add(nextButton);

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
