package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }

    public List<Comment> getAllComments(Image image) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c from Comment c where c.image =:image", Comment.class).setParameter("image", image);
            return typedQuery.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
