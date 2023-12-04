package Data.PostandReply;

import Entity.Post;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.nio.file.*;

public class CsvPostRepoAccessObject implements PostRepoAccess {
    private Path csvFilePath;

    public CsvPostRepoAccessObject(String csvFilePath) {
        this.csvFilePath = Paths.get(csvFilePath);
    }

    @Override
    public void save(Post post) {
        String line = String.format("%s,%s\n", post.getId(), post.getMessage());
        try (BufferedWriter writer = Files.newBufferedWriter(csvFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        if (!Files.exists(csvFilePath)) {
            return posts;
        }

        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 2) {
                    String id = parts[0];
                    String message = parts[1];
                    posts.add(new Post(id, message));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }
}
