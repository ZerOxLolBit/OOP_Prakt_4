public class Generator_Inform {
  public static Product[] products = new Product[20];
  private static Account[] accounts = new Account[5];
  private static Card[] cards = new Card[5];
  private static Person[] persons = new Person[5];

  public Generator_Inform() {
  }

  public static void main(String[] args) {
    initializePerson();
    initializeProducts();
  }
  public static Person[] initializePerson(){
    initializeAccount();
    persons[0] = new Person("John Doe", "john123", "pass123", accounts[0]);
    persons[1] = new Person("Alice Smith", "alice456", "pass456", accounts[1]);
    persons[2] = new Person("Bob Johnson", "bob789", "pass789", accounts[2]);
    persons[3] = new Person("Eva Davis", "eva999", "pass999", accounts[3]);
    persons[4] = new Person("Mike Brown", "mike111", "pass111", accounts[4]);
    return persons;
  }
  public static Account[] initializeAccount(){
    initializeCard();
    accounts[0] = new Account(1, 1000.0, "USD", cards[0]);
    accounts[1] = new Account(2, 1500.0, "EUR", cards[1]);
    accounts[2] = new Account(3, 8000.0, "GBP", cards[2]);
    accounts[3] = new Account(4, 1200.0, "USD", cards[3]);
    accounts[4] = new Account(5, 2000.0, "EUR", cards[4]);

    return accounts;
  }
  public static Card[] initializeCard(){
    cards[0] = new Card(123456789, 1111);
    cards[1] = new Card(987654321, 9999);
    cards[2] = new Card(987654321, 2222);
    cards[3] = new Card(135792468, 3333);
    cards[4] = new Card(246813579, 4444);
    return cards;
  }
  public static Product[] initializeProducts() {
    products[0] = new Product(1, "Computer", "Cool computer", 1000);
    products[1] = new Product(2, "Pen", "Ballpoint pen with blue ink", 1.5);
    products[2] = new Product(3, "Notebook", "A5 size, 80 pages, ruled", 3);
    products[3] = new Product(4, "Highlighter", "Yellow, chisel tip", 1);
    products[4] = new Product(5, "Pencil Set", "Pack of 12 pencils, assorted colors", 2.5);
    products[5] = new Product(6, "Eraser", "White eraser, latex-free", 0.75);
    products[6] = new Product(7, "Book", "Fiction book", 15.99);
    products[7] = new Product(8, "Chair", "Wooden chair", 45.99);
    products[8] = new Product(9, "Table", "Coffee table", 99.99);
    products[9] = new Product(10, "Headphones", "Wireless headphones", 149.99);
    products[10] = new Product(11, "Keyboard", "Mechanical keyboard", 79.99);
    products[11] = new Product(12, "Mouse", "Wireless mouse", 29.99);
    products[12] = new Product(13, "Backpack", "School backpack", 39.99);
    products[13] = new Product(14, "Calculator", "Scientific calculator", 19.99);
    products[14] = new Product(15, "Sunglasses", "Polarized sunglasses", 59.99);
    products[15] = new Product(16, "Wallet", "Leather wallet", 49.99);
    products[16] = new Product(17, "Watch", "Digital watch", 99.99);
    products[17] = new Product(18, "Laptop Sleeve", "Neoprene laptop sleeve", 24.99);
    products[18] = new Product(19, "USB Flash Drive", "32GB USB flash drive", 9.99);
    products[19] = new Product(20, "Water Bottle", "Stainless steel water bottle", 14.99);
    return products;
  }
}