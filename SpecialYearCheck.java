import java.util.Scanner;
public class SpecialYearCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");

        try {
            int year = Integer.parseInt(scanner.nextLine());
            if (isSpecialYear(year)) {
                System.out.println(year + " is special.");
            } else {
                System.out.println(year + " is not special.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error");
        } finally {
            scanner.close();
        }
    }

    public static boolean isSpecialYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}