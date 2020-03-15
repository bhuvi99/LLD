package com.design.games.cards.player;

import com.design.games.cards.card.Card;
import com.design.games.cards.card.CardUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private final UUID id;
    private String name;
    private List<Card> cards;

    private Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public static Player constructPlayer(String name) {
        Player player = new Player(name);
        player.cards = new ArrayList<>();
        return player;
    }

    public void showCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public Player getWinner(Player player) {
        return CardUtil.compare(this.cards, player.cards) > 0 ? this : player;
    }


    public List<Card> returnAllCards() {
        List<Card> cardsToReturn = cards;
        cards = new ArrayList<>();
        return cardsToReturn;
    }

    public Card removeWorstCard() {
        if (cards.isEmpty()) return null;
        Card cardToReturn = cards.get(0);
        cards.remove(0);
        return cardToReturn;
    }

    public void pickCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public boolean equals(Player player) {
        return this.id.equals(player.id);
    }

    public String toString() {
        return "Player = " +
                "{ name = " + this.name + ", " +
                "id = " + this.id
                + " }";
    }
}
