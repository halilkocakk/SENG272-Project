import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout layout;
    private JPanel mainPanel;
    private StepIndicatorPanel stepIndicatorPanel;
    private ProfilePanel profilePanel;
    private DefinePanel definePanel;
    private PlanPanel planPanel;
    private CollectPanel collectPanel;
    private AnalysePanel analysePanel;
    private WizzardController controller;

    public MainFrame() {
        super("ISO 15939 Measurement Tool");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        layout = new CardLayout();
        mainPanel = new JPanel(layout);
        controller = new WizzardController(this);
        add(mainPanel, BorderLayout.CENTER);
        stepIndicatorPanel = new StepIndicatorPanel();
        profilePanel = new ProfilePanel(controller);
        definePanel = new DefinePanel(new ScenarioRepository(), controller, controller);
        planPanel = new PlanPanel(controller, controller);
        collectPanel = new CollectPanel(controller, controller);
        analysePanel = new AnalysePanel(controller);

        mainPanel.add(profilePanel, "Profile");
        mainPanel.add(definePanel, "Define");
        mainPanel.add(planPanel, "Plan");
        mainPanel.add(collectPanel, "Collect");
        mainPanel.add(analysePanel, "Analyse");

        add(stepIndicatorPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void showStep(String stepName, int stepIndex) {
        layout.show(mainPanel, stepName);
        stepIndicatorPanel.updateStepIndicator(stepIndex);
    }

    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }

    public DefinePanel getDefinePanel() {
        return definePanel;
    }

    public PlanPanel getPlanPanel() {
        return planPanel;
    }

    public CollectPanel getCollectPanel() {
        return collectPanel;
    }

    public AnalysePanel getAnalysePanel() {
        return analysePanel;
    }
}
