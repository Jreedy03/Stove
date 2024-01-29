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
}
