package com.example.request;

import com.example.entity.User;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class CheckInRequest {

    @NotNull(message = "location should be not null")
    //@NotBlank(message = "location id should be not null")
    private int locationId;

}
