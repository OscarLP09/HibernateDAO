package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.models.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Boolean is_admin;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Game> games = new ArrayList<>(0);

    public void addGame(Game g) {
        g.setUser(this);
        games.add(g);
    }
}
