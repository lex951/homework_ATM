package org.ATM.service;

import org.ATM.model.Card;

import java.util.Base64;
import java.util.Scanner;

public class CardService {
static Scanner scanner=new Scanner(System.in);
    public static Card addCard(){
        Card card=new Card();
        System.out.println("Введите номер карты");
        String number=scanner.nextLine();
        System.out.println("Введите пин-код");
        int pin=scanner.nextInt();
        card.setNumber(number);
        card.setPin(pin);
        card.setBalance(0);
        return card;
    }
}
