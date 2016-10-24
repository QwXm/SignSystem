package test;

import config.AppConfig;
import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/10/11.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void testAdd()
    {
        Student student = new Student();
        student.setAddress("天津市西青区津静路26号");
        student.setName("王五");
        student.setAge(23);
        student.setBrithday(new Date());
        studentDao.save(student);
        assertEquals(1,studentDao.count());
    }
    @Test
    public void testGetStudentWithAge()
    {
        testAdd();
        List<Student> students = studentDao.findByAgeBetween(10,30);
        assertEquals(1,students.size());
    }
}
