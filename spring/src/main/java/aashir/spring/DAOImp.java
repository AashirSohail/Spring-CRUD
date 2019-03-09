package aashir.spring;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * DAO class
 * Repository
 * Contains getter and setter for session factory
 */

@Repository
public class DAOImp {

    @Autowired
    private SessionFactory sessionFactory;


    //Getter method for session factory
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //Setter method for session factory
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /*
     * Method
     * returns the number of records
     * returns a list of persons in the database
     * each index of the list is a person object mapped to a row of DB
     */
    public List<person> getAllPersons() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        @SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(person.class);
        @SuppressWarnings("unchecked")
		List<person> Persons = (List<person>) criteria.list();
        session.getTransaction().commit();
        //System.out.println(Persons.size());
        return Persons;
    }


    //Method that adds a record to the database
    public void register(person per){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(per);
        session.getTransaction().commit();
        System.out.println("Record added successfully!");
        session.close();
    }


    //method that gets a record from the database
    public person retrieve(int id){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        person per = session.get(person.class, id);
        session.getTransaction().commit();
        session.close();
        return per;
    }


    //method that deletes a record from a database
    public void delete(int id){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        person per = session.get(person.class, id);
        if(per != null) {
            String hql="delete from person where id="+id;
            @SuppressWarnings("rawtypes")
			Query query=session.createQuery(hql);
            query.executeUpdate();
            System.out.println("Record deleted from database!");
        } else {
            System.out.println("No record exists of the given person!");
        }
        session.getTransaction().commit();
        session.close();

    }


    //method that deletes a row from the database
    public void update(person per){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(per);
        session.getTransaction().commit();
        System.out.println("Record updated sucessfuly in database!");

    }


}