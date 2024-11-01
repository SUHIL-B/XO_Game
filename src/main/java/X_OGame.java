public class X_OGame {
    
   static StartFrame frame;
   static boolean sound_ON = true;
    
    
    public static void main(String[] args) {
      
        frame = new StartFrame();
       }

    public static boolean getSound_ON() {
        return sound_ON;
    }
    public static void setSound_ON(boolean sound_ON) {
        X_OGame.sound_ON = sound_ON;
    }
}
