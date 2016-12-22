package mobilesoftware.swproject;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class phoneBookNullTest {
    @Test
    public void testWriteCheck() {
        String nameTest = "KimShinYangLee";
        String numberTest = "01028231234";
        phoneBookAddProcess phonebook = new phoneBookAddProcess();

        assertFalse(phonebook.isBothNullTest(numberTest, nameTest));
    }
}