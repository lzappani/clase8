import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("""
                Ingrese Apellido, Nombres, Fecha de Nacimiento (dd/MM/aaaa),
                separados por coma, y presione ENTER >
                Para terminar, presione ENTER sin ingresar datos >\n""");
        do {

            String line = scanner.nextLine();
            if (line.equals("")) break;
            String[] fields = line.split(",");
            for (String field : fields) {
                field = field.stripLeading().stripTrailing();
            }
            try{
                personas.add(new Persona(fields[0], fields[1], format.parse(fields[2])));
            }
            catch (ParseException pe) {
                System.out.println("Formato de fecha incorrecto, por favor ingrese la fecha en formato dd/MM/aaaa");
            }

        } while (true);
        System.out.println("Personas cargadas:");
        for (Persona persona : personas) {
            System.out.printf("%-20s", persona.getNombre());
            System.out.printf("%-28s", persona.getApellido());
            System.out.printf("%-28s", format.format(persona.getFechaDeNacimiento()));
            System.out.println();
        }




    }
}
