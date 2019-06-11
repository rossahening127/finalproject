/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tugas.tugas.services.EmailService;

/**
 *
 * @author RossaHening
 */
@Controller
public class ForgetPasswordController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/forget/pass")
    public String index() {
        String result = "forget/password/index";
        return result;
    }

    @GetMapping("/forget/pass/send")
    public String index(String email) throws MessagingException, AddressException, IOException {
        String result = "redirect:/forget/pass?error=true";

        String subjectMessage = "Forget Password";
        String message = "<h1>Maintenace</h1>";
        if(emailService.sendTextMailBoolean(email, subjectMessage, message)){
            result = "/forget/password/success";
        }
        return result;
    }

}

