package balaji.spring.services;

import balaji.spring.entities.Doctor;
import balaji.spring.entities.Patient;
import balaji.spring.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {

        @Autowired
        private DoctorRepository doctorRepo;

        public Doctor getDoctorById(Integer id) {
        return doctorRepo.findById(id).orElseThrow(null);
    }

        public List<Map<String, Object>> getDoctorPatients(int doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + doctorId));

        List<Map<String, Object>> patients = new ArrayList<>();
        for (Patient patient : doctor.getPatients()) {
            Map<String, Object> patientInfo = new HashMap<>();
            patientInfo.put("joinDate", patient.getJoinDate());
            patientInfo.put("disease", patient.getDisease());
            patients.add(patientInfo);
        }

        return patients;
    }

        public List<Map<String, Object>> getDoctorPatientsSortedByDate(int doctorId) {
        Optional<Doctor> doctor = doctorRepo.findById(doctorId);
        List<Patient> patients = doctor.get().getPatients();
        // Sort the patients by join date
        Collections.sort(patients, Comparator.comparing(Patient::getJoinDate));

        // Create a list of maps containing the required patient information
        List<Map<String, Object>> patientDetails = new ArrayList<>();
        for (Patient patient : patients) {
            Map<String, Object> patientMap = new HashMap<>();
            patientMap.put("patientId", patient.getPatientId());
            patientMap.put("name", patient.getName());
            patientMap.put("joinDate", patient.getJoinDate());
            patientMap.put("disease", patient.getDisease());
            patientDetails.add(patientMap);
        }

        return patientDetails;
    }

        public Page<Doctor> getAllDoctorsSortedById(Pageable pageable) {
        return doctorRepo.findAll(pageable);
    }

        public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
}
