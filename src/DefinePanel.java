import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DefinePanel extends StepPanel {

    private JRadioButton productRadio;
    private JRadioButton processRadio;
    private JRadioButton healthRadio;
    private JRadioButton educationRadio;
    private JComboBox<String> scenarioComboBox;
    private JButton nextButton;
    private JButton backButton;
    private ScenarioRepository repository;

    public DefinePanel(ScenarioRepository repository,
                       ActionListener nextListener,
                       ActionListener backListener) {
        super("Define");
        this.repository = repository;

        setLayout(new GridLayout(6, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(new JLabel("Quality Type:"));
        JPanel typePanel = new JPanel();
        productRadio = new JRadioButton("Product");
        processRadio = new JRadioButton("Process");

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(productRadio);
        typeGroup.add(processRadio);

        typePanel.add(productRadio);
        typePanel.add(processRadio);
        add(typePanel);


        add(new JLabel("Mode:"));
        JPanel modePanel = new JPanel();
        healthRadio = new JRadioButton("Health");
        educationRadio = new JRadioButton("Education");

        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(healthRadio);
        modeGroup.add(educationRadio);

        modePanel.add(healthRadio);
        modePanel.add(educationRadio);
        add(modePanel);

        add(new JLabel("Scenario:"));
        scenarioComboBox = new JComboBox<>();
        add(scenarioComboBox);

        backButton = new JButton("Back");
        nextButton = new JButton("Next");

        add(backButton);
        add(nextButton);

        nextButton.setBackground(new Color(90, 181, 86, 255));
        nextButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(209, 203, 94, 255));
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(backListener);
        nextButton.addActionListener(nextListener);

        nextButton.setActionCommand("DefineNext");
        backButton.setActionCommand("DefineBack");

        healthRadio.addActionListener(e -> updateScenarioList("HEALTH"));
        educationRadio.addActionListener(e -> updateScenarioList("EDUCATION"));

    }

    public void updateScenarioList(String mode) {
            scenarioComboBox.removeAllItems();

            ArrayList<Scenario> list = repository.getScenariosByMode(mode);

            for (Scenario s : list) {
                scenarioComboBox.addItem(s.getName());
            }
        if (list.isEmpty()) {
            scenarioComboBox.addItem("No scenarios available");
        }
    }

    public String getSelectedQualityType() {
        if (productRadio.isSelected()) return "PRODUCT";
        if (processRadio.isSelected()) return "PROCESS";
        return null;
    }

    public String getSelectedMode() {
        if (healthRadio.isSelected()) return "HEALTH";
        if (educationRadio.isSelected()) return "EDUCATION";
        return null;
    }

    public String getSelectedScenario() {
        return (String) scenarioComboBox.getSelectedItem();
    }

    public boolean validateSelection() {
        return getSelectedQualityType() != null
                && getSelectedMode() != null
                && getSelectedScenario() != null;
    }

    public void showWarning(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Selection Error", JOptionPane.ERROR_MESSAGE);
    }
}
