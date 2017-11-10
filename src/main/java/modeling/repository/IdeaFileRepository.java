package modeling.repository;


import modeling.model.Comment;
import modeling.model.Idea;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author maruf
 * @since 10/29/17
 */
public enum IdeaFileRepository {
    STORE;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private List<Idea> ideaList;

    public Idea saveIdea(Idea idea) {
        return null;
    }

    public Idea findIdeaByKey(String key) {
        return null;
    }

    public List<Idea> findAllIdea() {
        return ideaList;
    }

    public Comment saveComment(Idea idea, Comment comment) {
        if (Objects.isNull(idea.getComments())) {
            idea.setComments(new LinkedHashSet<>());
        }
        idea.getComments().add(comment);
        comment.setKey(idea.getKey() + "-comments-" + idea.getComments().size());
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
