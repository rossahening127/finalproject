/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tugas.tugas.entities.ConfirmationToken;
import tugas.tugas.entities.Employee;
import tugas.tugas.repositories.AddressRepository;
import tugas.tugas.repositories.ConfirmationTokenRepository;
import tugas.tugas.repositories.DepartmentRepository;
import tugas.tugas.repositories.EmployeeRepository;
import tugas.tugas.repositories.JobRepository;
import tugas.tugas.repositories.ReligionRepository;
import tugas.tugas.services.EmailSenderService;

/**
 *
 * @author RossaHening
 */
@Controller
public class UserAccountController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private JobRepository jobRepository;
    
    @Autowired 
    private ReligionRepository religionRepository;
    
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, Employee employee, Model model) {
        modelAndView.addObject("employee", employee);
        model.addAttribute("dataEmp", employeeRepository.getAll());
        model.addAttribute("dataJob", jobRepository.getAll());
        model.addAttribute("dataDept", departmentRepository.getAll());
        model.addAttribute("dataReli", religionRepository.getAll());
        model.addAttribute("dataAdd", addressRepository.getAll());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, Employee employee, String password) {

        Employee existingUser = employeeRepository.findByemail(employee.getEmail());
        if (existingUser != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("error");
        } else {
//            user.setId(0);
            employee.setIsdelete("true"); 
            employee.setPassword(bCryptPasswordEncoder.encode(password));
            employeeRepository.save(employee);

            ConfirmationToken confirmationToken = new ConfirmationToken(employee);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(employee.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("upnormal.bootcamp@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:1991/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("successRegistration");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken  ) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            Employee employee = employeeRepository.findByemail(token.getEmployeeid().getEmail());
            employee.setIsdelete("false");
            employeeRepository.save(employee);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("resetpassword");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

//      Endpoint to update a user's password
    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public ModelAndView resetUserPassword(ModelAndView modelAndView, Employee employee, String password) {
        if (employee.getEmail() != null) {
            // Use email to find user
            Employee tokenEmp = employeeRepository.findByemail(employee.getEmail());
            tokenEmp.setPassword(bCryptPasswordEncoder.encode(password));
            employeeRepository.save(tokenEmp);
            modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
            modelAndView.setViewName("successReset");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ModelAndView displayResetPassword(ModelAndView modelAndView, Employee employee) {
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("forgotpassword");
        return modelAndView;
    }

    // Receive the address and send an email
    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ModelAndView forgotUserPassword(ModelAndView modelAndView, Employee employee
    ) {
        Employee existingUser = employeeRepository.findByemail(employee.getEmail());
        if (existingUser != null) {
            // Create token
            ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);

            // Save it
            confirmationTokenRepository.save(confirmationToken);

            // Create the email
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(existingUser.getEmail());
            mailMessage.setSubject("Complete Password Reset!");
            mailMessage.setFrom("upnormal.bootcamp@gmail.com");
            mailMessage.setText("To complete the password reset process, please click here: "
                    + "http://localhost:1991/confirm-reset?token=" + confirmationToken.getConfirmationToken());

            // Send the email
            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("successSent");

        } else {
            modelAndView.addObject("message", "This email address does not exist!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
// Endpoint to confirm the token

//    @RequestMapping(value = "/confirm-reset", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
//        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
//
//        if (token != null) {
//            Employee employee = employeeRepository.findByemail(token.getEmployeeid().getEmail());
//            employee.setIsdelete("false");
//            employeeRepository.save(employee);
//            modelAndView.addObject("employee", employee);
//            modelAndView.addObject("email", employee.getEmail());
//            modelAndView.setViewName("resetpassword");
//        } else {
//            modelAndView.addObject("message", "The link is invalid or broken!");
//            modelAndView.setViewName("error");
//        }
//        return modelAndView;
//    }
    
    @RequestMapping(value = "/confirm-reset", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            Employee employee = employeeRepository.findByemail(token.getEmployeeid().getEmail());
            employee.setIsdelete("false");
            employeeRepository.save(employee);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("resetpassword");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error/error");
        }
        return modelAndView;
    }
    

    public EmployeeRepository getEmployeeRepository() {

        return employeeRepository;

    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;

    }

    public ConfirmationTokenRepository getConfirmationTokenRepository() {

        return confirmationTokenRepository;

    }

    public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {

        this.confirmationTokenRepository = confirmationTokenRepository;

    }

    public EmailSenderService getEmailSenderService() {

        return emailSenderService;

    }

    public void setEmailSenderService(EmailSenderService emailSenderService) {

        this.emailSenderService = emailSenderService;

    }
}
