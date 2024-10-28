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
    @Column(name = "is_admin")
    private Boolean isAdmin;


    @OneToMany(mappedBy = "user",
               fetch = FetchType.EAGER,
               cascade = CascadeType.ALL
    )
    /* CascadeType
       .REMOVE
       .ALL
       .MERGE
       .PERSIST
       .DETACH
     */
    private List<Game> games = new ArrayList<>(0);

    public void addGame(Game g) {
        g.setUser(this);
        games.add(g);
    }
}
