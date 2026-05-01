import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WizzardController implements ActionListener{
    private MainFrame mainFrame;
    private MeasurementSession session;
    private ScenarioRepository repository;

    public WizzardController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.session = new MeasurementSession();
        this.repository = new ScenarioRepository();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "ProfileNext":
                handleProfileNext();
                break;
            case "DefineNext":
                handleDefineNext();
                break;
            case "PlanNext":
                handlePlanNext();
                break;
            case "CollectNext":
                handleCollectNext();
                break;
            case "PlanBack":
                mainFrame.showStep("Define", 2);
                break;
            case"CollectBack":
                mainFrame.showStep("Plan", 3);
                break;
            case "AnalyseBack":
                mainFrame.showStep("Collect", 4);
                break;
        }
    }

    private void handleProfileNext() {
        ProfilePanel panel = mainFrame.getProfilePanel();
        if(!panel.validateFields()) {
            panel.showValidationError();
            return;
        }
        UserProfile profile = panel.getEnteredProfile();
        session.setUserProfile(profile);
        mainFrame.showStep("Define", 2);
    }

    private void handleDefineNext() {
        DefinePanel panel = mainFrame.getDefinePanel();
        if(!panel.validateSelection()) {
            panel.showWarning("Please complete selection.");
            return;
        }
        String scenarioName = panel.getSelectedScenario();
        Scenario scenario = repository.getScenarioByName(scenarioName);
        session.setSelectedScenario(scenario);
        mainFrame.getPlanPanel().loadScenario(scenario);
        mainFrame.showStep("Plan", 3);
    }

    private void handlePlanNext() {
        mainFrame.getCollectPanel().loadScenario(session.getSelectedScenario());
        mainFrame.showStep("Collect", 4);
    }

    private void handleCollectNext() {
        CollectPanel panel = mainFrame.getCollectPanel();
        if(!panel.applyValues()) {
            panel.showWarning("Please enter valid values.");
            return;
        }

        mainFrame.getAnalysePanel().showAnalyses(session.getSelectedScenario());
        mainFrame.showStep("Analyse", 5);
    }
}
