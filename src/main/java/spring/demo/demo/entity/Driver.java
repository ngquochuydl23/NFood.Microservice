package spring.demo.demo.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String email;

    @Column(unique = true)
    private String phone;

    private String avatar;
    private String password;
    @Column(name = "img_id_card_before")
    private String imgIdentifyCardBefore;
    @Column(name = "img_id_card_after")
    private String imgIdentityCardAfter;

    @OneToOne
    @JoinColumn(name = "numberDriverLicense")
    private DriverLicense numberDriverLicense;

    @OneToOne
    @JoinColumn(name = "licensePlates")
    private Vehicle licensePlates;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

}
