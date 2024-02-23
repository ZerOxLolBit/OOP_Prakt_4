import java.time.LocalDateTime;
import java.util.Scanner;

public class Shop {

  private static int productId;
  private static int amount;
  private static double totalPrice;
  private static Product foundProduct;
  static double currentPersonBalance = Menu.currentPerson.getAccount().getBalance();
  private static LocalDateTime currentTime = LocalDateTime.now();


  public static void buyingProducts() {
    Scanner scanner = new Scanner(System.in);
    Product[] products = Generator_Inform.initializeProducts();
    for (Product product : products) {
      System.out.println(product.toString());
    }

    System.out.println("Оберіть товар (введіть число):");
    productId = Menu.checkInputInformation();
    System.out.println("Введіть кількість:");
    amount = Menu.checkInputInformation();


    for (Product product : products) {
      if (product.getProductId() == productId) {
        foundProduct = product;
        break; // Якщо знайдено продукт з відповідним id, виходимо з циклу
      }
    }

    totalPrice = foundProduct.getPrice() * amount;

    System.out.println("Загальна сума: " + totalPrice + " $");
    int currentPersonPIN = Menu.currentPerson.getAccount().getAssociatedCards().getCardPIN();
    while (true) {
      System.out.println("Бажаєте сплатити? (так/ні) :");
      String response = scanner.nextLine();

      if (response.equalsIgnoreCase("так")) {
        System.out.println("Введіть PIN-код: ");
        int enteredPIN = Menu.checkInputInformation();

        if (enteredPIN == currentPersonPIN) {

          if (totalPrice <= currentPersonBalance) {
            // Перевіряємо чи є достатньо коштів для сплати
            currentPersonBalance -= totalPrice;
            Menu.currentPerson.getAccount().setBalance(currentPersonBalance);
            System.out.println("Сплата успішно здійснена. Залишок на балансі: " + currentPersonBalance);
            System.out.println("<" + Menu.currentPerson.getName() + "> " +
                "[" + Menu.currentPerson.getAccount().getAssociatedCards() +
                "] " + "- купив/ла " +
                "<" + foundProduct.getProductName() + "> " +
                "(Кількість - " + amount + ") " +
                "|Ціна - <" + totalPrice + ">| " +
                "|Валюта - <" + Menu.currentPerson.getAccount().getCurrency() + ">| " +
                "|Дата - <" + currentTime + "|>. Залишилось на балансі - " +
                "<" + currentPersonBalance + ">" );
            Menu.currentPerson.getAccount().getTransactionHistory().add(new Transaction("Shoping", totalPrice));
            break; // Завершуємо цикл, оскільки операція успішно завершена
          } else {
            // Якщо коштів недостатньо для сплати
            System.out.println("На балансі недостатньо коштів для сплати.");
            break; // Виходимо з циклу, бо операція не може бути завершена
          }
        } else {
          // Користувач ввів неправильний PIN-код
          System.out.println("Неправильний PIN-код. Спробуйте ще раз.");
          // Продовжуємо цикл для повторного введення
        }
      } else if (response.equalsIgnoreCase("ні")) {
        // Користувач вирішив не сплачувати
        System.out.println("Ви вирішили не сплачувати. Вихід із програми.");
        break; // Завершуємо цикл, оскільки операція завершена
      } else {
        System.out.println("Неправильний ввід.");
        // Продовжуємо цикл для повторного введення
      }
    }
  }
}
