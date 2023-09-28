package com.tso7121.telemedicine.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "health_record")
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private User patient;

    // @ManyToOne
    // @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    // private User doctor;

    @Column(name = "height")
    private double height; // in centimeters

    @Column(name = "weight")
    private double weight; // in kilograms

    @Column(name = "bloodType")
    private String bloodType;

    @Column(name = "notes")
    private String notes;
    // @ManyToMany(mappedBy = "healthRecords")
    // private List<MedicalCondition> medicalConditions;

    // @ManyToMany(mappedBy = "healthRecords")
    // private List<Medication> medications;

    // @ManyToMany(mappedBy = "healthRecords")
    // private List<Allergy> allergies;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // public void addMedicalCondition(String name, LocalDate diagnosisDate, String notes) {
    //     MedicalCondition condition = new MedicalCondition(name, diagnosisDate, notes);
    //     medicalConditions.add(condition);
    // }

    // public void addMedication(String name, String description, Double qty, String uom) {
    //     Medication medication = new Medication(name, description, qty, uom);
    //     medications.add(medication);
    // }

    // public void addAllergy(String name, LocalDate diagnosisDate, String notes) {
    //     Allergy allergy = new Allergy(name, notes);
    //     allergies.add(allergy);
    // }

    public double getBmi() {
        double heightInMeters = (double) height / 100;
        return weight / (heightInMeters * heightInMeters);
    }
    
    public String getPatientName() {
        return this.patient.getFirstName() + " " + this.patient.getLastName();
    }
}
