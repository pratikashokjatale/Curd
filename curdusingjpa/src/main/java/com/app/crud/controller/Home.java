package com.app.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.Dao.StudentDao;
import com.app.crud.model.Student;

@RestController
//@CrossOrigin("http://localhost:5173/")
public class Home {

	@Autowired
	private StudentDao dao;
	
	@PostMapping("/insert")
	public String addStudent(@RequestBody Student stu) {
		dao.save(stu);
		return "student save successfully";
	}
	
	@GetMapping("/viewall")
	public List<Student> getdata(){
		
		return dao.getall();
	}
	
	@GetMapping("/viewbyid/{id}")
	public Optional<Student> getdata(@PathVariable int id){
		
		return dao.getbyid(id);
	}
	
	@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable int id) {
		dao.deletestudent(id);
		return "delete student";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id,@RequestBody Student s) {
	dao.updatestudent(id,s);
	return "updtate student";
}

}
