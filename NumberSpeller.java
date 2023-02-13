import java.util.Scanner;

public class NumberSpeller {
  private static final String[] ONES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
  private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
  private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
  private static final String[] THOUSANDS = {"", "thousand", "million", "billion", "trillion"};

  private static String spellNumber(int num) {
    if (num == 0) {
      return ONES[0];
    }

    StringBuilder result = new StringBuilder();
    int i = 0;

    while (num > 0) {
      if (num % 1000 != 0) {
        result.insert(0, spellNumberUnder1000(num % 1000) + THOUSANDS[i] + " ");
      }
      num /= 1000;
      i++;
    }

    return result.toString().trim();
  }

  private static String spellNumberUnder1000(int num) {
    StringBuilder result = new StringBuilder();

    if (num >= 100) {
      result.append(ONES[num / 100]).append(" hundred");
      num %= 100;
      if (num != 0) {
        result.append(" ");
      }
    }

    if (num >= 20) {
      result.append(TENS[num / 10]).append("-");
      num %= 10;
    } else if (num >= 10) {
      result.append(TEENS[num - 10]).append(" ");
      return result.toString();
    }

    if (num > 0) {
      result.append(ONES[num]);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = scanner.nextInt();

    System.out.println(spellNumber(num));
  }
}