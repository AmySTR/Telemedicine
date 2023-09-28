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

// @Entity
// @Getter
// @Setter
// @NoArgsConstructor
// @Table(name = "allergy")
// public class Allergy {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToMany
//     @JoinTable(name = "health_record", joinColumns = @JoinColumn(name = "allergy_id"),
//             inverseJoinColumns = @JoinColumn(name = "health_rec_id"))
//     private List<HealthRecord> healthRecords;

//     @Column(name = "name", nullable = false)
//     private String name;

//     @Column(name = "description", nullable = false)
//     private String description;

//     @CreationTimestamp
//     @Column(name = "created_at", nullable = false, updatable = false)
//     private LocalDateTime createdAt;

//     @UpdateTimestamp
//     @Column(name = "updated_at", nullable = false)
//     private LocalDateTime updatedAt;

//     public Allergy(String name, String description) {
//         this.name = name;
//         this.description = description;
//     }
// }
