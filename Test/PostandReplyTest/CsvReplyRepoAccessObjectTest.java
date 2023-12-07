package PostandReplyTest;

import Data.PostandReply.CsvReplyRepoAccessObject;
import Entity.PostandReply.Reply;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class CsvReplyRepoAccessObjectTest {

    private static final String TEST_CSV_FILE = "testReplies.csv";
    private CsvReplyRepoAccessObject csvReplyRepo;

    @BeforeEach
    public void setUp() {
        csvReplyRepo = new CsvReplyRepoAccessObject(TEST_CSV_FILE);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }

    @Test
    public void testSaveAndRetrieveReplies() throws IOException {
        // Create a new reply and save it
        Reply testReply = new Reply("1", "post1", "Test message");
        csvReplyRepo.save(testReply);

        // Retrieve replies for "post1" and verify the result
        List<Reply> retrievedReplies = csvReplyRepo.getRepliesForPost("post1");
        assertEquals(1, retrievedReplies.size(), "There should be one reply for post1");

        Reply retrievedReply = retrievedReplies.get(0);
        assertEquals("1", retrievedReply.getId(), "Reply ID should match");
        assertEquals("post1", retrievedReply.getPostId(), "Post ID should match");
        assertEquals("Test message", retrievedReply.getMessage(), "Reply message should match");
    }
}
