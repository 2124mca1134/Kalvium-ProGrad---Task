import java.util.*;

public class Main {
  private int[] coinDenominations;
  private int[] coinCounts;

  public Main(int[] coinDenominations, int[] coinCounts) {
    this.coinDenominations = coinDenominations;
    this.coinCounts = coinCounts;
  }

  public int[] calculateChange(int changeAmount) {
    ArrayList<Integer> change = new ArrayList<Integer>();
    for (int i = coinDenominations.length - 1; i >= 0; i--) {
      int coinValue = coinDenominations[i];
      while (changeAmount >= coinValue && coinCounts[i] > 0) {
        changeAmount -= coinValue;
        change.add(coinValue);
      }
    }
    if (changeAmount != 0) {
      // Not enough coins to make change
      return null;
    } else {
      int[] result = new int[change.size()];
      for (int i = 0; i < result.length; i++) {
        result[i] = change.get(i);
      }
      return result;
    }
  }

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
    int[] britishCoinDenominations = {1, 2, 5, 10, 20, 50};
    int[] britishCoinCounts = {10, 10, 10, 10, 10, 10};
    int[] usCoinDenominations = {1, 5, 10, 25};
    int[] usCoinCounts = {10, 10, 10, 10};
    int[] norCoinDenominations = {1, 5, 10, 20};
    int[] norCoinCounts = {10, 10, 10, 10};
    Main britishChangeCalculator = new Main(britishCoinDenominations, britishCoinCounts);
    Main usChangeCalculator = new Main(usCoinDenominations, usCoinCounts);
    Main norChangeCalculator = new Main(norCoinDenominations, norCoinCounts);
    
    System.out.println("Select for British Pound(br), US Dollar(us), Norwegian Krone(nor)");
    String choose = sc.nextLine();
    System.out.println("Please enter currency");
    int num=sc.nextInt();
    String br = "br", us = "us", nor = "nor";
    if(choose.toLowerCase().equals(br.toLowerCase())){
        int[] change = britishChangeCalculator.calculateChange(num);
            if (change != null) {
          System.out.println("Change: " + java.util.Arrays.toString(change));
        } else {
          System.out.println("Not enough coins to make change.");
        }
    }
    else if(choose.toLowerCase().equals(us.toLowerCase())){
        int[] change = usChangeCalculator.calculateChange(num);
            if (change != null) {
          System.out.println("Change: " + java.util.Arrays.toString(change));
        } else {
          System.out.println("Not enough coins to make change.");
        }
    }
    else if(choose.toLowerCase().equals(nor.toLowerCase())){
        int[] change = norChangeCalculator.calculateChange(num);
            if (change != null) {
          System.out.println("Change: " + java.util.Arrays.toString(change));
        } else {
          System.out.println("Not enough coins to make change.");
        }
    }
    else {
        System.out.println("Please enter correct input");
    }
  }
}
