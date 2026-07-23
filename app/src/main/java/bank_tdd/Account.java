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
    return List.copyOf(depositHistory);
  }

  public List<String> getWithdrawHistory() {
    return List.copyOf(withdrawHistory);
  }

  public void deposit(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException();
    }
    balance += amount;
    depositHistory.add("入金額: " + amount + "円");
  }

  public void withdraw(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("出金額の値が不正です");
    }
    if (balance < amount) {
      throw new IllegalStateException("残高が不足しています");
    }
    balance -= amount;
    withdrawHistory.add("出金額: " + amount + "円");
  }

  public void transfer(Account transferTo, int amount) {
    if (transferTo == null) {
      throw new IllegalArgumentException("振込先が指定されていません");
    }
    if (this == transferTo) {
      throw new IllegalArgumentException("同一口座への振込はできません");
    }
    this.withdraw(amount);
    transferTo.deposit(amount);
  }

}
