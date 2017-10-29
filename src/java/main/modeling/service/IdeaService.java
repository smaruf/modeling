package service;

import model.Comment;
import model.Idea;

import java.util.List;

/**
 * @author maruf
 * @since 10/29/17
 */
public interface IdeaService {
    Idea saveIdea(Idea idea);

    Idea findIdeaByKey(String key);

    List<Idea> findAllIdea();

    Comment saveComment(Idea idea, Comment comment);

    Comment saveReply(Comment comment, Comment reply);
}
