package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController//(agr rest controller hoga to controller or response body ni bhejte)
//@Controller
@RequestMapping("/app")
public class DataController {
//	@ResponseBody
	@Autowired
	StudentService studentService;
	@RequestMapping("/data")
	public String getdata()
	{
		return "this is response from rest API";
	}
	@GetMapping("/") // for getting all students
	public List<Student> getall()
	{
		return studentService.getAll();
	}
	@GetMapping("/{id}") // for getting single students data
	public Student get(@PathVariable("id") int id)
	{
		return studentService.get(id);
	}
	@DeleteMapping("/{id}") // for delete one student recored
	public String del(@PathVariable("id") int id)
	{
		studentService.delete(id);
		return "delete successfully";
	}
	@PostMapping // for save(insert) students data
	public Student save(@RequestBody Student s)
	{
		return studentService.save(s);
	}
	@PutMapping("/") // for update students data
	public Student update(@RequestBody Student s)
	{
		return studentService.update(s);
	}
}
