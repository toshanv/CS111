public class Pokemon {
   private String name;
   private int level;
   private String type;
   private String[] moves = new String[4];
   private int hp;

   public static Pokemon (String name, int level, String type, String[] moves) {
      this.name = name;
      this.level = level;

      if (type.equals("Electric") || type.equals("Water") || type.equals("Grass") || type.equals("Fire")) {
         this.type = type;
      }

      this.moves = moves;
      this.hp = 100;
   }

   public static Pokemon (String name, String type) {
      this.name = name;
      this.level = 1;

      if (type.equals("Electric") || type.equals("Water") || type.equals("Grass") || type.equals("Fire")) {
         this.type = type;
      }

      this.moves = {"Tackle", "Vine Whip", "Thunderbolt", "Sing"};
      this.hp = 100;
   }

   public static Pokemon (String name, int level, String type) {
      this.name = name;
      this.level = level;

      if (type.equals("Electric") || type.equals("Water") || type.equals("Grass") || type.equals("Fire")) {
         this.type = type;
      }

      this.moves = {"Tackle", "Vine Whip", "Thunderbolt", "Sing"};
      this.hp = 100;
   }

   public static boolean setLevel (int level) {
      if (level < this.level || level > 100 || level < 1) {
         return false;
      }

      this.level = level;
      return true;
   }

   public static boolean setHP (int hp) {
      if (level > 100 || level < 1) {
         return false;
      }

      this.hp = hp;
      return true;
   }

   public static String getName() {
      return this.name;
   }

   public static int getLevel() {
      return this.level;
   }

   public static String getType() {
      return this.type;
   }

   public static String getMoveAtIndex (int index) {
      if (index >= 0 && index <= 3) {
         return this.move[index];
      }
   }

   public static int getHP() {
      return this.hp;
   }
}
