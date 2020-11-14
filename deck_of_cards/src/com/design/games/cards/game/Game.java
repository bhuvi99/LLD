package com.design.games.cards.game;

import com.design.games.cards.card.Card;
import com.design.games.cards.deck.Deck;
import com.design.games.cards.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private final List<Player> players;
    private final Deck deck;

    private Player lastMove = null;
    private boolean isStarted;
    public Game() {
        players = new ArrayList<>();
        deck = Deck.buildDeck();
        isStarted = false;
    }

    public Game startGame(int numberOfIntialCards) {
        if (isStarted){
            return this;
        }
        for (Player player : players) {
            player.pickCards(deck.getCards(numberOfIntialCards));
        }
        this.isStarted = true;
        return this;
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void showDeckCards() {
        deck.printCards();
    }

    public void showEachPlayerCards() {
        for (Player player : players) {
            System.out.println("Name : " + player.getName());
            player.showCards();
        }
    }

    public void end() {
        for (Player player : players) {
            List<Card> returnedCards = player.returnAllCards();
            deck.addCards(returnedCards);
        }
    }

    public Player findWinner() {
        if (players.isEmpty()) {
            return null;
        }
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            winner = winner.getWinner(player);
        }
        return winner;
    }

    public void makeMove(Player player) {
        if (!isValidMove(player)) {
            return;
        }
        Card card = player.removeWorstCard();
        List<Card> newCard = deck.getCards(1);
        player.pickCards(newCard);
        if (Objects.nonNull(card)) {
            deck.addCard(card);
        }
    }

    private boolean isValidMove(Player player) {
        return isStarted && players.contains(player) && !player.equals(this);
    }

    public void showPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
