package linkListTest;

import arrayGenerator.generator.ArrayGenerator;
import arrayGenerator.generator.IntegerArrayGenerator;
import linkedList.list.ListAccessError;
import linkedList.list.SingleLinkList;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class LinkListTest<T extends Comparable<? super T>> {

    SingleLinkList linkList = new SingleLinkList();

    public SingleLinkList pop (T[] array) throws ListAccessError {
        for (int i = 0; i < array.length; i++) {
            linkList.add(i, array[i]);
        }
        return linkList;
    }

    @Test
    void positiveTestOne() throws ListAccessError {
        //assertEquals(array[1], linkedList.get(1));
    }
}
