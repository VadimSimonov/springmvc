package spring.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import spring.Model.Employee;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class DataDaoImpl implements DataDao {
    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public int insertRow(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        session.close();
        return (Integer) id;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getList() {
        Session session = sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        session.close();
        return employeeList;
    }


    public Employee getRowById(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = (Employee) session.load(Employee.class, id);
        return employee;
    }


    public int updateRow(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        session.close();
        return (Integer) id;
    }


    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, id);
        session.delete(employee);
        tx.commit();
        Serializable ids = session.getIdentifier(employee);
        session.close();
        return (Integer) ids;
    }
}
