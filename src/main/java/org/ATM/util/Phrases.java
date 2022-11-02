package org.ATM.util;

public enum Phrases {
    ;
    public static final String WELCOME = "Добро пожаловать! Нажмите " +
            "\n1 Чтобы воспользоваться банкоматом " +
            "\n2 Чтобы зайти в качестве администратора";

    public static final String ADMIN = "Выберите операцию" +
            "\n 1 Внести деньги" +
            "\n 2 Добавить новую карту" +
            "\n 0 Предыдущее меню";

    public static final String USER = "Выберите операцию" +
            "\n 1 Cнять деньги" +
            "\n 2 Внести деньги" +
            "\n 3 Узнать баланс" +
            "\n 0 Предыдущее меню";

    public static final String INCORRECT_OPERATION="Вы выбрали некорректную операцию. Пожалуйста, повторите попытку";
}
