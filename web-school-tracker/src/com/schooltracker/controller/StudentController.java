package com.schooltracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schooltracker.entity.Course;
import com.schooltracker.entity.Student;
import com.schooltracker.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudent(Model theModel) {
		
		//get customer from the dao
		List<Student> theStudents = studentService.getStudents();
		
		//add the student to the model
		theModel.addAttribute("students", theStudents);
		
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
		
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "student-form";
		}else {
			studentService.saveStudent(theStudent);
		}
		
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		
		//get student from the service 
		Student theStudent = studentService.getStudent(theId);
		
		//set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		//send over to our form
		return "student-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		//delete the student
		studentService.deleteStudent(theId);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/view")
	public String viewStudent(@RequestParam("studentId") int theId, Model theModel) {
		
		Student theStudent = studentService.getStudent(theId);
		
		theModel.addAttribute("student", theStudent);
		
		return "view-student";
	}
	
	@GetMapping("/listCourse")
	public String addCourse(@RequestParam("studentId") int theId, Model theModel ) {
		
		Student theStudent = studentService.getStudent(theId);
		List<Course> courses = studentService.getCourses();
		
		theModel.addAttribute("student", theStudent);
		
		theModel.addAttribute("course", courses);
		
		return "student-add-course";	

	}
	
	@GetMapping("addCourseToStudent")
	public String addCourseToStudent(@RequestParam("studentId") int studentId, 
			@RequestParam("courseId") int courseId, Model theModel) {
		
		studentService.addCourse(studentId, courseId);
		
		Student student = studentService.getStudent(studentId);
		
		theModel.addAttribute("student", student);
		
		return "view-student";
	}
	
	@GetMapping("removeCourseFromStudent")
	public String removeCourseFromStudent(@RequestParam("studentId") int studentId, 
			@RequestParam("courseId") int courseId, Model theModel) {
		
		studentService.removeCourse(studentId, courseId);
		
		Student theStudent = studentService.getStudent(studentId);
		
		theModel.addAttribute("student", theStudent);
		
		return "view-student";
	}
	
	

}
