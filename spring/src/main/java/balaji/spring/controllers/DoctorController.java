package balaji.spring.controllers;

import balaji.spring.entities.Doctor;
import balaji.spring.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

}