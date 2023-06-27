public class ClienteController{

    BancoDeClientes bancoClientes = new BancoDeClientes();

    public void cadastraCliente(Cliente cliente) {
        if(bancoClientes.clienteJaExistente(cliente.getCpf())){
            throw new IllegalArgumentException("Cliente já existente.");
        }
        bancoClientes.adicionarCliente(cliente);
    }



}
