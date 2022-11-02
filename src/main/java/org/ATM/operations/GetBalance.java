package org.ATM.operations;

import org.ATM.model.Card;

public class GetBalance extends Operation {

    public GetBalance(Card card) {
        super(card);
    }

    @Override
    public void startOperation() {
        System.out.println("Баланс " + card.getBalance());
    }
}
