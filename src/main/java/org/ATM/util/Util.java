package org.ATM.util;

import org.ATM.model.Card;
import org.ATM.service.ATMService;

import java.util.Scanner;

public class Util {
    public static Currency changeCurrency(Scanner scanner){
        System.out.println("Выберите валюту" + "\n1 RUB" + "\n2 USD");
        int cur=scanner.nextInt();
        return cur==1? Currency.RUB:Currency.USD;
    }

    public static void startPreparing(){
        fillMoneyStorage();
        createSomeCards();
    }

    private static void fillMoneyStorage(){
       ATMService.getMoneyStorage().put(Currency.RUB,100000d);
       ATMService.getMoneyStorage().put(Currency.USD,100000d);
    }

    private static void createSomeCards(){
        Card card1=new Card("4444555566667777",4444);
        card1.setBalance(100000);
        Card card2=new Card("1111222233334444",1111);
        card2.setBalance(10000);
        ATMService.getCardStorage().put(card1.getNumber(),card1);
        ATMService.getCardStorage().put(card2.getNumber(), card2);
    }
}
