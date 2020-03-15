package com.design.games.cards.card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardUtil {


    public static int compare(List<Card> firstSet, List<Card> secondSet) {
        int firstSetPoints = getPoints(firstSet);
        int secondSetPoints = getPoints(secondSet);
        if (firstSetPoints == secondSetPoints) {
            return compareSuites(firstSet, secondSet);
        }
        return firstSetPoints -secondSetPoints;
    }

    public static int getPoints(List<Card> cards) {
        int points = 0;
        for (Card card : cards) {
            points = points + card.getCardValue().getValue();
        }
        return points;
    }

    public static int compareSuites(List<Card> firstSuit, List<Card> secondSuit) {
        Map<SuitType, Integer> firstSuitMap = createSuiteMap(firstSuit);
        Map<SuitType, Integer> secondSuitMap = createSuiteMap(secondSuit);
        return compareSuitesMaps(firstSuitMap, secondSuitMap);

    }

    private static int compareSuitesMaps(Map<SuitType, Integer> firstSuit, Map<SuitType, Integer> secondSuit) {
        for (SuitType suitType : SuitType.getPriorityOrder()) {
            if (firstSuit.get(suitType) != secondSuit.get(suitType)) {
                return firstSuit.get(suitType) - secondSuit.get(suitType);
            }
        }
        return 0;
    }

    private static Map<SuitType, Integer> createSuiteMap(List<Card> cards) {
        Map<SuitType, Integer> suites = new HashMap<SuitType, Integer>();
        for (Card card : cards) {
            if (!suites.containsKey(card.getSuitType())) {
                suites.put(card.getSuitType(), 0);
            }
            suites.put(card.getSuitType(), suites.get(card.getSuitType()) + 1);
        }
        return suites;
    }


}
