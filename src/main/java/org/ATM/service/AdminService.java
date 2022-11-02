package org.ATM.service;

import org.ATM.util.Currency;

import org.ATM.util.Util;

import java.util.Scanner;

public class AdminService {
    static Scanner scanner = new Scanner(System.in);

    public static void depositMoney() {
        Currency currency = Util.changeCurrency(scanner);
        System.out.println("Введите сумму");
        Double banknotes = scanner.nextDouble();
        if (ATMService.getMoneyStorage().containsKey(currency)) {
            ATMService.getMoneyStorage().put(currency, ATMService.getMoneyStorage().get(currency) + banknotes);
        }
        ATMService.getMoneyStorage().put(currency, banknotes);
    }
}
