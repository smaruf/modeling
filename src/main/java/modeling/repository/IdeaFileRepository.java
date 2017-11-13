package modeling.repository;


import modeling.model.Comment;
import modeling.model.Idea;

import java.io.*;
import java.util.*;

/**
 * @author maruf
 * @since 10/29/17
 */
public enum IdeaFileRepository {
    STORE;
    private static final String filePath = "data-store/";
    private static final String fileName = "key-values";
    private static LinkedHashMap<String, Idea> keyValues;
    private static FileInputStream inputStream;
    private static FileOutputStream outputStream;

    public static IdeaFileRepository get() {
        initKeyValue();
        return STORE;
    }

    private static void initKeyValue() {
        try {
            File file = new File(filePath);
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            inputStream = new FileInputStream(new File(filePath + fileName));
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            //noinspection unchecked
            keyValues = (LinkedHashMap<String, Idea>) stream.readObject();
            stream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(keyValues)) {
            keyValues = new LinkedHashMap<>();
        }
    }

    public Idea saveIdea(Idea idea) {
        keyValues.put(idea.getKey(), idea);
        saveKeyValues();
        return idea;
    }

    private void saveKeyValues() {
        if (Objects.nonNull(keyValues)) {
            try {
                outputStream = new FileOutputStream(new File(filePath + fileName));
                ObjectOutputStream stream = new ObjectOutputStream(outputStream);
                stream.writeObject(keyValues);
                stream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Idea findIdeaByKey(String key) {
        return keyValues.get(key);
    }

    public List<Idea> findAllIdea() {
        return new ArrayList<>(keyValues.values());
    }

    public Comment saveComment(Idea idea, Comment comment) {
        if (Objects.isNull(idea.getComments())) {
            idea.setComments(new LinkedHashSet<>());
        }
        idea.getComments().add(comment);
        saveIdea(idea);
        return getComment(idea.getComments(), comment.getKey());
    }

    private Comment getComment(Set<Comment> comments, String key) {
        for (Comment comment : comments) {
            if (comment.getKey().equalsIgnoreCase(key)) {
                return comment;
            }
        }
        return null;
    }
}
