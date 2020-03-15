package com.design.games.cards.card;

public enum CardValue {
    ACE(1),
    TWO(2),
    THREEE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int value;
    private CardValue(int valueOfCard) {
        this.value = valueOfCard;
    }

    public int getValue() {
        return value;
    }

}
