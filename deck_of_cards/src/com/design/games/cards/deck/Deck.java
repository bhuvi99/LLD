package com.design.games.cards.deck;

import com.design.games.cards.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private List<Card> returnedCards;

    private Deck(List<Card> cards) {
        this.cards = cards;
        this.returnedCards = new ArrayList<>();
    }

    public static Deck buildDeck() {
        List<Card> deckCards = DeckUtils.prepareAllCards();
        Deck deck = new Deck(deckCards);
        deck.shuffle();
        return deck;
    }

    public void shuffle() {
        addReturnedCards();
        Collections.shuffle(cards);
    }

    private void addReturnedCards() {
        Collections.shuffle(returnedCards);
        cards.addAll(returnedCards);
        returnedCards = new ArrayList<>();
    }

    public List<Card> getCards(int numberOfCards) {
        if (numberOfCards < cards.size()) {
            addReturnedCards();
        }
        List<Card> cardsToBeReturn = new ArrayList<>();
        cardsToBeReturn.addAll(cards.subList(0, numberOfCards));
        cards.removeAll(cardsToBeReturn);
        return cardsToBeReturn;
    }

    public void addCards(List<Card> returnedCards) {
        returnedCards.addAll(returnedCards);
    }

    public void printCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
