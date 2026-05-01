import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class CollectPanel extends StepPanel {
    private JTable table;
    private JButton backButton;
    private JButton nextButton;
    private DefaultTableModel model;
    private Scenario scenario;

    public CollectPanel(ActionListener nextListener, ActionListener backListener) {
        super("Collect");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] columnNames = {"Dimension", "Metric", "Direction", "Value", "Score"};

        model = new DefaultTableModel(columnNames, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton = new JButton("Back"));
        buttonPanel.add(nextButton = new JButton("Next"));
        backButton.setActionCommand("CollectBack");
        nextButton.setActionCommand("CollectNext");
        backButton.addActionListener(backListener);
        nextButton.addActionListener(nextListener);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void loadScenario(Scenario scenario) {
        this.scenario = scenario;
        model.setRowCount(0);
        for (QualityDimension dimension : scenario.getDimensions()) {
            for (Metric metric : dimension.getMetrics()) {
                model.addRow(new Object[]{
                        dimension.getName(),
                        metric.getName(),
                        metric.isHigherBetter() ? "Higher is Better" : "Lower is Better",
                        "",
                        ""
                });
            }
        }
    }

    public boolean applyValues() {
        int row = 0;

        for (QualityDimension dimension : scenario.getDimensions()) {
            for (Metric metric : dimension.getMetrics()) {

                try {
                    Object val = table.getValueAt(row, 3);
                    if (val == null || val.toString().trim().isEmpty()) {
                        return false;
                    }
                    double value = Double.parseDouble(val.toString());
                    metric.setValue(value);

                    double score = metric.getScore();
                    model.setValueAt(score, row, 4);

                } catch (Exception e) {
                    return false;
                }
                row++;
            }
        }
        return true;
    }
    public void showWarning(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Validation Error", JOptionPane.ERROR_MESSAGE);
    }
}
