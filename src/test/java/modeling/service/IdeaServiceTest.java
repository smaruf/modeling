package modeling.service;

import modeling.model.Comment;
import modeling.model.Idea;
import modeling.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author maruf
 * @since 10/29/17
 */
public class IdeaServiceTest {
    private IdeaService service = IdeaFileServiceImpl.getService();

    @Test
    public void saveIdea() throws Exception {
        User user = User.builder().key("first-user").build();
        Idea idea = service.saveIdea(Idea.builder().key("first-idea").user(user).title("Title").text("this is first idea").build());
        Assert.assertNotNull(idea);
    }

    @Test
    public void findIdeaByKey() throws Exception {
        User user = User.builder().key("second-user").build();
        service.saveIdea(Idea.builder().key("first-idea").user(user).title("Title").text("this is first idea").build());
        service.saveIdea(Idea.builder().key("second-idea").user(user).title("Title").text("this is second idea").build());
        service.saveIdea(Idea.builder().key("third-idea").user(user).title("Title").text("this is third idea").build());
        service.saveIdea(Idea.builder().key("forth-idea").user(user).title("Title").text("this is forth idea").build());
        Idea idea = service.findIdeaByKey("third-idea");
        Assert.assertNotNull(idea);
        Idea idea2 = service.findIdeaByKey("third-idea2");
        Assert.assertNull(idea2);

    }

    @Test
    public void findAllIdea() throws Exception {
        User user = User.builder().key("third-user").build();
        service.saveIdea(Idea.builder().key("first-idea1").user(user).title("Title").text("this is first idea").build());
        service.saveIdea(Idea.builder().key("second-idea2").user(user).title("Title").text("this is second idea").build());
        service.saveIdea(Idea.builder().key("third-idea3").user(user).title("Title").text("this is third idea").build());
        service.saveIdea(Idea.builder().key("forth-idea4").user(user).title("Title").text("this is forth idea").build());
        List<Idea> ideas = service.findAllIdea();
        Assert.assertNotNull(ideas);
        Assert.assertNotEquals(0, ideas.size());
    }

    @Test
    public void saveComment() throws Exception {
        User user = User.builder().key("forth-user").build();
        service.saveIdea(Idea.builder().key("first-idea11").user(user).title("Title").text("this is first idea").build());
        service.saveIdea(Idea.builder().key("second-idea12").user(user).title("Title").text("this is second idea").build());
        service.saveIdea(Idea.builder().key("third-idea13").user(user).title("Title").text("this is third idea").build());
        service.saveIdea(Idea.builder().key("forth-idea14").user(user).title("Title").text("this is forth idea").build());
        Idea idea = service.findIdeaByKey("second-idea12");
        Assert.assertNotNull(idea);
        Comment comment = service.saveComment(idea, Comment.builder().user(user).commentOn(idea).text("first comment on idea").build());
        Comment comment2 = service.saveComment(idea, Comment.builder().user(user).commentOn(idea).text("second comment on idea").build());
        Assert.assertNotNull(comment);
        Assert.assertNotNull(comment2);

    }

    @Test
    public void saveReply() throws Exception {
        User user = User.builder().key("fifth-user").build();
        User user2 = User.builder().key("sixth-user").build();
        service.saveIdea(Idea.builder().key("first-idea21").user(user).title("Title").text("this is first idea").build());
        service.saveIdea(Idea.builder().key("second-idea22").user(user).title("Title").text("this is second idea").build());
        service.saveIdea(Idea.builder().key("third-idea23").user(user2).title("Title").text("this is third idea").build());
        service.saveIdea(Idea.builder().key("forth-idea24").user(user).title("Title").text("this is forth idea").build());
        Idea idea = service.findIdeaByKey("second-idea22");
        Assert.assertNotNull(idea);
        Comment comment = service.saveComment(idea, Comment.builder().user(user2).commentOn(idea).text("first comment on idea").build());
        Comment comment2 = service.saveComment(idea, Comment.builder().user(user).commentOn(idea).text("second comment on idea").build());
        Assert.assertNotNull(comment);
        Assert.assertNotNull(comment2);
        Comment replyOn = service.saveReply(comment, Comment.builder().user(user2).commentOn(idea).text("first comment on idea").build());
        Assert.assertNotNull(replyOn);
        Assert.assertNotEquals(0, replyOn.getReplies().size());
    }

}