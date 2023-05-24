package balaji.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;


@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "disease")
    private String disease;

    @Column(name = "in-time")
    private Time in_time;

    @Column(name = "out-time")
    private Time out_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dean_id")
    private Dean dean;


    @ManyToOne
    @JoinColumn(name = "assigned_doctor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor assignedDoctor;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "status")
    private String status;

    public Patient() {
    }

    public Patient(Integer patientId, String name, String disease, Time in_time, Time out_time, Dean dean, Doctor assignedDoctor, LocalDate joinDate, String status) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.in_time = in_time;
        this.out_time = out_time;
        this.dean = dean;
        this.assignedDoctor = assignedDoctor;
        this.joinDate = joinDate;
        this.status = status;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Time getIn_time() {
        return in_time;
    }

    public void setIn_time(Time in_time) {
        this.in_time = in_time;
    }

    public Time getOut_time() {
        return out_time;
    }

    public void setOut_time(Time out_time) {
        this.out_time = out_time;
    }

    public Dean getDean() {
        return dean;
    }

    public void setDean(Dean dean) {
        this.dean = dean;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}