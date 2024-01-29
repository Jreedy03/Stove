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


    public void decreaseTemp() {
        switch (myTemperature) {
            case BLAZING:
                if (mySetting != Setting.HIGH) {
                    myTemperature = Temperature.HOT;
                    timer = TIME_DURATION;
                }
                break;
            case HOT:
                if (mySetting != Setting.MEDIUM) {
                    myTemperature = Temperature.WARM;
                    timer = TIME_DURATION;
                }
                break;
            case WARM:
                if (mySetting != Setting.LOW) {
                    myTemperature = Temperature.COLD;
                }
                break;
            case COLD:
                break;
        }
    }

    public void updateTemperature() {
        if (timer > 0) {
            timer--;
        }

        if (timer == 0) {
            if (mySetting.ordinal() > myTemperature.ordinal()) {
            
                increaseTemp();
            } else if (mySetting.ordinal() < myTemperature.ordinal()) {
                
                decreaseTemp();
            }
    
        }
    }

public void display(Burner burner) {
    System.out.println(burner.mySetting.toString() + " ..... " + burner.get());
}
}
