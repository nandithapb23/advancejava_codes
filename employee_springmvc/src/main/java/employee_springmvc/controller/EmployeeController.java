package employee_springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employee_springmvc.dao.Employeedao;
import employee_springmvc.dto.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private Employeedao employeedao;
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView andView=new ModelAndView();
		andView.addObject("employee", new Employee());
		andView.setViewName("register.jsp");
		return andView;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute Employee employee) {
		ModelAndView andView=new ModelAndView();
		employeedao.saveEmployee(employee);
		List<Employee> list=employeedao.getallemployee();
		andView.addObject("employee", list);
		andView.setViewName("display.jsp");
		return andView;
		
	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		boolean b=employeedao.deleteemployee(id);
		if(b) {
			List<Employee> list=employeedao.getallemployee();
			andView.addObject("employee", list);
			andView.setViewName("display.jsp");
		}else {
			andView.setViewName("home.jsp");
		}
		return andView;
		
	}
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		Employee employee=employeedao.getemployeebyid(id);
		andView.addObject(employee);
		andView.setViewName("edit.jsp");
		return andView;
		
	}
	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute Employee employee) {
		ModelAndView andView=new ModelAndView();
		employeedao.updatEmployee(employee);
		List<Employee> list=employeedao.getallemployee();
		andView.addObject("employee", list);
		andView.setViewName("display.jsp");
		return andView;
		
	}
}
