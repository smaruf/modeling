package modeling.service;

import modeling.model.Comment;
import modeling.model.Idea;
import modeling.repository.IdeaFileRepository;

import java.util.List;

/**
 * @author maruf
 * @since 10/29/17
 */
public class IdeaFileServiceImpl implements IdeaService {
    private static final IdeaService service = new IdeaFileServiceImpl();
    private final IdeaFileRepository repository;

    private IdeaFileServiceImpl() {
        this.repository = IdeaFileRepository.STORE;
    }

    public static IdeaService getSerevice() {
        return service;
    }

    @Override
    public Idea saveIdea(Idea idea) {
        return null;
    }

    @Override
    public Idea findIdeaByKey(String key) {
        return null;
    }

    @Override
    public List<Idea> findAllIdea() {
        return null;
    }

    @Override
    public Comment saveComment(Idea idea, Comment comment) {
        return null;
    }

    @Override
    public Comment saveReply(Comment comment, Comment reply) {
        return null;
    }
}
