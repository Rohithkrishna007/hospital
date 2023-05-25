package balaji.spring.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "doctor_id")
        private Integer doctorId;

        @Column(name = "name")
        private String name;

        @Column(name = "join_date")
        private LocalDate joinDate;

        @Column(name = "disease")
        private String disease;

        @OneToMany(mappedBy = "assignedDoctor")
        private List<Patient> patients;

        public Doctor() {
        }

        public Doctor(Integer doctorId, String name, LocalDate joinDate, String disease, List<Patient> patients) {
                this.doctorId = doctorId;
                this.name = name;
                this.joinDate = joinDate;
                this.disease = disease;
                this.patients = patients;
        }

        public Integer getDoctorId() {
                return doctorId;
        }

        public void setDoctorId(Integer doctorId) {
                this.doctorId = doctorId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getJoinDate() {
                return joinDate;
        }

        public void setJoinDate(LocalDate joinDate) {
                this.joinDate = joinDate;
        }

        public String getDisease() {
                return disease;
        }

        public void setDisease(String disease) {
                this.disease = disease;
        }

        public List<Patient> getPatients() {
                return patients;
        }

        public void setPatients(List<Patient> patients) {
                this.patients = patients;
        }

        @Override
        public String toString() {
                return "Doctor{" +
                        "doctorId=" + doctorId +
                        ", name='" + name + '\'' +
                        ", joinDate=" + joinDate +
                        ", disease='" + disease + '\'' +
                        ", patients=" + patients +
                        '}';
        }
}
