package mobilesoftware.swproject;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class NoteLengthTest {
    @Test
    public void testNoteContentLength() {
        noteAddProcess note = new noteAddProcess();
        String input = "Nice to meet you";
        assertFalse(note.CheckMaxLength(input));
    }
}