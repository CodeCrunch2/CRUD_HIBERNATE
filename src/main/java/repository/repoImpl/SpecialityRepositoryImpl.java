package repository.repoImpl;

import model.Specialty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.SpecialityRepository;
import repository.hibernateUtil.HibernateUtil;
import java.util.List;

public class SpecialityRepositoryImpl implements SpecialityRepository {

    @Override
    public void save(Specialty specialty) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(specialty);
        transaction.commit();
        session.close();

    }

    @Override
    public void delete(Specialty specialty) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(specialty);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Specialty specialty) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(specialty);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialtyList;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        specialtyList = session.createQuery("from Specialty ").list();
        transaction.commit();
        session.close();
        return specialtyList;
    }

    @Override
    public Specialty getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Specialty specialty = session.get(Specialty.class, id);
        transaction.commit();
        session.close();
        return specialty;
    }
}
