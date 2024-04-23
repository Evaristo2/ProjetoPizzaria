package InteracaoComCliente;

import java.util.Scanner;

public class Cliente {
	private static String nome;
	private String telefone;
	
	Scanner scan = new Scanner(System.in);
	
	public Cliente() {
		this.nome = "";
		this.telefone = "";
	}
	
	public void recepcao() {
		System.out.println("""
				************************
				     BEM VINDO(A)
				 Pizzaria do Evaristo
				************************
				""");
	}

	public static String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public void cadastroCliente(Scanner scan) {
		System.out.println("Para fazer o pedido, primeiro nos informe o seu nome: ");
		String nome = scan.next();
		this.nome = nome;
				
		System.out.println("Agora o seu telefone (apenas números): ");
		String telefone = scan.next();

	}
	
}
