package com.bham.pij.assignments.pontoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTest {
    @Test
    @DisplayName("getName() should return player name")
    void testName() {
        Player testPlayer = new Player("Lorem Ipsum");
        Assertions.assertEquals("Lorem Ipsum", testPlayer.getName());
    }

    @Test
    void testDeal() {
        Card testCard = new Card(Card.Suit.DIAMONDS, Card.Value.FIVE);
        Card alsoTestCard = new Card(Card.Suit.CLUBS, Card.Value.QUEEN);
        Card notATestCard = new Card(Card.Suit.DIAMONDS, Card.Value.FIVE);
        Player testPlayer = new Player("Foo");

        testPlayer.dealToPlayer(testCard);
        testPlayer.dealToPlayer(alsoTestCard);

        Assertions.assertEquals(testCard, testPlayer.hand.get(0));
        Assertions.assertEquals(alsoTestCard, testPlayer.hand.get(1));
        Assertions.assertNotEquals(notATestCard, testPlayer.hand.get(0));
    }

    @Test
    void testRemove() {
        Card testCard = new Card(Card.Suit.DIAMONDS, Card.Value.FIVE);
        Card alsoTestCard = new Card(Card.Suit.DIAMONDS, Card.Value.SEVEN);
        Player testPlayer = new Player("Foo");

        testPlayer.dealToPlayer(testCard);
        testPlayer.dealToPlayer(alsoTestCard);
        testPlayer.removeCard(testCard);

        Assertions.assertEquals(alsoTestCard, testPlayer.hand.get(0));

    }

    @Test
    void testAceHandling() {
        Card testCard = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
        Card alsoTestCard = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        Card alsoAnotherTestCard = new Card(Card.Suit.SPADES, Card.Value.ACE);
        Card lastCard = new Card(Card.Suit.HEARTS, Card.Value.ACE);
        Player testPlayer = new Player("Foo");
        ArrayList<Integer> correctData = new ArrayList<>();

        correctData.add(0);
        Assertions.assertEquals(correctData, testPlayer.getNumericalHandValue());

        testPlayer.dealToPlayer(testCard);
        correctData.clear();
        correctData.add(1);
        correctData.add(11);

        Assertions.assertEquals(correctData, testPlayer.getNumericalHandValue());

        testPlayer.dealToPlayer(alsoTestCard);
        correctData.clear();
        correctData.add(2);
        correctData.add(12);
        correctData.add(22);

        Assertions.assertEquals(correctData, testPlayer.getNumericalHandValue());

        testPlayer.dealToPlayer(alsoAnotherTestCard);
        correctData.clear();
        correctData.add(3);
        correctData.add(13);
        correctData.add(23);
        correctData.add(33);

        Assertions.assertEquals(correctData, testPlayer.getNumericalHandValue());

        testPlayer.dealToPlayer(lastCard);
        correctData.clear();
        correctData.add(4);
        correctData.add(14);
        correctData.add(24);
        correctData.add(34);
        correctData.add(44);

        Assertions.assertEquals(correctData, testPlayer.getNumericalHandValue());
    }

    @Test
    void testBestHand() {
        Card testCard = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
        Card alsoTestCard = new Card(Card.Suit.CLUBS, Card.Value.SEVEN);
        Card alsoAnotherTestCard = new Card(Card.Suit.SPADES, Card.Value.TWO);
        Card lastCard = new Card(Card.Suit.HEARTS, Card.Value.ACE);
        Player testPlayer = new Player("Foo");

        Assertions.assertEquals(0, testPlayer.getBestNumericalHandValue());

        testPlayer.dealToPlayer(testCard);
        Assertions.assertEquals(11, testPlayer.getBestNumericalHandValue());

        testPlayer.dealToPlayer(alsoTestCard);
        Assertions.assertEquals(18, testPlayer.getBestNumericalHandValue());

        testPlayer.removeCard(testCard);
        Assertions.assertEquals(7, testPlayer.getBestNumericalHandValue());

        testPlayer.dealToPlayer(testCard);
        testPlayer.dealToPlayer(alsoAnotherTestCard);
        Assertions.assertEquals(20, testPlayer.getBestNumericalHandValue());

    }

    @Test
    void testHandSize(){
        Card testCard = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
        Card alsoTestCard = new Card(Card.Suit.CLUBS, Card.Value.SEVEN);
        Card alsoAnotherTestCard = new Card(Card.Suit.SPADES, Card.Value.TWO);
        Card lastCard = new Card(Card.Suit.HEARTS, Card.Value.ACE);
        Player testPlayer = new Player("Foo");

        Assertions.assertEquals(0, testPlayer.getHandSize());

        testPlayer.dealToPlayer(testCard);
        Assertions.assertEquals(1, testPlayer.getHandSize());

        testPlayer.dealToPlayer(alsoTestCard);
        Assertions.assertEquals(2, testPlayer.getHandSize());

        testPlayer.dealToPlayer(alsoAnotherTestCard);
        Assertions.assertEquals(3, testPlayer.getHandSize());

        testPlayer.dealToPlayer(lastCard);
        Assertions.assertEquals(4, testPlayer.getHandSize());
    }
}
