package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {


    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        // insert query
        String query = "insert into student(id, name, city) VALUES (?, ?, ?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());
        return result;
    }

    @Override
    public int change(Student student) {
        //update
        String query = "update student set name=? ,city=? where id=?";
        int result = this.jdbcTemplate.update(query, student.getName(), student.getAddress(), student.getId());
        return result;
    }

    public int delete(int studentId) {
        // Delete
        String query = "delete from student where id=?";
        int result = this.jdbcTemplate.update(query, studentId);
        return result;
    }

    @Override
    public Student getStudent(int studentID) {
        // select single student data
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentID);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        // select all the student details
        String query = "select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
