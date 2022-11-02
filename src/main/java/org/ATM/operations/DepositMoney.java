package org.ATM.operations;

import org.ATM.model.Card;
import org.ATM.service.ATMService;
import org.ATM.util.Currency;
import org.ATM.util.Util;

public class DepositMoney extends Operation {

    public DepositMoney(Card card) {
        super(card);
    }

    @Override
    public void startOperation() {
        Currency currency = Util.changeCurrency(scanner);
        System.out.println("Введите сумму, которую хотите внести");
        double amount = scanner.nextDouble();
        card.setBalance(card.getBalance() + amount);
        depositMoneyIntoStorage(currency, amount);
    }

    private void depositMoneyIntoStorage(Currency currency, double amount) {
        ATMService.getMoneyStorage().put(currency, ATMService.getMoneyStorage().get(currency) + amount);
    }
}
