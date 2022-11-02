package org.ATM.operations;

import org.ATM.model.Card;
import org.ATM.service.ATMService;
import org.ATM.util.Currency;
import org.ATM.util.Util;

public class WithdrawMoney extends Operation {

    public WithdrawMoney(Card card) {
        super(card);
    }

    @Override
    public void startOperation() {
        Currency currency = Util.changeCurrency(scanner);
        System.out.println("Введите сумму, которую хотите снять");
        double amount = scanner.nextDouble();
        if (amount > card.getBalance()) startOperation();
        card.setBalance(card.getBalance() - amount);
        takeMoneyFromStorage(currency, amount);
    }

    private void takeMoneyFromStorage(Currency currency, double amount) {
        ATMService.getMoneyStorage().put(currency, ATMService.getMoneyStorage().get(currency) - amount);
    }
}
