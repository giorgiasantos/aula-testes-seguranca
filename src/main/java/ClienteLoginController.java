public class ClienteLoginController {

    ClienteService clienteService = new ClienteService();

    // Metodos
    public void cadastrarCliente(Cliente cliente){
        clienteService.adicionaCliente(cliente);
    }

    public void login (String senha){
        if(clienteService.login(senha)) {
            System.out.println("BEM-VINDO!");
        }else {
            System.out.println("SENHA INCORRETA!");
        }
    }

}
