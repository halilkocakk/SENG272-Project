import javax.swing.*;

public abstract class StepPanel extends JPanel {

    protected String stepName;

    public StepPanel(String stepName) {
        this.stepName = stepName;
    }
}
