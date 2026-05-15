public class Metric {

    private String name;
    private double coefficient;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;
    private double value;



    public Metric(String name, double coefficient, String direction, double minValue, double maxValue,
                  String unit) {
        this.name = name;
        this.coefficient = coefficient;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() { return maxValue;
    }

    public String getName() {
        return name;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public double getScore() {
        return calculateScore();
    }

    public double calculateScore() {
        double score;
        if(isHigherBetter()) {
            score = 1 + (value - minValue) / (maxValue - minValue) * 4;
        } else {
            score = 5 - (value - minValue) / (maxValue - minValue) * 4;
        }
        return roundToNearestHalf(score);
    }

    public boolean isHigherBetter() {
        return "HIGHER".equalsIgnoreCase(direction);
    }

    private double roundToNearestHalf(double score) {
        return Math.round(score * 2) / 2.0;
    }
}
