import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class PlanPanel extends StepPanel {
    private JTable table;
    private JButton backButton;
    private JButton nextButton;
    private DefaultTableModel model;

    public PlanPanel(ActionListener nextListener, ActionListener backListener) {
        super("Plan");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] columnNames = {"Dimension", "Metric", "Coefficient", "Min", "Max", "Direction"};

        model = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton = new JButton("Back"));
        buttonPanel.add(nextButton = new JButton("Next"));
        nextButton.setBackground(new Color(90, 181, 86, 255));
        nextButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(209, 203, 94, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setActionCommand("PlanBack");
        nextButton.setActionCommand("PlanNext");
        backButton.addActionListener(backListener);
        nextButton.addActionListener(nextListener);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void loadScenario(Scenario scenario) {
        model.setRowCount(0);
        for (QualityDimension dimension : scenario.getDimensions()) {
            for (Metric metric : dimension.getMetrics()) {
                model.addRow(new Object[]{
                        dimension.getName(),
                        metric.getName(),
                        metric.getCoefficient(),
                        metric.getMinValue(),
                        metric.getMaxValue(),
                        metric.isHigherBetter() ? "Higher is Better" : "Lower is Better"
                });
            }
        }
    }
}
