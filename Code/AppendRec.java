public class AppendRec {
   public static String appendNTimes (String original, int n) {
      if (n == 0) {
         return original;
      }

      return (original + appendNTimes(original, n-1));
   }

   public static void main (String[] args) {
      String original = IO.readString();
      int n = IO.readInt();

      System.out.println(appendNTimes(original, n));
   }
}
