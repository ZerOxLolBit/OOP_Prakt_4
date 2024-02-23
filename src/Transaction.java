import java.time.LocalDateTime;

public class Transaction {
  private String type;
  private double amount;
  private LocalDateTime timestamp;

  // Конструктор
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timestamp = LocalDateTime.now();
  }
  public  Transaction(){

  }

  // Геттер для отримання типу транзакції
  public String getType() {
    return type;
  }

  // Геттер для отримання суми транзакції
  public double getAmount() {
    return amount;
  }

  // Геттер для отримання часу транзакції
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "\n" + "Transaction{" +
        "type='" + type + '\'' +
        ", amount=" + amount +
        ", timestamp=" + timestamp +
        '\'' + '}'; // додаємо новий пустий рядок
  }
}
