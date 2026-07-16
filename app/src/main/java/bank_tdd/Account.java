package bank_tdd;

/**
 * Account
 */
public class Account {
  private int balance;

  public Account() {
    this.balance = 0;
  }

  public int getBalance() {
    return balance;
  }

  public String getDepositHistory() {
    return "入金額: 1000円";
  }

  public void deposit(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    balance += amount;
  }

  public void withdraw(int amount) {
    if (balance < amount) {
      throw new IllegalArgumentException("残高が不足しています");
    }
    balance -= amount;
  }

  public void transfer(Account transferTo ,int amount) {
    this.withdraw(amount);
    transferTo.deposit(amount);
  }

}
