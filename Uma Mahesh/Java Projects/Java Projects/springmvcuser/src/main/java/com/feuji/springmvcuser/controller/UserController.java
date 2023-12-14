package com.feuji.springmvcuser.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feuji.dao.UserDao;
import com.feuji.dto.User;

@Controller
public class UserController {

	@Autowired
	UserDao dao;

	@RequestMapping("/loaduser")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("insertuser");
		view.addObject("user", new User());
		return view;

	}

	@RequestMapping(value = "/save")
	public ModelAndView save(@ModelAttribute User user) {
//		Department department = new Department();
//		department.setDeptId(1);
//		department.setDeptName("Mech");
//		user.setDepartment(department);
		Serializable serializable = dao.save(user);
		List<User> list = dao.getAllUsers();
		ModelAndView view = new ModelAndView("displayuser");
		view.addObject("getuser", list);
		return view;
	}

	@RequestMapping(value = "/deleteuser")
	public ModelAndView delete(@RequestParam int id) {
		dao.delete(id);
		List<User> list = dao.getAllUsers();
		ModelAndView view = new ModelAndView("displayuser");
		view.addObject("getuser", list);
		return view;
	}

	// edit page
	@RequestMapping(value = "/edituser")
	public ModelAndView edit(@RequestParam int id) {
		User user = dao.findById(id);
		ModelAndView view = new ModelAndView("updateuser");
		view.addObject("update", user);
		return view;
	}

	// update page
	@RequestMapping(value = "/updateuser")
	public ModelAndView update(@ModelAttribute User user) {
		dao.update(user);
		List<User> list = dao.getAllUsers();
		ModelAndView view = new ModelAndView("displayuser");
		view.addObject("getuser", list);
		return view;
	}

	@RequestMapping(value = "/display")
	public ModelAndView getAllUsers() {
		List<User> list = dao.getAllUsers();
		ModelAndView view = new ModelAndView("displayuser");
		view.addObject("getuser", list);

		return view;
	}
}
