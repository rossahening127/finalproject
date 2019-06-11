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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tugas.tugas.services.EmailService;

/**
 *
 * @author RossaHening
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/send/{emailTo}")
    public String sendEmail(@PathVariable String emailTo) throws MessagingException, AddressException, IOException {
        String sm = "Forget Password";
        String m = "Please Contact Our Admin";
        emailService.sendTextMail(emailTo, sm, m);
        return "Email sent successfully";
    }

}
