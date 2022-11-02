package org.ATM.service;

import lombok.Getter;
import org.ATM.model.Card;
import org.ATM.operations.DepositMoney;
import org.ATM.operations.GetBalance;
import org.ATM.operations.Operation;
import org.ATM.operations.WithdrawMoney;
import org.ATM.util.Currency;
import org.ATM.util.Util;

import java.util.HashMap;
import java.util.Scanner;

import static org.ATM.util.Phrases.*;

public class ATMService {
    @Getter
    private static HashMap<Currency, Double> moneyStorage = new HashMap<>();
    @Getter
    private static HashMap<String, Card> cardStorage = new HashMap<>();
    private static Card card;
    private static Operation operation;
    private static Scanner scanner = new Scanner(System.in);

    public static void welcome() {
        Util.startPreparing();
        System.out.println(WELCOME);
        int choice = 3;
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> userWelcome();
            case 2 -> adminWelcome();
            default -> {
                System.out.println("Вы ввели некорректное число!");
                welcome();
            }
        }
    }

    public static void adminWelcome() {
        int choice;
        while (true) {
            System.out.println(ADMIN);
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> AdminService.depositMoney();
                case 2 -> {
                    Card card = CardService.addCard();
                    cardStorage.put(card.getNumber(), card);
                }
                case 0 -> {
                    welcome();
                }
                default -> System.out.println(INCORRECT_OPERATION);
            }
        }
    }

    public static void userWelcome() {
        if (!checkCardAndPin()) welcome();
        int choice;
        while (true) {
            System.out.println(USER);
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> operation = new WithdrawMoney(card);
                case 2 -> operation = new DepositMoney(card);
                case 3 -> operation = new GetBalance(card);
                case 0 -> {
                    welcome();
                }
                default -> {
                    System.out.println(INCORRECT_OPERATION);
                }
            }
            operation.startOperation();
        }

    }

    private static boolean checkCardAndPin() {

        System.out.println("Введите номер карты");
        String cardNumber = scanner.next();
        for (int attempt = 0; attempt < 3; attempt++) {
            System.out.println("Введите пин-код");
            int pin = scanner.nextInt();
            if (cardStorage.containsKey(cardNumber) && cardStorage.get(cardNumber).getPin() == pin) {
                System.out.println("Корректный пиин-код");
                card = cardStorage.get(cardNumber);
                return true;
            }
            System.out.println("Неправильный номер карты или пин-код");
        }
        return false;
    }

}
