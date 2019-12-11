package linkListTest;

import arrayGenerator.generator.CharacterArrayGenerator;
import arrayGenerator.scope.CharacterScope;
import linkedList.list.ListAccessError;
import linkedList.list.SingleLinkList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author Salvatore Tarantino, u1860830
 * u1860830@hud.ac.uk
 */

public class LinkListCharacterTest {

    /**
     * Test class for the LinkList class.
     */

    CharacterArrayGenerator arrayGenerator = new CharacterArrayGenerator(new CharacterScope());
    Character[] shortArray = arrayGenerator.getArray(200);
    Character[] longArray = arrayGenerator.getArray(100000);
    SingleLinkList linkedList = new SingleLinkList();

    /**
     * A method for populate a linked list using an array.
     *
     * @param array the array we want to use.
     * @return the populate linked list.
     * @throws ListAccessError
     */

    public SingleLinkList populate (Character[] array) throws ListAccessError {
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
        linkedList.add(1, "b");
        assertEquals(linkedList.get(1), "b");
    }

    @Test
    void addShortListTestTwo() throws ListAccessError {
        populate(shortArray);
        linkedList.add(199, "g");
        assertEquals(linkedList.get(199), "g");
    }

    @Test
    void addLongListTestOne() throws ListAccessError {
        populate(longArray);
        linkedList.add(30000, "z");
        assertEquals(linkedList.get(30000), "z");
    }

    @Test
    void removeShortListTest() throws ListAccessError {
        populate(shortArray);
        Character y = (Character) linkedList.get(70);
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
        Character y = (Character) linkedList.get(5500);
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
}
