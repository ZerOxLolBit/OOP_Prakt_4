import java.util.Scanner;

public class Menu {
  public static boolean choiceLoop = true;
  public static Person currentPerson = null;
  public static int amount;
  public static int currentPersonPIN;
  static String errorMsg = "Введіть коректне значення.";
  public static void show(){
    while (choiceLoop) {

      if (currentPerson == null) {

        System.out.println("1) Авторизація");
        System.out.println("2) Вихід");

      } else {

        Account account = currentPerson.getAccount(); // ініціалізація об'єкта Account
        String accountString = account.toString(); // виклик методу toString()
        System.out.println("---------------------");
        System.out.println(accountString); // виведення рядка репрезентації об'єкта Account
        System.out.println("---------------------");
        System.out.println("1) Поповнити рахунок");
        System.out.println("2) Зняти гроші");
        System.out.println("3) Історія транзакцій");
        System.out.println("4) Купити товар");
        System.out.println("5) Вийти");

      }

      Scanner scanner = new Scanner(System.in);
      int choice = checkInputInformation();

      switch (choice) {
        case 1:
          if (currentPerson == null) {
            Authorization.authorization();
            break;
          } else {
            System.out.println("Введіть суму яку хочете внести:");
            amount = checkInputInformation();

            System.out.println("Введіть PIN-код");
            currentPersonPIN = checkInputInformation();

            currentPerson.getAccount().deposit(amount, currentPersonPIN, currentPerson.getAccount().getAssociatedCards().getCardPIN());
            break;
          }
        case 2:
          if (currentPerson == null) {
            System.out.println("Дякую, що скористалися нашою програмою.");
            System.exit(0);
          } else {

            System.out.println("Введіть суму яку хочете зняти:");
            amount = checkInputInformation();

            System.out.println("Введіть PIN-код");
            currentPersonPIN = checkInputInformation();

            currentPerson.getAccount().withdraw(amount, currentPersonPIN, currentPerson.getAccount().getAssociatedCards().getCardPIN());
            break;

          }
        case 3:
          if (currentPerson == null) {
          } else {
            Transaction[] transactions = currentPerson.getAccount().getTransactionHistory().toArray(new Transaction[0]);
            for (Transaction transaction : transactions) {
              System.out.println(transaction);
            }
            break;
          }
        case 4:
          if (currentPerson == null) {
            System.out.println(errorMsg);
            break;
          } else {
            Shop.buyingProducts();
            break;
          }
        case 5:
          if (currentPerson == null) {
            System.out.println(errorMsg);
            break;
          } else {
            Transaction[] transactions = currentPerson.getAccount().getTransactionHistory().toArray(new Transaction[0]);
            for (Transaction transaction : transactions) {
              System.out.println(transaction);
            }
            currentPerson = null;
            break;
          }
        default:
          System.out.println(errorMsg);
          break;
      }
    }
  }

  public static <typeInform> typeInform checkInputInformation(){
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if (scanner.hasNextInt()) {
        return (typeInform) Integer.valueOf(scanner.nextInt());
      } else if (scanner.hasNextDouble()) {
        return (typeInform) Double.valueOf(scanner.nextDouble());
      } else {
        System.out.println(errorMsg);
        scanner.next(); // Очистити введений рядок
      }
    }
  }
}
