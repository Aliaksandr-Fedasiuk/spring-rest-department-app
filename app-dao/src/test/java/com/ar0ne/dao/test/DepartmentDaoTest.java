package com.ar0ne.dao.test;

import static org.junit.Assert.*;

import com.ar0ne.dao.DepartmentDao;
import com.ar0ne.model.Department;
import com.ar0ne.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-dao-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    private final static String DEPT_NAME = "Test dept.";
    private final static int DEPT_INIT_SIZE = 4;

    private Department createAndAddToDataBaseDepartment() {

        Department department = new Department(DEPT_NAME, 1L);

        long id = departmentDao.addDepartment(department);
        department.setId(id);

        return department;
    }

    @Test
    public void getAllDepartments() {
        List<Department> departments = departmentDao.getAllDepartments();
        assertEquals(DEPT_INIT_SIZE, departments.size());

        departmentDao.removeDepartment(1L);
        assertEquals(DEPT_INIT_SIZE - 1, departmentDao.getAllDepartments().size());
    }

    @Test
    public void addDepartment() {

        int size_before = departmentDao.getAllDepartments().size();

        Department department = createAndAddToDataBaseDepartment();

        assertNotNull(department);

        int size_after  = departmentDao.getAllDepartments().size();

        assertEquals(size_before + 1, size_after);
        assertEquals(DEPT_INIT_SIZE, size_before);
    }

    @Test
    public void getDepartmentById() {

        Department department = createAndAddToDataBaseDepartment();

        Department ret_department = departmentDao.getDepartmentById(department.getId());

        assertNotNull(ret_department);
        assertEquals(department, ret_department);
    }

    @Test
    public void getDepartmentByName(){

        Department department = createAndAddToDataBaseDepartment();

        Department ret_department = departmentDao.getDepartmentByName(DEPT_NAME);
        assertEquals(department, ret_department);
    }

    @Test
    public void removeDepartment() {

        Department department = createAndAddToDataBaseDepartment();

        int size_before = departmentDao.getAllDepartments().size();

        departmentDao.removeDepartment(department.getId());

        int size_after = departmentDao.getAllDepartments().size();

        assertEquals(size_before - 1, size_after);

        department = departmentDao.getDepartmentById(department.getId());

        assertNull(department);

    }

    @Test
    public void updateDepartment() {

        String new_name = "Other name";

        Department department = createAndAddToDataBaseDepartment();

        department.setName(new_name);

        departmentDao.updateDepartment(department);

        Department ret_department = departmentDao.getDepartmentById(department.getId());

        assertEquals(ret_department.getName(), new_name);

    }

}
