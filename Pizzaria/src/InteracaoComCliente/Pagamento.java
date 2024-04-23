package InteracaoComCliente;

import java.util.Scanner;

public class Pagamento {

	public static void formaDePagamento(String nomeCliente) {
		Scanner scan = new Scanner(System.in);
	
	        System.out.println("\nFormas de pagamento:");
	        System.out.println("1 - Débito");
	        System.out.println("2 - Crédito");
	        System.out.println("3 - Pix");

	        System.out.println("\nEscolha a forma de pagamento:");
	       
			int escolha = scan.nextInt();

	        switch (escolha) {
	            case 1:
	                System.out.println("\nObrigado pela confiança!");
	                System.out.println("Volte sempre, " + nomeCliente + "!");
	        		System.exit(0);
	                break;
	            case 2:
	                System.out.println("\nObrigado pela confiança!");
	                System.out.println("Volte sempre, " + nomeCliente + "!");
	        		System.exit(0);
	                break;
	            case 3:
	                System.out.println("\nObrigado pela confiança!");
	                System.out.println("Volte sempre, " + nomeCliente + "!");
	        		System.exit(0);
	                return;
	            default:
	                System.out.println("\nOpção inválida. Escolha uma forma de pagamento válida.");
	                formaDePagamento(nomeCliente); 
	                break;
	    }
	}
}
	
	

