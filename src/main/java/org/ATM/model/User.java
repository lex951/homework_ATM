package org.ATM.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private double balance;
    private List<Card> cards;
}
