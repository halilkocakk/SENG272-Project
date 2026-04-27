public class UserProfile {
    private String userName;
    private String school;
    private String sessionName;

    public UserProfile() {
    }

    public UserProfile(String userName, String school, String sessionName) {
        this.userName = userName;
        this.school = school;
        this.sessionName = sessionName;
    }

    public String getUserName() {
        return userName;
    }

    public String getSchool() {
        return school;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public boolean isComplete() {
        return isValid(userName) && isValid(school) && isValid(sessionName);
    }

    private boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
