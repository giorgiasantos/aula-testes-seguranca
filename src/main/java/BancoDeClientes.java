import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;

public class BancoDeClientes {

    private List<Cliente> clientes = new ArrayList<>();

    public BancoDeClientes(){
        iniciarBancoClientes();
    }

    public boolean clienteJaExistente(String cpf) {
        for (Cliente cliente: this.clientes) {
            if(cliente.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }
    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        System.out.println("CLIENTE CADASTRADO COM SUCESSO.");
    }
    public void iniciarBancoClientes(){
        adicionarCliente(new Cliente("Joy", 22, "413.085.000-84", "joyce@zup.com", "12345"));
        adicionarCliente(new Cliente("João", 55, "280.029.420-51", "joao@zup.com", "54321"));
        adicionarCliente(new Cliente("Maria", 31, "751.456.540-06", "maria@zup.com", "67890"));
    }

    public void setClientes(List<Cliente> clientes){
        this.clientes = clientes;
    }

    public List<Cliente> getClientes(){
        return clientes;
    }

    public boolean verificaClienteExistente(String cpf){
        if(cpf == null) {
            return true;
        }else {
            return false;
        }
    }

}
