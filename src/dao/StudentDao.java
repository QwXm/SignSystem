package dao;

import entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    Student findByName(String name);
    List<Student> findByAgeBetween(int min,int max);
}
