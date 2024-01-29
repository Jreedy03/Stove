public class Burner {
    private enum Temperature {
        BLAZING, HOT, WARM, COLD;
    }
   private Temperature myTemperature;
   private Setting mySetting;
   private int timer = 0;
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

    public void increaseTemp() {
        switch (myTemperature) {
            case COLD:
                if (mySetting != Setting.OFF) {
                    myTemperature = Temperature.WARM;
                    if (mySetting != Setting.LOW) {
                        timer = TIME_DURATION;
                    }
                }
                break;
            case WARM:
            if (mySetting != Setting.LOW) {
                myTemperature = Temperature.HOT;
                if (mySetting != Setting.MEDIUM) {
                    timer = TIME_DURATION;
                }
            }
                break;
            case HOT:
            if (mySetting != Setting.MEDIUM) {
                myTemperature = Temperature.BLAZING;
            }
                break;
            case BLAZING:
                break;
        }
    }

    public void updateTemperature() {
        timer--;
        if (timer == 0) {
            increaseTemp();
        }
    }
}
