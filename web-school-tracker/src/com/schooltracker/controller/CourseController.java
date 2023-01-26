package com.schooltracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schooltracker.entity.Course;
import com.schooltracker.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		List<Course> courses = courseService.getCourses();
		
		theModel.addAttribute("courses", courses);
		
		return "list-courses";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Course course = new Course();
		
		theModel.addAttribute("course", course);
		
		return "course-form";
	}
	
	@PostMapping("/saveCourse")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {
		
		courseService.saveCourse(theCourse);
		
		return "redirect:/course/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId, Model theModel) {
		
		Course theCourse = courseService.getCourse(theId);
		
		theModel.addAttribute("course", theCourse);
		
		return "course-form";
	}
	
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam("courseId") int theId) {
		
		courseService.deleteCourse(theId);
		
		return "redirect:/course/list";
	}

}
