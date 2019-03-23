import data.Lecturers;

import javax.persistence.*;
import java.util.List;

public class Test {
    @PersistenceContext
    EntityManager em;

    EntityTransaction tx;

    EntityManagerFactory emf;
    public void init(){
        Lecturers lec = new Lecturers("Patricia", 18);
        tx.begin();
        em.persist(lec);
        tx.commit();
        Cache cache = emf.getCache();

    }

    public void test(){
        TypedQuery query = em.createQuery("SELECT name FROM Lecturers",Lecturers.class);
        List<Lecturers> list = query.getResultList();

        for(Lecturers l:list){
            System.out.println(l.getLecturer());
        }
        Query namedq = em.createNamedQuery("findAll");
    }
    public void paramQuery(){
        Query query = em.createNamedQuery("findWithParam");
        query.setParameter("lecturer", "Patricia");
        query.setMaxResults(3);
        List<Lecturers> lecturers = query.getResultList();
        for(Lecturers l:lecturers){
            System.out.println(l.toString());
        }
    }
}
