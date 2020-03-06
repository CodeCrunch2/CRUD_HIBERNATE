package repository.repoImpl;

import model.Developer;
import model.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.DeveloperRepository;

import repository.hibernateUtil.HibernateUtil;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public void save(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(developer);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(developer);
        transaction.commit();
        session.close();
    }



    @Override
    public boolean haveSkill(int developerId, int skillId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, developerId);
        Skill skill = session.get(Skill.class, skillId);
        transaction.commit();
        session.close();
        for (Skill s: developer.getSkills()) {
            if (s.getId() == skill.getId()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Developer> getAll() {
        List<Developer> developerList;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        developerList = session.createQuery("from Developer ").list();
        transaction.commit();
        session.close();
        return developerList;
    }

    @Override
    public Developer getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        transaction.commit();
        session.close();
        return developer;
    }


}
