package com.design.games.cards;

import com.design.games.cards.game.Game;
import com.design.games.cards.player.Player;

public class Stimulator {

    public static void main(String[] args) {

        Game game = new Game();
        Player player1 = Player.constructPlayer("Facebook");
        Player player2 = Player.constructPlayer("Google");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.startGame(2);
        game.makeMove(player1);
        player1.showCards();
        game.shuffleDeck();
        game.makeMove(player2);
        player2.showCards();

        game.showEachPlayerCards();

        Player winner = game.findWinner();
        System.out.println(winner);
        game.end();
    }
}
