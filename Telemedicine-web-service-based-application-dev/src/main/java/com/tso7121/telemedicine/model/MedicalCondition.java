// package com.tso7121.telemedicine.model;

// import java.time.LocalDateTime;
// import java.util.List;
// import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import java.time.LocalDate;

// @Entity
// @Getter
// @Setter
// @NoArgsConstructor
// @Table(name = "medical_condition")
// public class MedicalCondition {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToMany
//     @JoinTable(name = "health_record", joinColumns = @JoinColumn(name = "medical_con_id"),
//             inverseJoinColumns = @JoinColumn(name = "health_rec_id"))
//     private List<HealthRecord> healthRecords ;
    
//     @Column(nullable = false)
//     private String name;

//     @Column(nullable = false)
//     private LocalDate diagnosisDate;

//     @Column(nullable = false)
//     private String notes;

//     @CreationTimestamp
//     @Column(name = "created_at", nullable = false, updatable = false)
//     private LocalDateTime createdAt;

//     @UpdateTimestamp
//     @Column(name = "updated_at", nullable = false)
//     private LocalDateTime updatedAt;

//     public MedicalCondition(String name, LocalDate diagnosisDate, String notes) {
//         this.name = name;
//         this.diagnosisDate = diagnosisDate;
//         this.notes = notes;
//     }
// }
