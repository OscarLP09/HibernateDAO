package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Data
@Entity
@Table(name="games")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String platform;
    private Integer year;
    private String description;
    @Column(name="image_url")
    private String imageUrl;

    @Transient
    private Integer age; // Cuando voy a leerlo, no lo voy a leer en la BD, cuando lo voy a escribir, no lo voy a  escribir en la BD

    /*
    @Formula("2025 - year")
    private Integer age;
     */



    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    /*public Integer getAge() {
        return 2024 - year;
    }
     */

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user.getEmail() +
                '}';
    }
}
