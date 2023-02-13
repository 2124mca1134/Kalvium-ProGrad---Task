import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeCalculator {
  
  public static int[] getChange(int change, int[] denominations, int[] availableCoins) {
    int[] changeCoins = new int[denominations.length];
    Arrays.fill(changeCoins, 0);
    
    for (int i = denominations.length - 1; i >= 0; i--) {
      while (change >= denominations[i] && availableCoins[i] > 0) {
        change -= denominations[i];
        changeCoins[i]++;
        availableCoins[i]--;
      }
    }
    
    if (change == 0) {
      return changeCoins;
    } else {
      return null;
    }
  }
  
  public static void main(String[] args) {
    int change = 43;
    int[] denominations = new int[] {1, 2, 5, 10};
    int[] availableCoins = new int[] {100, 100, 100, 100};
    int[] changeCoins = getChange(change, denominations, availableCoins);
    
    if (changeCoins != null) {
      System.out.println("Change coins: " + Arrays.toString(changeCoins));
    } else {
      System.out.println("Cannot provide the required change.");
    }
  }
}