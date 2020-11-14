package com.design.games.cards.card;

import java.util.*;

public enum SuitType {
    DAIMONDS(4),
    CLUBS(3),
    HEARTS(2),
    SPADES(1);

    int priority;

    SuitType(int priority) {
        this.priority = priority;
    }

    public static List<SuitType> getPriorityOrder() {
        List<SuitType> priorityOrder = Arrays.asList(SuitType.values());
        Collections.sort(priorityOrder, new Comparator<SuitType>() {
            @Override
            public int compare(SuitType a, SuitType b) {
                return a.priority - b.priority;
            }
        });

        return priorityOrder;
    }
}
