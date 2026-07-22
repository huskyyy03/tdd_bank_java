package bank_tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Account
 */
public class Account {
  private int balance;
  private List<String> depositHistory = new ArrayList<>();
  private List<String> withdrawHistory  = new ArrayList<>();

  public Account() {
    this.balance = 0;
  }

  public int getBalance() {
    return balance;
  }

  public List<String> getDepositHistory() {
    return depositHistory;
  }

  public List<String> getWithdrawHistory() {
    return withdrawHistory;
  }

  public void deposit(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    balance += amount;
    depositHistory.add("入金額: " + amount + "円");
  }

  public void withdraw(int amount) {
    if (balance < amount) {
      throw new IllegalArgumentException("残高が不足しています");
    }
    balance -= amount;
    withdrawHistory.add("出金額: " + amount + "円");
  }

  public void transfer(Account transferTo, int amount) {
    this.withdraw(amount);
    transferTo.deposit(amount);
  }

}
