package pl.serwiszarogiem.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Range(max=20)
    private String firstName;

    @NotBlank
    @Range(max=20)
    private String lastName;

    @NotBlank
    private String phoneNumber;

    @OneToMany(mappedBy = "owner")
    List<Shop> shopList = new ArrayList<>();

    public String getFullName(){
        return firstName + " " +lastName;
    }
}
