package pl.serwiszarogiem.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name="device_to_repair")
public class DeviceToRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;


    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @NotBlank
    @Length(min=5,max=1000)
    private String descriptionFault;
}
