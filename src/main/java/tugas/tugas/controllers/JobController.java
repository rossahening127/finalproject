/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tugas.tugas.entities.Job;
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.JobRepository;
import tugas.tugas.repositories.ReligionRepository;
import tugas.tugas.services.JobService;
import tugas.tugas.services.ReligionService;

/**
 *
 * @author RossaHening
 */
@Controller
@RequestMapping("/admin")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    @GetMapping("/job")
    public String job(Model model) {
        model.addAttribute("dataJob", jobRepository.getAll());
        return "/dashboard/admin/job";
    }

    
    @PostMapping("/job/addData")
    public String addData(Job job) {
        job.setIsdelete("false");
        jobRepository.save(job);
        return "redirect:dashboard/admin/job";
    }

    @PostMapping("/job/update/{id}")
    public String updateData(@PathVariable("id") String id, Job job) {
        job.setIsdelete("false");
        jobRepository.save(job);

        return "redirect:dashboard/admin/job";
    }

    @GetMapping("/job/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Job job) {
        job.setIsdelete("true");
        jobRepository.save(job);
        return "redirect:dashboard/admin/job";
    }

}
