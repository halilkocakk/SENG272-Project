import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AnalysePanel extends StepPanel{
    private ArrayList<JProgressBar> resultBars;
    private JLabel gapAnalysisLabel;
    private JButton backButton;
    private JPanel barPanel;

    public AnalysePanel(ActionListener backListener) {
        super("Analyse");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        resultBars = new ArrayList<>();

        barPanel = new JPanel();
        barPanel.setLayout(new GridLayout(0, 1, 10, 10));
        add(barPanel, BorderLayout.CENTER);

        gapAnalysisLabel = new JLabel("Gap Analysis: ");
        add(gapAnalysisLabel, BorderLayout.NORTH);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(209, 203, 94, 255));
        backButton.setActionCommand("AnalyseBack");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);
    }

    public void showAnalyses (Scenario scenario) {
        barPanel.removeAll();
        resultBars.clear();
        for(QualityDimension dimension : scenario.getDimensions()) {
            double rawScore = dimension.calculateDimensionScore();
            int score = (int) (rawScore * 20);
            JProgressBar bar = new JProgressBar(0, 100);
            bar.setValue(score);
            bar.setString(dimension.getName() + " (" +String.format("%.2f", rawScore) + ")");
            bar.setStringPainted(true);
            barPanel.add(bar);
            resultBars.add(bar);
            if(score < 40)
                bar.setForeground(new Color(156, 51, 51));
            else if(score < 70)
                bar.setForeground(new Color(200, 136, 35));
            else
                bar.setForeground(new Color(77, 152, 70));
        }
        showGapAnalysis(scenario);
        revalidate();
        repaint();
    }

    public void showGapAnalysis(Scenario scenario) {
        double lowest = Double.MAX_VALUE;
        String weakest = "";

        for(QualityDimension dimension : scenario.getDimensions()) {
            double score = dimension.calculateDimensionScore();
            if(score < lowest) {
                lowest = score;
                weakest = dimension.getName();
            }
        }
        gapAnalysisLabel.setText("Weakest dimension: " + weakest + " (" + String.format("%.2f", lowest) + ")");
    }
}
