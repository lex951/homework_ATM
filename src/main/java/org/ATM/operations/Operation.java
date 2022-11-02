package org.ATM.operations;

import org.ATM.model.Card;
import org.ATM.util.Currency;

import java.util.Scanner;

public abstract class Operation {
        protected Card card;
        protected Scanner scanner=new Scanner(System.in);

        public Operation(Card card){
                this.card=card;
        }

        public abstract void startOperation();

}
