package linkListTest;

import arrayGenerator.generator.*;
import arrayGenerator.scope.IntegerScope;
import linkedList.list.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author Salvatore Tarantino, u1860830
 * u1860830@hud.ac.uk
 */

public class LinkListIntegerTest {

    /**
     * Test class for the LinkList class.
     */

    IntegerArrayGenerator arrayGenerator = new IntegerArrayGenerator(new IntegerScope(0,1000000));
    Integer[] shortArray = arrayGenerator.getArray(200);
    Integer[] longArray = arrayGenerator.getArray(100000);
    SingleLinkList linkedList = new SingleLinkList();

    /**
     * A method for populate a linked list using an array.
     *
     * @param array the array we want to use.
     * @return the populate linked list.
     * @throws ListAccessError
     */

    public SingleLinkList populate (Integer[] array) throws ListAccessError {
        for (int i = 0; i < array.length; i++) {
            linkedList.add(i, array[i]);
        }
        return linkedList;
    }

    /**
     * The first two tests are just for testing the time taken for access at both the
     */

    @Test
    void accessDataTestArray() throws ListAccessError {
        int value = longArray[100000-1];
    }

    @Test
    void accessDataTestLinkedList() throws ListAccessError {
        populate(longArray);
        int value = (int) linkedList.get(100000-1);
    }

    /**
     * The actual linked list tests.
     */

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
        linkedList.remove(70);
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
    void removeLongListMaxIndex() throws ListAccessError {
        populate(longArray);
        linkedList.remove(99999);
        assertThrows(ListAccessError.class,
                ()-> linkedList.get(99999),
                "Out of Bounds");
    }

    @Test
    void listAccessErrorTest() throws ListAccessError {
        populate(longArray);
        assertThrows(ListAccessError.class,
                ()-> linkedList.get(-1));
    }


//     Just run this test if the Integer Scope is small.
//     This test is not perfect. It can result in a out of list access error if the element x is the last or almost
//     the last element. It work only in one way.
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
