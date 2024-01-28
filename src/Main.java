import br.com.bancodigital.model.pessoa.Cliente;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Bruna", "12345678911", 23,
                LocalDate.of(2000, 9, 19),"Solteira");
    }
}