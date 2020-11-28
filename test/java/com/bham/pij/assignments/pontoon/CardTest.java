package com.bham.pij.assignments.pontoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CardTest {
    @Test
    @DisplayName("getCardSuit() should return the correct enum for the card suit")
    void testSuitGet() {
        Card testCard = new Card(Card.Suit.CLUBS, Card.Value.JACK);
        Assertions.assertEquals(testCard.getCardSuit(), Card.Suit.CLUBS);

        testCard.cardSuit = Card.Suit.SPADES;
        Assertions.assertEquals(testCard.getCardSuit(), Card.Suit.SPADES);
        testCard.cardSuit = Card.Suit.HEARTS;
        Assertions.assertEquals(testCard.getCardSuit(), Card.Suit.HEARTS);
        testCard.cardSuit = Card.Suit.DIAMONDS;
        Assertions.assertEquals(testCard.getCardSuit(), Card.Suit.DIAMONDS);
    }
    @Test
    @DisplayName("setCardSuit() should change Card.Suit")
    void testSuitSet(){
        Card testCard = new Card(Card.Suit.CLUBS, Card.Value.JACK);
        testCard.setCardSuit(Card.Suit.HEARTS);
        Assertions.assertEquals(Card.Suit.HEARTS, testCard.cardSuit);
    }
    @Test
    @DisplayName("getNumericalValue the two values for Aces, the face value for number cards, and 10 for royalty")
    void testNumericalValue(){
        Card testCard = new Card(Card.Suit.CLUBS, Card.Value.ACE);

        ArrayList<Integer> correctAce = new ArrayList<Integer>();
        correctAce.add(1);
        correctAce.add(11);

        Assertions.assertEquals(correctAce, testCard.getNumericalValue());
        for(Card.Value v: Card.Value.values()){
            testCard.setCardValue(v);
            switch (v){
                case JACK:
                case QUEEN:
                case KING:
                    ArrayList<Integer> expectedRoyalty = new ArrayList<>();
                    expectedRoyalty.add(10);
                    Assertions.assertEquals(expectedRoyalty, testCard.getNumericalValue());
                    break;
                case ACE:
                    break;
                default:
                    ArrayList<Integer> expected = new ArrayList<>();
                    expected.add(v.ordinal()+1);
                    Assertions.assertEquals(expected, testCard.getNumericalValue());
                    break;
            }
        }
    }
}
