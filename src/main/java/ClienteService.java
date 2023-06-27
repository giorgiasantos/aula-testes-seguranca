import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<>();

    // Metodos

    public void adicionaCliente(Cliente cliente){
        criptografarSenha(cliente);
        clientes.add(cliente);
    }

    public void criptografarSenha(Cliente cliente){
        String hashDaSenha = BCrypt.hashpw(cliente.getSenha(), BCrypt.gensalt());
        cliente.setSenha(hashDaSenha);
        System.out.println("O hash da senha é: " + hashDaSenha);
    }

    public String mostraSenha() {
        return clientes.get(0).getSenha();
    }

    public boolean login(String senha){
        return BCrypt.checkpw(senha, clientes.get(0).getSenha());
    }

}
