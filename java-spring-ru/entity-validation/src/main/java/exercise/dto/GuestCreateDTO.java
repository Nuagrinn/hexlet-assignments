package exercise.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GuestCreateDTO {

    @NotNull
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\+.*")
    @Size(min=11, max=13)
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}", message = "Поле должно содержать ровно 4 цифры")
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;

}
