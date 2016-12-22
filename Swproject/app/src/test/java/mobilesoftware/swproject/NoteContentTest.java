package mobilesoftware.swproject;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class NoteContentTest {
    @Test
    public void testNoteContent() {
        noteAddProcess note = new noteAddProcess();
        String input = "hello world";
        assertFalse(note.isContentNull(input));
    }
}