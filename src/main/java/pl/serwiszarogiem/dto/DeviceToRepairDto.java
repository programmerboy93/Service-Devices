package pl.serwiszarogiem.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import pl.serwiszarogiem.entity.Device;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class DeviceToRepairDto {

    @NotNull
    private Device device;

    @NotBlank
    @Length(min=5,max=1000)
    private String descriptionFault;
}
