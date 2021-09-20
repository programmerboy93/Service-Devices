package pl.serwiszarogiem.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.serwiszarogiem.entity.Device;
import pl.serwiszarogiem.entity.Status;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class DeviceToReviewDto {

    @NotNull
    private Long idReview;

    @NotNull
    private Status status;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lastReview;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate reviewTo;

    @NotNull
    private Device device;

    private String descriptionReview;
}
