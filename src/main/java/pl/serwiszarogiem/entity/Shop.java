package pl.serwiszarogiem.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Range(max=50)
    private String nameShop;

    @NotBlank
    @Length(max=50)
    private String nameCity;

    private String nameStreet;

    @NotNull
    private Long numberStreet;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "shop")
    Set<Device> devices = new HashSet<>();
}
