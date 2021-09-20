package pl.serwiszarogiem.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Entity
@Table(name="devices")
public class Device {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mark;

    @NotBlank
    private String model;

    @NotBlank
    private String serialNumber;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lastReview;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate reviewTo;

    @NotNull
    @OneToOne
    @JoinColumn(name = "type_id")
    private TypeDevices typeDevices;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Long dateToNextReview(){
        return ChronoUnit.DAYS.between(LocalDate.now(), reviewTo);
    }
}
