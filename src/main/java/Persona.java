import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class Persona {
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    private Date fechaDeNacimiento;
}
