import javax.swing.*;

public abstract class StepPanel extends JPanel {

    protected String stepName;

    public StepPanel(String stepName) {
        this.stepName = stepName;
    }

    public String getStepName() {
        return stepName;
    }

    public boolean validateStep() {
        return true;
    }

    public void onNext() {
    }

    public void onBack() {
    }
}
