import java.util.ArrayList;

public class ScenarioRepository {
    private ArrayList<Scenario> scenarios;

    public ScenarioRepository() {
        scenarios = new ArrayList<>();
        loadScenarios();
    }

    public void loadScenarios() {
        scenarios.clear();

        Scenario s = new Scenario("Scenario C - Team Alpha", "EDUCATION", "PRODUCT");

        QualityDimension usability = new QualityDimension("Usability", 25);
        usability.addMetric(new Metric("SUS Score", 50, "HIGHER", 0, 100, "points"));
        usability.addMetric(new Metric("Onboarding Time", 50, "LOWER", 0, 60, "min"));
        s.addDimension(usability);

        QualityDimension performance = new QualityDimension("Performance Efficiency", 20);
        performance.addMetric(new Metric("Video Start Time", 50, "LOWER", 0, 15, "sec"));
        performance.addMetric(new Metric("Concurrent Exams", 50, "HIGHER", 0, 600, "users"));
        s.addDimension(performance);

        QualityDimension accessibility = new QualityDimension("Accessibility", 20);
        accessibility.addMetric(new Metric("WCAG Compliance", 50, "HIGHER", 0, 100, "%"));
        accessibility.addMetric(new Metric("Screen Reader Score", 50, "HIGHER", 0, 100, "%"));
        s.addDimension(accessibility);

        QualityDimension reliability = new QualityDimension("Reliability", 20);
        reliability.addMetric(new Metric("Uptime", 50, "HIGHER", 95, 100, "%"));
        reliability.addMetric(new Metric("MTTR", 50, "LOWER", 0, 120, "min"));
        s.addDimension(reliability);

        QualityDimension functional = new QualityDimension("Functional Suitability", 15);
        functional.addMetric(new Metric("Feature Completion", 50, "HIGHER", 0, 100, "%"));
        functional.addMetric(new Metric("Assignment Submit Rate", 50, "HIGHER", 0, 100, "%"));
        s.addDimension(functional);

        scenarios.add(s);
    }

    public ArrayList<Scenario> getScenariosByMode(String mode) {
        ArrayList<Scenario> result = new ArrayList<>();

        for (Scenario s : scenarios) {
            if (s.getMode().equalsIgnoreCase(mode)) {
                result.add(s);
            }
        }
        return result;
    }

    public Scenario getScenarioByName(String name) {
        for (Scenario s : scenarios) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}
