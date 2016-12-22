package mobilesoftware.swproject;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ScheduleDateTest {
    @Test
    public void testDate() {
        scheduleAddProcess schdule = new scheduleAddProcess();
        int input = 20161029;
        assertTrue(schdule.isRightDateForm(input));
    }
}