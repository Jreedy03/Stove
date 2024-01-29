public class Burner {
    private enum Temperature {
        BLAZING, HOT, WARM, COLD;
    }
   private Temperature myTemperature;
   private Setting mySetting;
   private int timer;
   public static final int TIME_DURATION = 2;

   public Temperature get() {
        return myTemperature;
   }

   public Burner() {
        this.mySetting = Setting.OFF;
        this.myTemperature = Temperature.COLD;
   }

   public void plusButton() {
        switch (mySetting) {
            case OFF:
                mySetting = Setting.LOW;
                break;
            case LOW:
                mySetting = Setting.MEDIUM;
                break;
            case MEDIUM:
                mySetting = Setting.HIGH;
                break;
            case HIGH:
                break;
        }
        timer = TIME_DURATION;
   }

   public void minusButton() {
    switch (mySetting) {
        case OFF:
            break;
        case LOW:
            mySetting = Setting.OFF;
            break;
        case MEDIUM:
            mySetting = Setting.LOW;
            break;
        case HIGH:
            mySetting = Setting.MEDIUM;
            break;
    }
    timer = TIME_DURATION;
}
}
