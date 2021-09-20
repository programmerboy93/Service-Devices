package pl.serwiszarogiem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name="users")
public class User{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private boolean enabled;

    @NotNull
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String fullName(){
        return this.getFirstName()+" "+this.getLastName();
    }
}

