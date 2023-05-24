package balaji.spring.controllers;

import balaji.spring.entities.Dean;
import balaji.spring.entities.Doctor;
import balaji.spring.entities.Patient;
import balaji.spring.repositories.DoctorRepository;
import balaji.spring.repositories.PatientRepository;
import balaji.spring.services.DoctorService;
import balaji.spring.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService patientService;
    private DoctorService doctorService;

    private DoctorRepository doctorRepository;

    public PatientController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Map<String, Object>> getPatientDetails(@PathVariable int id) {
        Patient patient = patientService.getPatientById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("disease", patient.getDisease());

        Doctor assignedDoctor = patient.getAssignedDoctor();
        Map<String, Object> assignedDoctorInfo = new HashMap<>();
        assignedDoctorInfo.put("doctorId", assignedDoctor.getDoctorId());
        assignedDoctorInfo.put("name", assignedDoctor.getName());

        response.put("assignedDoctor", assignedDoctorInfo);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/doctors/{id}/patients")
    public ResponseEntity<List<Map<String, Object>>> getDoctorPatients(@PathVariable int id) {
        List<Map<String, Object>> patients = doctorService.getDoctorPatients(id);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/dean/sorted-order")
    public List<Patient> getAllPatientsSortedById(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "asc") String sortOrder) {

        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, "patientId"));

        return patientService.getAllPatientsSortedById(pageable).getContent();
    }

}
