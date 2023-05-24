package balaji.spring.controllers;

import balaji.spring.entities.Doctor;
import balaji.spring.entities.Patient;
import balaji.spring.repositories.DoctorRepository;
import balaji.spring.repositories.PatientRepository;
import balaji.spring.services.DoctorService;
import balaji.spring.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
