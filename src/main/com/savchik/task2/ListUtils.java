package main.com.savchik.task2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ListUtils {
    public static void removeSequences(List<Integer> list, int minSequenceLength) {
        if(!validateParams(list, minSequenceLength)) {
            return;
        }

        Integer previousValue = null;
        Integer currentSequenceLength = 1;
        Integer currentIndex = 0;
        List<Sequence> sequences = new LinkedList<>();

        for (Integer value : list) {
            if (value.equals(previousValue)) {
                currentSequenceLength++;
            } else {
                if (currentSequenceLength >= minSequenceLength) {
                    markSequenceAsDeleted(sequences, currentIndex - 1, currentSequenceLength);
                }
                currentSequenceLength = 1;
            }
            previousValue = value;
            currentIndex++;
        }

        if (currentSequenceLength >= minSequenceLength) {
            markSequenceAsDeleted(sequences, currentIndex - 1, currentSequenceLength);
        }

        sequences.forEach(sequence -> list.subList(sequence.getStartIndex(), sequence.getEndIndex() + 1).clear());
    }

    public static void removeDuplicates(List<Integer> list, int minDuplicatesCount) {
        if(!validateParams(list, minDuplicatesCount)) {
            return;
        }

        Map<Integer, Integer> numberDuplicates = new HashMap<>();

        for (Integer value : list) {
            Integer duplicateCount = numberDuplicates.putIfAbsent(value, 1);
            if (duplicateCount != null) {
                numberDuplicates.put(value, duplicateCount + 1);
            }
        }

        Predicate<Integer> tooMuchDuplicates = value -> numberDuplicates.get(value) >= minDuplicatesCount;
        list.removeIf(tooMuchDuplicates);
    }

    private static void markSequenceAsDeleted(List<Sequence> sequences, Integer lastItemIndex, Integer sequenceLength) {
        sequences.add(0, new Sequence(lastItemIndex - sequenceLength + 1, lastItemIndex));
    }

    private static boolean validateParams(List<Integer> list, int numericConstraint) {
        return !(list == null || list.isEmpty() || numericConstraint < 2);
    }
}
