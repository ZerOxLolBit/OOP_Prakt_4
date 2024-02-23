import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private String username;  // для авторизації
  private String password;  // для авторизації
  private Account account;  // обліковий запис

  // Конструктор
  public Person(String name, String username, String password, Account account) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.account = account;
  }
  public Person(){

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
