public class Burner {
    private enum Temperature {
        BLAZING, HOT, WARM, COLD;
    }
   private Temperature myTemperature;
   private Setting mySetting;

   public Temperature get() {
        return myTemperature;
   }
}
