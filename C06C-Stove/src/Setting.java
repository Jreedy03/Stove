public enum Setting {
    OFF("---"), 
    LOW("--+"), 
    MEDIUM("-++"), 
    HIGH("+++");

    private String setting;

    Setting(String setting) {
        this.setting = setting;
    }

}
