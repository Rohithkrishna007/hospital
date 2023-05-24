package balaji.spring.services;

import balaji.spring.entities.Doctor;
import balaji.spring.entities.Patient;
import balaji.spring.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    public Patient getPatientById(int id) {
        return patientRepo.findById(id).orElse(null);
    }

    public Patient getPatientDetails(int patientId) {
        return patientRepo.findById(patientId).orElse(null);
    }

    public String getDiseaseByPatientId(int patientId) {
        Patient patient = patientRepo.findById(patientId).orElse(null);
        return (patient != null) ? patient.getDisease() : null;
    }

    public Doctor getAssignedDoctorByPatientId(int patientId) {
        Patient patient = patientRepo.findById(patientId).orElse(null);
        return (patient != null) ? patient.getAssignedDoctor() : null;
    }


}