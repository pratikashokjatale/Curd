package com.app.crud.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.DaoImpl.StudentDaoImpl;
import com.app.crud.model.Student;



@Service
public class StudentDao {
	@Autowired
	private StudentDaoImpl si;
	
public void save(Student stu) {
	si.save(stu);
}

public List<Student> getall() {
		
	return si.findAll();
	
}

public Optional<Student> getbyid(int id) {
	// TODO Auto-generated method stub
	return si.findById(id);
}

public void deletestudent(int id) {
	// TODO Auto-generated method stub
	si.deleteById(id);
	
}

public void updatestudent(int id, Student s) {
	// TODO Auto-generated method stub
	Optional<Student>stt=si.findById(id);
	if(stt.isPresent()){
		Student ss=stt.get();
		si.save(s);
	}
	
	
}


}
