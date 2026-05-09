import java.util.ArrayList;

public class ScenarioRepository {
    private ArrayList<Scenario> scenarios;

    public ScenarioRepository() {
        scenarios = new ArrayList<>();
        loadScenarios();
    }

    public void loadScenarios() {
        scenarios.clear();

        Scenario s1 = new Scenario("City Hospital Management System", "HEALTH", "PRODUCT");

        QualityDimension reliability1 = new QualityDimension("Reliability", 30);
        reliability1.addMetric(new Metric("System Availability", 50, "HIGHER", 0, 100, "%"));
        reliability1.addMetric(new Metric("Patient Record Accuracy", 50, "HIGHER", 0, 100, "%"));
        s1.addDimension(reliability1);

        QualityDimension performance1 = new QualityDimension("Performance Efficiency", 25);
        performance1.addMetric(new Metric("Appointment Response Time", 50, "LOWER", 0, 20, "sec"));
        performance1.addMetric(new Metric("Database Query Speed", 50, "LOWER", 0, 10, "sec"));
        s1.addDimension(performance1);

        QualityDimension security1 = new QualityDimension("Security", 25);
        security1.addMetric(new Metric("Security Incident Count", 50, "LOWER", 0, 20, "count"));
        security1.addMetric(new Metric("Authentication Success Rate", 50, "HIGHER", 0, 100, "%"));
        s1.addDimension(security1);

        QualityDimension usability1 = new QualityDimension("Usability", 20);
        usability1.addMetric(new Metric("Doctor Satisfaction", 50, "HIGHER", 0, 100, "%"));
        usability1.addMetric(new Metric("Average Training Time", 50, "LOWER", 0, 60, "min"));
        s1.addDimension(usability1);

        scenarios.add(s1);

        Scenario s2 = new Scenario("Telemedicine Development Workflow", "HEALTH", "PROCESS");

        QualityDimension maintainability2 = new QualityDimension("Maintainability", 25);
        maintainability2.addMetric(new Metric("Bug Resolution Time", 50, "LOWER", 0, 72, "hours"));
        maintainability2.addMetric(new Metric("Code Review Completion", 50, "HIGHER", 0, 100, "%"));
        s2.addDimension(maintainability2);

        QualityDimension performance2 = new QualityDimension("Performance Efficiency", 25);
        performance2.addMetric(new Metric("CI/CD Pipeline Duration", 50, "LOWER", 0, 30, "min"));
        performance2.addMetric(new Metric("Built Success Rate", 50, "HIGHER", 0, 100, "%"));
        s2.addDimension(performance2);

        QualityDimension functional2 = new QualityDimension("Functional Suitability", 25);
        functional2.addMetric(new Metric("Requirement Coverage", 50, "HIGHER", 0, 100, "%"));
        functional2.addMetric(new Metric("Testing Completion", 50, "HIGHER", 0, 100, "%"));
        s2.addDimension(functional2);

        QualityDimension reliability2 = new QualityDimension("Reliability", 25);
        reliability2.addMetric(new Metric("Development Success Rate", 50, "HIGHER", 0, 100, "%"));
        reliability2.addMetric(new Metric("Insident Recovery Time", 50, "LOWER", 0, 60, "min"));
        s2.addDimension(reliability2);

        scenarios.add(s2);

        Scenario s3 = new Scenario("E-Learning Platform", "EDUCATION", "PRODUCT");

        QualityDimension usability3 = new QualityDimension("Usability", 25);
        usability3.addMetric(new Metric("SUS Score", 50, "HIGHER", 0, 100, "points"));
        usability3.addMetric(new Metric("Onboarding Time", 50, "LOWER", 0, 60, "min"));
        s3.addDimension(usability3);

        QualityDimension performance3 = new QualityDimension("Performance Efficiency", 20);
        performance3.addMetric(new Metric("Video Start Time", 50, "LOWER", 0, 15, "sec"));
        performance3.addMetric(new Metric("Concurrent Exams", 50, "HIGHER", 0, 600, "users"));
        s3.addDimension(performance3);

        QualityDimension accessibility3 = new QualityDimension("Accessibility", 20);
        accessibility3.addMetric(new Metric("WCAG Compliance", 50, "HIGHER", 0, 100, "%"));
        accessibility3.addMetric(new Metric("Screen Reader Score", 50, "HIGHER", 0, 100, "%"));
        s3.addDimension(accessibility3);

        QualityDimension reliability3 = new QualityDimension("Reliability", 20);
        reliability3.addMetric(new Metric("Uptime", 50, "HIGHER", 95, 100, "%"));
        reliability3.addMetric(new Metric("MTTR", 50, "LOWER", 0, 120, "min"));
        s3.addDimension(reliability3);

        QualityDimension functional3 = new QualityDimension("Functional Suitability", 15);
        functional3.addMetric(new Metric("Feature Completion", 50, "HIGHER", 0, 100, "%"));
        functional3.addMetric(new Metric("Assignment Submit Rate", 50, "HIGHER", 0, 100, "%"));
        s3.addDimension(functional3);

        scenarios.add(s3);

        Scenario s4 = new Scenario("Smart Learning Development Process", "EDUCATION", "PROCESS");

        QualityDimension maintainability4 = new QualityDimension("Maintainability", 30);
        maintainability4.addMetric(new Metric("Average Bug Fix Time", 50, "LOWER", 0, 72, "hours"));
        maintainability4.addMetric(new Metric("Code Review Completion", 50, "HIGHER", 0, 100, "%"));
        s4.addDimension(maintainability4);

        QualityDimension performance4 = new QualityDimension("Performance Efficiency", 25);
        performance4.addMetric(new Metric("CI/CD Pipeline Duration", 50, "LOWER", 0, 30, "min"));
        performance4.addMetric(new Metric("Splint Completion Rate", 50, "HIGHER", 0, 100, "%"));
        s4.addDimension(performance4);

        QualityDimension functional4 = new QualityDimension("Functional Suitability", 25);
        functional4.addMetric(new Metric("Requirement Coverage", 50, "HIGHER", 0, 100, "%"));
        functional4.addMetric(new Metric("Testing Completion", 50, "HIGHER", 0, 100, "%"));
        s4.addDimension(functional4);

        QualityDimension reliability4 = new QualityDimension("Reliability", 20);
        reliability4.addMetric(new Metric("Built Success Rate", 50, "HIGHER", 0, 100, "%"));
        reliability4.addMetric(new Metric("Deployment Failure Rate", 50, "LOWER", 0, 20, "%"));
        s4.addDimension(reliability4);

        scenarios.add(s4);
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
