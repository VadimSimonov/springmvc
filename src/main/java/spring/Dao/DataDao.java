package spring.Dao;

import spring.Model.Employee;

import java.util.List;

public interface DataDao {

    public int insertOrUpdateRow(Employee employee);

    public List<Employee> getList();

    public Employee getRowById(int id);

    public int deleteRow(int id);
}
