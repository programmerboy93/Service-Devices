package pl.serwiszarogiem.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name="devices_history")
public class DeviceHistoryRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private Device device;

    @NotNull
    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @NotBlank
    @Length(min=5,max=1000)
    private String descriptionFault;

    @NotBlank
    @Length(min=5,max=1000)
    private String descriptionRepair;

    @NotNull
    private LocalDate dataRepair;
}
