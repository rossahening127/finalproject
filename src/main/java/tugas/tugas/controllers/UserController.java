/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author RossaHening
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping(value = {"", "/","/dashboard"}, method = RequestMethod.GET)
    public String user(){
        return "dashboard/user/index";
    }
    
    
    
//    @GetMapping("/admin/layout")
//    public String layout(){
//        return "dashboard/admin/layout";
//    }
    
}

