package AbstractionExercise.CardsWithPower;

import AbstractionExercise.CardRank.CardRank;
import AbstractionExercise.CardSuit.CardSuit;

public class Card {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int calculatePower() {
        return this.suit.getPower() + this.rank.getPower();
    }

    public String toString() {
        return String.format("AbstractionExercise.CardsWithPower.Card name: %s of %s; AbstractionExercise.CardsWithPower.Card power: %d", rank, suit, calculatePower());
    }
}
