package balaji.spring.controllers;

import balaji.spring.entities.Dean;
import balaji.spring.services.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deans")
public class DeanController {

    @Autowired
    private DeanService deanService;

    @GetMapping("/{id}")
    public Dean getDeanById(@PathVariable Integer id) {
        return deanService.getDeanById(id);
    }

}
