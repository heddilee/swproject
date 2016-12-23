package mobilesoftware.swproject;

import org.junit.Test;

import static android.R.id.input;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class allTest {
    @Test
    public void testUserNewInfoNull() {
       memberChange member=new memberChange();
       String isnull= member.isUserInputNull("","");
        assertEquals("회원정보를 입력해주세요.",isnull);

    }

    @Test
    public void testDBuserInfo() {
        beforeLogin log = new beforeLogin();

        String input = "ThisIsNotId";
        assertFalse(log.idCheck(input));
    }

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
        String numberTest = "010282312347";
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

    @Test
    public void  testisNotNumber() {
        phoneBookAddProcess phonebook = new phoneBookAddProcess();
        String input = "hello";
        assertTrue(phonebook.isNotNumber(input));
    }

}
