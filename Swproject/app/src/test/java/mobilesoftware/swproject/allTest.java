package mobilesoftware.swproject;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class allTest {
    @Test
    public void testNoteContent() {
        noteAddProcess note = new noteAddProcess();
        String input = "hello world";
        assertFalse(note.isContentNull(input));
    }

    @Test
    public void testNoteContentLength() {
        noteAddProcess note = new noteAddProcess();
        String input = "Nice to meet you";
        assertFalse(note.CheckMaxLength(input));
    }

    @Test
    public void testWriteCheck() {
        String nameTest = "KimShinYangLee";
        String numberTest = "010282312347899";
        phoneBookAddProcess phonebook = new phoneBookAddProcess();

        assertFalse(phonebook.isBothNullTest(numberTest, nameTest));
    }

    @Test
    public void testDate() {
        scheduleAddProcess schdule = new scheduleAddProcess();
        int input = 20161029;
        assertTrue(schdule.isRightDateForm(input));
    }

    @Test
    public void  testEmptyEditTextCheck() {
        scheduleAdd schedule = new scheduleAdd();
        String input = "hello";
        assertTrue(schedule.emptyEditTextCheck(input));
    }
}
