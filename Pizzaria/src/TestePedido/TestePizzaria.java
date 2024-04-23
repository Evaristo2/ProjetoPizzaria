package TestePedido;

import java.util.Scanner;

import InteracaoComCliente.Cliente;
import InteracaoComCliente.Pagamento;
import Pizza.Menu;
import Pizza.Pedido;

public class TestePizzaria {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
	//RECEPÇÃO (CLIENTE)
		cliente.recepcao();
		
		
	//CADASTRO CLIENTE (CLIENTE)
		cliente.cadastroCliente(scan);
		String nome = Cliente.getNome();
		
		
	//MOSTRAR MENU (MENU)
		Menu.exibeMenu();

		
	//FAZER PEDIDO
		
		//MONTAR PIZZA (PEDIDO)
		Pedido.escolheTipoDePizza();
		Pedido.finalizarPedido();
				
		
		//PAGAMENTO (PAGAMENTO)
		Pagamento.formaDePagamento(nome);
		
		System.exit(0);
	}
}

