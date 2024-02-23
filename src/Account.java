import java.util.ArrayList;
import java.util.List;
public class Account {
  private int accountId;
  private double balance;
  private String currency;
  public List<Transaction> transactionHistory;
  private Card associatedCards;

  public Account(int accountId, double balance, String currency, Card associatedCards) {
    this.accountId = accountId;
    this.balance = balance;
    this.currency = currency;
    this.associatedCards = associatedCards;
    this.transactionHistory = new ArrayList<>();
  }
  public Account(){

  }
  public void withdraw(double amount, int enteredPIN, int cardPIN) {
    if (enteredPIN == cardPIN) {
      if (amount > 0 && balance >= amount) {
        balance -= amount;
        System.out.println("Withdrawal: " + amount + " " + currency);
        transactionHistory.add(new Transaction("Withdrawal", amount));
      } else {
        System.out.println("Invalid withdrawal amount or insufficient funds.");
      }
    } else {
      System.out.println("Incorrect PIN. Withdrawal failed.");
    }
  }
  public void deposit(double amount, int enteredPIN, int cardPIN) {
    if (enteredPIN == cardPIN) {
      if (amount > 0) {
        balance += amount;
        System.out.println("Deposit: " + amount + " " + currency);
        transactionHistory.add(new Transaction("Deposit", amount));
      } else {
        System.out.println("Invalid deposit amount.");
      }
    } else {
      System.out.println("Incorrect PIN. Deposit failed.");

    }
  }
  public Card addCard(Card card){
    this.associatedCards = card;
    return card;
  }

  public Card getAssociatedCards() {
    return associatedCards;
  }

  public List<Transaction> getTransactionHistory(){ return transactionHistory;}
  public int getAccountId(){
    return accountId;
  }
  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getCurrency(){
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Account{" +
        "accountId=" + accountId +
        ", balance=" + balance +
        ", currency='" + currency + '\'' +
        ", transactionHistory=" + transactionHistory +
        ", associatedCards=" + associatedCards +
        '}'  + "\n";
  }
}
