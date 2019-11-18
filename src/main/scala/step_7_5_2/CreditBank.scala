package step_7_5_2

class CreditBank extends BankA with BankB with BankC with BankD with BankE {
  override def issueCredit: Unit = println("" + b + c + d + f + a + e)
}
