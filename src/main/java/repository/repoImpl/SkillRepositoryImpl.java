package repository.repoImpl;

import model.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.SkillRepository;
import repository.hibernateUtil.HibernateUtil;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {


    @Override
    public void save(Skill skill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();

    }

    @Override
    public void delete(Skill skill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(skill);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Skill skill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skill);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillList;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        skillList = session.createQuery("from Skill").list();
        transaction.commit();
        session.close();
        return skillList;

    }

    @Override
    public Skill getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Skill skill = session.get(Skill.class, id);
        transaction.commit();
        session.close();
        return skill;
    }
}
