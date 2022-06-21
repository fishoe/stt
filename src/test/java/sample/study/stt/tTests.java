package sample.study.stt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import sample.study.stt.Data.Name;
import sample.study.stt.Repository.NameRepo;

@DataJpaTest
public class tTests {
    @Autowired
    NameRepo repo;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    static Name get_sample(){
        return new Name("sample");
    }

    @Test
    @Transactional(value = TxType.NEVER)
    public void b_test(){
        List<Name> dbs = repo.findAll();
        assertEquals(0, dbs.size());
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            Name n_1 = get_sample();
            repo.save(n_1);
            
            Name n_2 = get_sample();
            repo.save(n_2);
            em.getTransaction().commit();
            fail();
        } catch (Exception e) {
            em.getTransaction().rollback();
            dbs = repo.findAll();
            assertEquals(0, dbs.size());
        }
    }
}