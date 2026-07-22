package bank_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AccountTest {
  @Test
  void 口座作成時の残高は0円() {
    Account account = new Account();
    assertEquals(0, account.getBalance());
  }

  @Test
  void 入金すると残高が増える() {
    Account account = new Account();

    account.deposit(1000);

    assertEquals(1000, account.getBalance());
  }

  @Test
  void 複数回入金できる() {
    Account account = new Account();

    account.deposit(500);
    account.deposit(500);

    assertEquals(1000, account.getBalance());
  }

  @Test
  void 出金すると残高が減る() {
    Account account = new Account();

    account.deposit(1000);
    assertEquals(1000, account.getBalance());
    account.withdraw(500);
    assertEquals(500, account.getBalance());
  }

  @Test
  void 複数回出金できる() {
    Account account = new Account();

    account.deposit(1000);
    account.withdraw(500);
    account.withdraw(500);
    
    assertEquals(0, account.getBalance());
  }

  @Test
  void 残高不足で出金すると例外() {
    Account account = new Account();

    IllegalArgumentException e =
      assertThrows(IllegalArgumentException.class, () -> account.withdraw(500));
    assertEquals("残高が不足しています", e.getMessage());
  }

  @Test
  void マイナス入金は例外() {
    Account account = new Account();

    assertThrows(IllegalArgumentException.class, () -> account.deposit(-500));
  }

  @Test
  void 他口座へ振込できる() {
    Account from = new Account();
    Account to = new Account();

    from.deposit(1000);
    from.transfer(to, 500);

    assertEquals(500, from.getBalance());
    assertEquals(500, to.getBalance());
  }

  @Test
  void 入金履歴を記録できる() {
    Account account = new Account();

    account.deposit(1000);
    assertEquals(List.of("入金額: 1000円"), account.getDepositHistory());
  }

  @Test
  void 複数回入金した履歴を取得できる() {
    Account account = new Account();

    account.deposit(1000);
    account.deposit(1000);
    account.deposit(1000);
    
    assertEquals(List.of("入金額: 1000円", "入金額: 1000円", "入金額: 1000円"), account.getDepositHistory());
  }
}
