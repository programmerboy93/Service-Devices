package pl.serwiszarogiem.dto;

import lombok.Getter;
import lombok.Setter;
import pl.serwiszarogiem.entity.Device;
import pl.serwiszarogiem.entity.Status;
import pl.serwiszarogiem.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DeviceHistoryRepairDto {

    @NotNull
    private Long IdRepair;

    @NotNull
    private User user;

    @NotNull
    private Device device;

    @NotBlank
    private String descriptionRepair;

    @NotBlank
    private String descriptionFault;

    @NotNull
    private Status status;

}
