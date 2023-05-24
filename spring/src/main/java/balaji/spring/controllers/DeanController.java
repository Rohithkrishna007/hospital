package balaji.spring.controllers;

import balaji.spring.entities.Dean;
import balaji.spring.services.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deans")
public class DeanController {

    @Autowired
    private DeanService deanService;

    @GetMapping("/{id}")
    public Dean getDeanById(@PathVariable Integer id) {
        return deanService.getDeanById(id);
    }


    @GetMapping("/dean/sorted-order")
    public List<Dean> getAllDeansSortedById(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "asc") String sortOrder) {

        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "deanId"));

        return deanService.getAllDeansSortedById(pageable).getContent();
    }

}
