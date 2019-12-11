package linkListTest;

import arrayGenerator.generator.*;
import arrayGenerator.scope.IntegerScope;
import linkedList.list.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkListIntegerTest {

    IntegerArrayGenerator arrayGenerator = new IntegerArrayGenerator(new IntegerScope(0,1000000));
    Integer[] shortArray = arrayGenerator.getArray(200);
    Integer[] longArray = arrayGenerator.getArray(100000);
    SingleLinkList linkedList = new SingleLinkList();

    public SingleLinkList populate (Integer[] array) throws ListAccessError {
        for (int i = 0; i < array.length; i++) {
            linkedList.add(i, array[i]);
        }
        return linkedList;
    }

    @Test
    void positiveGetShortArrayTestOne() throws ListAccessError {
        populate(shortArray);
        assertEquals(shortArray[0], linkedList.get(0));
    }

    @Test
    void positiveGetShortArrayTestTwo() throws ListAccessError {
        populate(shortArray);
        assertEquals(shortArray[199], linkedList.get(199));
    }

    @Test
    void positiveGetLongArrayTestOne() throws ListAccessError {
        populate(longArray);
        assertEquals(longArray[99999], linkedList.get(99999));
    }

    @Test
    void positiveGetLongArrayTestTwo() throws ListAccessError {
        populate(longArray);
        assertEquals(longArray[85000], linkedList.get(85000));
    }

    @Test
    void negativeGetShortArrayTest() throws ListAccessError {
        populate(shortArray);
        assertNotEquals(shortArray[15], linkedList.get(190));
    }

    @Test
    void negativeGetLongTest() throws ListAccessError {
        populate(longArray);
        assertNotEquals(longArray[1], linkedList.get(2));
    }

    @Test
    void addShortListTestOne() throws ListAccessError {
        populate(shortArray);
        linkedList.add(1, 5050);
        assertEquals(linkedList.get(1), 5050);
    }

    @Test
    void addShortListTestTwo() throws ListAccessError {
        populate(shortArray);
        linkedList.add(199, 150000);
        assertEquals(linkedList.get(199), 150000);
    }

    @Test
    void addLongListTestOne() throws ListAccessError {
        populate(longArray);
        linkedList.add(30000, 855000);
        assertEquals(linkedList.get(30000), 855000);
    }

    @Test
    void removeShortListTest() throws ListAccessError {
        populate(shortArray);
        int y = (int) linkedList.get(70);
        System.out.println(linkedList.get(70));
        linkedList.remove(70);
        System.out.println(linkedList.get(70));
        assertNotEquals(linkedList.get(70), y);
    }

    @Test
    void removeShortListMaxIndex() throws ListAccessError {
        populate(shortArray);
        linkedList.remove(199);
        assertThrows(ListAccessError.class,
                ()-> linkedList.get(199),
                "Out of Bounds");
    }

    @Test
    void removeLongListOne() throws ListAccessError {
        populate(longArray);
        int y = (int) linkedList.get(5500);
        linkedList.remove(5500);
        assertNotEquals(linkedList.get(5500), y);
    }

    @Test
    void removeLongListTwo() throws ListAccessError {
        populate(longArray);
        linkedList.remove(99999);
        assertThrows(ListAccessError.class,
                ()-> linkedList.get(99999),
                "Out of Bounds");
    }

    /**
     * Just run this test if the Integer Scope is small but not too small, like 0, 1.
     * Explanation of this test in the log book.
     */
//    @Test
//    void addTestWithWhileLoop() throws ListAccessError {
//        populate(shortArray);
//        int x = 140;
//        int y = shortArray[x];
//        while (linkedList.get(60).equals(y)) {
//            x++;
//        }
//        linkedList.add(60, y);
//        assertEquals(shortArray[x], linkedList.get(60));
//    }
}
