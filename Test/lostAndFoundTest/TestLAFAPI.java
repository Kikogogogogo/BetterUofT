package lostAndFoundTest;

import API.LAFAutoCorrect;
import org.junit.jupiter.api.Test;

public class TestLAFAPI {
    @Test
    public void TestApi() {
        LAFAutoCorrect lafAutoCorrect = new LAFAutoCorrect();
        lafAutoCorrect.getCorrectedText("Test text");
    }
}
