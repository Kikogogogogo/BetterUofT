package PostandReplyTest;

import Data.PostandReply.CsvPostRepoAccessObject;
import Entity.PostandReply.Post;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.util.List;

class CsvPostRepoAccessObjectTest {

    private static final String TEST_CSV_FILE = "testPosts.csv";
    private CsvPostRepoAccessObject csvPostRepo;

    @BeforeEach
    public void setUp() {
        csvPostRepo = new CsvPostRepoAccessObject(TEST_CSV_FILE);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }

    @Test
    void testSaveAndRetrievePosts() {
        Post testPost = new Post("1", "Test message");
        csvPostRepo.save(testPost);

        List<Post> retrievedPosts = csvPostRepo.getAllPosts();
        assertFalse(retrievedPosts.isEmpty(), "The list of posts should not be empty");
        assertEquals(1, retrievedPosts.size(), "There should be one post in the file");
        Post retrievedPost = retrievedPosts.get(0);
        assertEquals("1", retrievedPost.getId(), "Post ID should match");
        assertEquals("Test message", retrievedPost.getMessage(), "Post message should match");
    }
}
