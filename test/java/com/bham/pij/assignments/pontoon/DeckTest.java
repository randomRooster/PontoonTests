package com.bham.pij.assignments.pontoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DeckTest {
    @Test
    void testDeckObjectConstruction(){
        Deck testDeck = new Deck();
        ArrayList<Card> allCards = new ArrayList<>();
        for(Card.Value V: Card.Value.values()){
            for(Card.Suit S: Card.Suit.values()){
                allCards.add(new Card(S, V));
            }
        }

        Assertions.assertEquals(52, testDeck.size());

        //for(Card c: ){

        //}
    }
}
