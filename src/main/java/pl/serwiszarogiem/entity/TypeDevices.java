package pl.serwiszarogiem.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name= "type_devices")
public class TypeDevices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Range(max=50)
    @UniqueElements
    private String type;

    @Range(max=1000)
    private String description;
}
