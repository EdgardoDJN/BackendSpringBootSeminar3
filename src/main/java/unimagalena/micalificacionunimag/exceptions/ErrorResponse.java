package unimagalena.micalificacionunimag.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private LocalDateTime localDateTime;
    private String message;
    private String description;
}
