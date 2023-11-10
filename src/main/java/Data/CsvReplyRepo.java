package Data;
import Entity.Reply;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CsvReplyRepo implements ReplyRepo {
    private Path csvFilePath;

    public CsvReplyRepo(String csvFilePath) {
        this.csvFilePath = Paths.get(csvFilePath);
        try {
            if (Files.notExists(this.csvFilePath)) {
                Files.createFile(this.csvFilePath);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the CSV file: " + e.getMessage());
        }
    }

    @Override
    public void save(Reply reply) {
        String line = String.format("%s,%s,%s\n", reply.getId(), reply.getPostId(), reply.getMessage());
        try (BufferedWriter writer = Files.newBufferedWriter(csvFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(line);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the CSV file: " + e.getMessage());
        }
    }

    @Override
    public List<Reply> getRepliesForPost(String postId) {
        List<Reply> replies = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 3) {
                    String id = parts[0].trim();
                    String postID = parts[1].trim();
                    String message = parts[2].trim();
                    if (postID.equals(postId)) {
                        replies.add(new Reply(id, postID, message));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the CSV file: " + e.getMessage());
        }
        return replies;
    }
}
