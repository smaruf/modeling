package modeling.service;


import modeling.model.Comment;
import modeling.model.Idea;
import modeling.repository.IdeaFileRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author maruf
 * @since 10/29/17
 */
public class IdeaFileServiceImpl implements IdeaService {
    private static final IdeaService service = new IdeaFileServiceImpl();
    private final IdeaFileRepository repository;

    private IdeaFileServiceImpl() {
        this.repository = IdeaFileRepository.get();
    }

    static IdeaService getService() {
        return service;
    }

    @Override
    public Idea saveIdea(Idea idea) {
        Objects.requireNonNull(idea);
        Objects.requireNonNull(idea.getKey());
        Objects.requireNonNull(idea.getUser());
        Objects.requireNonNull(idea.getText());
        Objects.requireNonNull(idea.getTitle());
        return repository.saveIdea(idea);
    }

    @Override
    public Idea findIdeaByKey(String key) {
        Objects.requireNonNull(key);
        return repository.findIdeaByKey(key);
    }

    @Override
    public List<Idea> findAllIdea() {
        return repository.findAllIdea();
    }

    @Override
    public Comment saveComment(Idea idea, Comment comment) {
        Objects.requireNonNull(idea);
        Objects.requireNonNull(idea.getKey());
        idea = findIdeaByKey(idea.getKey());
        Objects.requireNonNull(idea.getUser());
        Objects.requireNonNull(comment);
        Objects.requireNonNull(comment.getText());
        return repository.saveComment(idea, comment);
    }

    @Override
    public Comment saveReply(Comment comment, Comment reply) {
        Objects.requireNonNull(comment);
        Objects.requireNonNull(comment.getCommentOn());
        Objects.requireNonNull(comment.getCommentOn().getKey());
        if (Objects.isNull(comment.getReplies())) {
            comment.setReplies(new HashSet<>());
        }
        comment.getReplies().add(reply);
        return repository.saveComment(comment.getCommentOn(), comment);
    }
}
