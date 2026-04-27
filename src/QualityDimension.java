import java.util.ArrayList;

public class QualityDimension {
    private String name;
    private ArrayList<Metric> metrics;
    private double coefficient;

    public QualityDimension(String name, double coefficient) {
        this.name = name;
        this.coefficient = coefficient;
        this.metrics = new ArrayList<>();
    }

    public void addMetric(Metric metric) {
        metrics.add(metric);
    }

    public ArrayList<Metric> getMetrics() {
        return new ArrayList<>(metrics);
    }

    public String getName() {
        return name;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public double calculateDimensionScore() {
        if (metrics.isEmpty())
            return 0;

        double totalScore = 0;
        double weightSum = 0;

        for (Metric metric : metrics) {
            totalScore += metric.getScore() * metric.getCoefficient();
            weightSum += metric.getCoefficient();
        }
        if(weightSum == 0)
            return 0;

        return totalScore / weightSum;
    }
}

