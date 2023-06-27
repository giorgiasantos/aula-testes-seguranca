import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTeste {

    @Mock
    private BancoDeClientes bancoDeClientes;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void cadastraClienteComCpfRepetido(){

        Cliente cliente = new Cliente("João", 55, "280.029.420-51", "joao@zup.com", "54321");
        // quando chamar o metodo clienteJaExistente retorna true
        when(bancoDeClientes.clienteJaExistente(cliente.getCpf())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> clienteController.cadastraCliente(cliente));
        //verifica se eu nunca salvei cliente
        verify(bancoDeClientes, never()).adicionarCliente(cliente);
    }

    @Test
    public void cadastraClienteComCpfNovo(){
        Cliente cliente = new Cliente("João", 33, "000.000.000-11", "joao@zup.com", "56732");

        when(bancoDeClientes.clienteJaExistente(cliente.getCpf())).thenReturn(false);
        clienteController.cadastraCliente(cliente);
        verify(bancoDeClientes, times(1)).adicionarCliente(cliente);
    }
}
