import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ClienteLoginController clienteController = new ClienteLoginController();

        System.out.println("DIGITE O E-MAIL");
        String email = entrada.next();

        System.out.println("DIGITE A SENHA");
        String senha = entrada.next();

        Cliente cliente = new Cliente(email,senha);

        clienteController.cadastrarCliente(cliente);
        System.out.println("LOGIN");
        System.out.println("DIGITE A SENHA:");
        String senhaCadastrada = entrada.next();

        clienteController.login(senhaCadastrada);


    }
}
