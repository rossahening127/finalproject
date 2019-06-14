/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tugas.tugas.entities.AuthUser;
import tugas.tugas.entities.Department;
import tugas.tugas.entities.Employee;
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.AuthUserRepository;
import tugas.tugas.repositories.ReligionRepository;
import tugas.tugas.services.ReligionService;

/**
 *
 * @author RossaHening
 */
@Controller
public class MainController {

    @Autowired
    private AuthUserRepository authUserRepository;
    
    @RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "index";
    }


    @GetMapping("/403")
    public String Error() {
        return "error/403";
    }
//    @GetMapping("/forgot")
//    public String Forgot() {
//        return "registration";
//    }
    
//    @GetMapping("/addRoleData")
//    public String addRoleData(Model model) {
//        model.addAttribute("dataRole", authUserRepository.getAll());
//        return "addRole";
//    }

//@PostMapping("/addrole")
//    public  String addRole( AuthUser authUser) {
//        authUser.setIsdelete("false");
//        authUserRepository.save(authUser);
//        return "addRole";
//    }    
    
//    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
//    public ModelAndView addRoleLagi(ModelAndView modelAndView, AuthUser authUser) {
////        modelAndView.addObject("authUser", authUser);
//        authUser.setIsdelete("false");
//        authUserRepository.save(authUser);
//        modelAndView.setViewName("addRole");
//        return modelAndView;
//    }
//    
//    @GetMapping("/add")
//    public ModelAndView add() {
//        ModelAndView modelAndView = new ModelAndView("addRole");
//        
//        modelAndView.addObject("authUser", authUser);
//        return modelAndView; b  
//    }
//   
//    @PostMapping("/department/addData")
//    public String addData(Department department) {
//        department.setIsdelete("false");
//        departmentRepository.save(department);
//        return "redirect:/department";
//    }
    
    
    
    @RequestMapping(value = "/error", method = RequestMethod.GET) 
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/500";
            }
        }
        return "error/error";
    }
//     @GetMapping("/user")
//    public String user() {
//        return "";
//    }
}
