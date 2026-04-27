public class MeasurementSession {
    private UserProfile userProfile;
    private Scenario selectedScenario;
    private int currentStep;

    public MeasurementSession() {
        this.currentStep = 1;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public Scenario getSelectedScenario() {
        return selectedScenario;
    }

    public void setSelectedScenario(Scenario selectedScenario) {
        this.selectedScenario = selectedScenario;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void nextStep() {
        if(currentStep < 5){
            currentStep++;
        }
    }
    public void previousStep() {
        if(currentStep > 1){
            currentStep--;
        }
    }
}
