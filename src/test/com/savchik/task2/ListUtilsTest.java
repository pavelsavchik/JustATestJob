package test.com.savchik.task2;

import main.com.savchik.task2.ListUtils;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListUtilsTest {
    private final static int MIN_SEQUENCE_LENGTH = 3;
    private final static int MIN_DUPLICATES_COUNT = 3;

    @Test
    public void testSequencesRemoving() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 3, 3, 3, 9, 9, 4, 4, 4, 4, 4));
        ListUtils.removeSequences(list, MIN_SEQUENCE_LENGTH);
        assertEquals(Arrays.asList(1, 3, 5, 7, 9, 9, 9), list);

        ListUtils.removeSequences(list, MIN_SEQUENCE_LENGTH);
        assertEquals(Arrays.asList(1, 3, 5, 7), list);

        list = new ArrayList<>(Arrays.asList(1, 1, 1, 7, 7, 7, 3, 3, 3, 4, 4, 4, 4, 4, 4));
        ListUtils.removeSequences(list, MIN_SEQUENCE_LENGTH);
        assertEquals(Collections.emptyList(), list);

        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeSequences(list, MIN_SEQUENCE_LENGTH);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);

        list = new ArrayList<>();
        ListUtils.removeSequences(list, MIN_SEQUENCE_LENGTH);
        assertEquals(Collections.emptyList(), list);

        list = new ArrayList<>(Arrays.asList(9, 5, 4, 1));
        ListUtils.removeSequences(list, 0);
        assertEquals(Arrays.asList(9, 5, 4, 1), list);

        list = new ArrayList<>(Arrays.asList(9, 5, 4, 1));
        ListUtils.removeSequences(list, 1);
        assertEquals(Arrays.asList(9, 5, 4, 1), list);

        try {
            ListUtils.removeSequences(null, 1);
        }
        catch (Throwable exception){
            fail("Null parameter case failed for removeSequences" + exception.toString());
        }
    }

    @Test
    public void testDuplicatesRemoving() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 3, 3, 3, 9, 9, 4, 4, 4, 4, 4));
        ListUtils.removeDuplicates(list, MIN_DUPLICATES_COUNT);
        assertEquals(Arrays.asList(1, 5, 7), list);

        list = new ArrayList<>(Arrays.asList(9, 3, 5, 5, 9, 5, 3, 3, 9, 9, 4, 4, 4, 4, 4));
        ListUtils.removeDuplicates(list, MIN_DUPLICATES_COUNT);
        assertEquals(Collections.emptyList(), list);

        list = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));
        ListUtils.removeDuplicates(list, MIN_DUPLICATES_COUNT);
        assertEquals(Arrays.asList(1, 1, 2, 2, 3, 3), list);

        list = new ArrayList<>();
        ListUtils.removeDuplicates(list, MIN_SEQUENCE_LENGTH);
        assertEquals(Collections.emptyList(), list);

        list = new ArrayList<>(Arrays.asList(9, 5, 4, 1));
        ListUtils.removeDuplicates(list, 0);
        assertEquals(Arrays.asList(9, 5, 4, 1), list);

        list = new ArrayList<>(Arrays.asList(9, 5, 4, 1));
        ListUtils.removeDuplicates(list, 1);
        assertEquals(Arrays.asList(9, 5, 4, 1), list);

        try {
            ListUtils.removeDuplicates(null, 1);
        }
        catch (Throwable exception){
            fail("Null parameter case failed for removeSequences" + exception.toString());
        }
    }
}
