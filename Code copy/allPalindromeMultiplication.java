public class allPalindromeMultiplication {
   public static void main (String[] args) {
      int count = 0;

      for (int i = 100; i <= 999; i++) {
         for (int n = 100; n <= 999; n++) {
            if (isPalindrome(i * n)) {
               // for ALL possibilities
               // System.out.println(i + " * " + n);
               // count++;

               // for possibilities where i is equal to n
               if (i == n) {
                  System.out.println(i + " * " + n);
                  count++;
               }
            }
         }
      }

      System.out.println("NUMBER OF POSSIBILITIES: " + count);
   }

   public static boolean isPalindrome (int product) {
      int reversedProduct = reverseInt(product);

      if (product == reversedProduct) {
         return true;
      }

      return false;
   }

   public static int reverseInt (int original) {
      int reversed = 0;
      int lastDigit = 0;

      while (original != 0) {
         lastDigit = original % 10;
         reversed = reversed * 10 + lastDigit;
         original = original / 10;
      }

      return reversed;
   }
}
