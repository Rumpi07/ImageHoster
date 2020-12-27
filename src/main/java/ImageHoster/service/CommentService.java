package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentsByImage(Image image) {
        return commentRepository.getAllComments(image);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.createComment(comment);
    }
}
