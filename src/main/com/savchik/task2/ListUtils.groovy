package main.com.savchik.task2;

public class ListUtils {
    public static void removeSequences(List list, int minSequenceLength) {
        if (!validateParams(list, minSequenceLength)) {
            return
        }

        def sequences = splitBySequences(list)
        list.clear()
        list.addAll(sequences.findAll {it.size() < minSequenceLength}.flatten())
    }

    public static void removeDuplicates(List<Integer> list, int minDuplicatesCount) {
        if(!validateParams(list, minDuplicatesCount)) {
            return
        }

        def numberDuplicates = [:]
        list.each { value ->
            numberDuplicates[value] = numberDuplicates.getOrDefault(value, 0) + 1
        }
        numberDuplicates.findAll{it.value >= minDuplicatesCount}.each {list.removeAll(it.key)}
    }

    private static boolean validateParams(List<Integer> list, int numericConstraint) {
        list && numericConstraint > 2
    }

    private static List<List> splitBySequences(List list) {
        def currentSequence = []
        def sequences = []

        list.each { value ->
            if (currentSequence && value == currentSequence.last()) {
                currentSequence << value
            } else {
                sequences.add(currentSequence)
                currentSequence = [value]
            }
        }
        sequences.add(currentSequence)

        sequences
    }
}
