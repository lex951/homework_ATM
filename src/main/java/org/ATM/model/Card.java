package org.ATM.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Card {
    private User holder;
    private String number;
    private int pin;
    private double balance;

    public Card(String number,Integer pin){
        this.pin=pin;
        this.number=number;
    }

}
