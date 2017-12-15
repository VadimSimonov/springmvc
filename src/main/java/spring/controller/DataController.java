package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import spring.Model.Employee;
import spring.Service.DataService;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping("/form")
    public ModelAndView getForm(@ModelAttribute Employee employee) {
        return new ModelAndView("form");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute Employee employee) {
        dataService.insertRow(employee);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getList() {
        List employeeList = dataService.getList();
        return new ModelAndView("list", "employeeList", employeeList);
    }

    @RequestMapping("/delete")
    public ModelAndView deleteUser(@RequestParam int id) {
        dataService.deleteRow(id);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("/edit")
    public ModelAndView editUser(@RequestParam int id,
                                 @ModelAttribute Employee employee) {
        Employee employeeObject = dataService.getRowById(id);
        return new ModelAndView("edit", "employeeObject", employeeObject);
    }

    @RequestMapping("/update")
    public ModelAndView updateUser(@ModelAttribute Employee employee) {
        dataService.updateRow(employee);
        return new ModelAndView("redirect:list");
    }
}
