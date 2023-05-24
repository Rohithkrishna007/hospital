package balaji.spring.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dean")
public class Dean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dean_id")
    private Integer deanId;

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "dean")
    private List<Patient> patients;

    public Dean() {
    }

    public Dean(Integer deanId, String name, List<Patient> patients) {
        this.deanId = deanId;
        this.name = name;
        this.patients = patients;
    }

    public Integer getDeanId() {
        return deanId;
    }

    public void setDeanId(Integer deanId) {
        this.deanId = deanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}

