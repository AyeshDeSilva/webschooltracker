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
import com.schooltracker.entity.Instructor;
import com.schooltracker.service.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/list")
	public String listInstructor(Model theModel) {
		
		List<Instructor> theInstructors = instructorService.getInstructors();
		
		theModel.addAttribute("instructors", theInstructors);
		
		return "list-instructors";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Instructor theInstructor = new Instructor();
		
		theModel.addAttribute("instructor", theInstructor);
		
		return "instructor-form";
	}
	
	@PostMapping("/saveInstructor")
	public String saveInstructor(@Valid @ModelAttribute("instructor") Instructor theInstructor, BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) {
			return "instructor-form";
		}else {
			instructorService.saveInstructors(theInstructor);
		}
		
		return "redirect:/instructor/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateStudent(@RequestParam("instructorId") int theId, Model theModel) {
		
		Instructor theInstructor = instructorService.getInstructor(theId);
		
		theModel.addAttribute("instructor", theInstructor);
		
		return "instructor-form";
	}
	
	@GetMapping("/delete")
	public String deleteInstructor(@RequestParam("instructorId") int theId) {
		
		instructorService.deleteInstructor(theId);
		
		return "redirect:/instructor/list";
	}
	
	@GetMapping("/view")
	public String viewInstructor(@RequestParam("instructorId") int theId, Model theModel) {
		
		Instructor theInstructor = instructorService.getInstructor(theId);
		
		theModel.addAttribute("instructor", theInstructor);
		
		return "view-instructor";
	}
	
	@GetMapping("/listCourse")
	public String addCourse(@RequestParam("instructorId") int theId, Model theModel) {
		
		Instructor theInstructor = instructorService.getInstructor(theId);
		
		List<Course> courses = instructorService.getCourses();
		
		theModel.addAttribute("instructor", theInstructor);
		
		theModel.addAttribute("course", courses);
		
		return "instructor-add-course";
	}
	
	@GetMapping("/addCourseToInstructor")
	public String addCourseToInstructor(@RequestParam("instructorId") int instructorId, 
			@RequestParam("courseId") int courseId, Model theModel) {
		
		instructorService.addCourse(instructorId, courseId);
		
		Instructor theInstructor = instructorService.getInstructor(instructorId);
		
		theModel.addAttribute("instructor", theInstructor);
		
		return "view-instructor";
		
	}
	
	@GetMapping("/removeCourseToInstructor")
	public String removeCourseToInstructor(@RequestParam("instructorId") int instructorId, 
			@RequestParam("courseId") int courseId, Model theModel) {
		
		instructorService.removeCourse(instructorId, courseId);
		
		Instructor theInstructor = instructorService.getInstructor(instructorId);
		
		theModel.addAttribute("instructor", theInstructor);
		
		return "view-instructor";
		
	}

}
