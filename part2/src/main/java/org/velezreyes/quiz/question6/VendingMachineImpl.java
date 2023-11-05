package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {
  private int moneyInserted = 0;
  private static final int SCOTTCOLA_PRICE = 75;
    private static final int KARENTEA_PRICE = 100;

  public static VendingMachine getInstance() {
    // Fix me!
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    moneyInserted += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (name.equals("ScottCola")) {
      if (moneyInserted < SCOTTCOLA_PRICE) {
        throw new NotEnoughMoneyException();
      }
      moneyInserted -= SCOTTCOLA_PRICE;
      return new ScottCola();
    } else if (name.equals("KarenTea")) {
      if (moneyInserted < KARENTEA_PRICE) {
        throw new NotEnoughMoneyException();
      }
      moneyInserted -= KARENTEA_PRICE;
      return new KarenTea();
    } else {
      throw new UnknownDrinkException();
    }
  }
}
