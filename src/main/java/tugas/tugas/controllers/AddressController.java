/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tugas.tugas.entities.Address;
import tugas.tugas.entities.Job;
import tugas.tugas.repositories.AddressRepository;
import tugas.tugas.repositories.JobRepository;
import tugas.tugas.repositories.SubdistrictRepository;
import tugas.tugas.services.AddressService;
import tugas.tugas.services.JobService;

/**
 *
 * @author RossaHening
 */

@Controller
@RequestMapping("/admin")
public class AddressController {
     @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;
    
    @Autowired
    private SubdistrictRepository subdistrictRepository;

    @GetMapping("/address")
    public String address(Model model) {
        model.addAttribute("dataAdd", addressRepository.getAll());
         model.addAttribute("dataSub", subdistrictRepository.getAll());
        return "dashboard/admin/address";
    }

    
    @PostMapping("/address/addData")
    public String addData(Address address) {
        address.setIsdelete("false");
        addressRepository.save(address);
        return "redirect:dashboard/admin/address";
    }

    @PostMapping("/address/update/{id}")
    public String updateData(@PathVariable("id") String id, Address address) {
        address.setIsdelete("false");
        addressRepository.save(address);

        return "redirect:dashboard/admin/address";
    }

    @GetMapping("/address/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Address address) {
        address.setIsdelete("true");
        addressRepository.save(address);
        return "redirect:dashboard/admin/address";
    }

}
