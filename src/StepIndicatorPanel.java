import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StepIndicatorPanel extends JPanel{
    private ArrayList<JLabel> stepLabels;
    private int currentStep;

    public StepIndicatorPanel() {
        setLayout(new GridLayout(1, 5, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        stepLabels = new ArrayList<>();
        String[] steps = {"Profile", "Define", "Plan", "Collect", "Analyse"};
        for(String step : steps) {
            JLabel label = new JLabel(step, SwingConstants.CENTER);
            label.setOpaque(true);
            label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            label.setBackground(Color.WHITE);
            stepLabels.add(label);
            add(label);
        }
        updateStepIndicator(1);
    }
    public void updateStepIndicator(int currentStep) {
        this.currentStep = currentStep;

        for(int i = 0; i < stepLabels.size(); i++) {
            JLabel label = stepLabels.get(i);
            if(i == currentStep - 1) {
                label.setBackground(new Color(0x5DA2DA));
                label.setForeground(Color.DARK_GRAY);
                label.setFont(label.getFont().deriveFont(Font.BOLD));
            } else {
                label.setBackground(Color.GRAY);
                label.setForeground(Color.BLACK);
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
            }
        }
    }
}
