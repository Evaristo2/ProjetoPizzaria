package Pizza;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import InteracaoComCliente.Carrinho;
import InteracaoComCliente.Cliente;
import InteracaoComCliente.Pagamento;

public class Pedido {
    private static Carrinho carrinho = new Carrinho();
    static List<Pizza> pedidos = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    public Pedido(Scanner scan) {
        this.scan = scan;
    }

    public static void escolheTipoDePizza() {
        Scanner scan = new Scanner(System.in);
        boolean adicionar = true;

        while (adicionar) {

            System.out.println("\nVamos montar sua pizza!\n\nVocê quer uma pizza de 1 ou 2 sabores? (1/2)");
            int escolha = scan.nextInt();
            if (escolha == 1) {
                escolhePizzaInteira();

            } else if (escolha == 2) {
                escolhePizzaMeia();
            }

            System.out.println("Você deseja adicionar mais uma pizza? (s/n)");
            String maisPizza = scan.next();
            adicionar = maisPizza.equalsIgnoreCase("s");
        }

        finalizarPedido();
    }

	public static void escolhePizzaInteira() {
		List<Pizza> pizzaEscolhida = new ArrayList<>();
		boolean escolhaValida = false;

		do {
			try {
				System.out.println("\nOk! Escolha o sabor da sua pizza (pelo numero): ");
				int inteira = scan.nextInt();
				Menu.Sabores saborEscolhido = Menu.Sabores.escolherPorIndex(inteira);

				if (saborEscolhido != null) {
					System.out.println("Você escolheu o sabor " + saborEscolhido.getDesc());
					Pizza novaPizza = new Pizza(saborEscolhido.getDesc(), saborEscolhido.getPreco());
					pizzaEscolhida.add(novaPizza);
					escolhaValida = true;
				} else {
					System.out.println("Esse sabor não está no cardápio! Digite novamente os dois sabores.");

				}
			} catch (InputMismatchException e) {
				System.out.println("----------------------------------------");
				System.out.println("Opção inválida. Digite apenas números.");
				System.out.println("----------------------------------------");

				scan.nextLine();
			}
		} while (!escolhaValida);

		Carrinho.pedidos.addAll(pizzaEscolhida);
	}

	public static void escolhePizzaMeia() {
		boolean escolhaValida = false;
		double valorMaior;

		do {
			try {
				System.out.println("\nOk! Escolha o primeiro sabor (pelo numero):");
				int meia1 = scan.nextInt();
				System.out.println("Escolha o segundo sabor (pelo numero):");
				int meia2 = scan.nextInt();

				Menu.Sabores saborEscolhido1 = Menu.Sabores.escolherPorIndex(meia1);
				Menu.Sabores saborEscolhido2 = Menu.Sabores.escolherPorIndex(meia2);

				// CRIAÇÃO DE UMA PIZZA COM 2 SABORES
				if (saborEscolhido1 != null && saborEscolhido2 != null) {
					String pizzaMeiaMeia = "Meia " + saborEscolhido1.getDesc() + " e Meia " + saborEscolhido2.getDesc();
					double valorPizza1 = saborEscolhido1.getPreco();
					double valorPizza2 = saborEscolhido2.getPreco();
					valorMaior = Math.max(valorPizza1, valorPizza2);

					Carrinho.pedidos.add(new Pizza(pizzaMeiaMeia, valorMaior));

					escolhaValida = true;
				} else {
					System.out.println("Um ou ambos os sabores não estão no cardápio! Digite novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("-------------------------------------------");
				System.out.println("Opção inválida. Digite os sabores novamente.");
				System.out.println("-------------------------------------------");

				scan.nextLine();
			}
		} while (!escolhaValida);
	}

	public static void finalizarPedido() {
		escolheBrinde();
		double total = 0.0;

		System.out.println("\nMuito bem. Vamos ver o seu carrinho\n ");

		System.out.println("________________________________________________");
		System.out.println("\nCarrinho:");

		for (int contador = 0; contador < carrinho.pedidos.size(); contador++) {
			Pizza pizza = carrinho.pedidos.get(contador);
			System.out.println((contador + 1) + " - " + pizza.getDescricao() + " - R$ " + pizza.getPreco());
			total += pizza.getPreco();

		}

		System.out.println("________________________________________________");
		System.out.println("\nPreço total: R$ " + total);
		System.out.println("________________________________________________");
		System.out.println("\nVocê deseja:");
		System.out.println("1 - Remover alguma pizza");
		System.out.println("2 - Adicionar mais pizzas");
		System.out.println("3 - Finalizar o pedido e ir para forma de pagamento");

		int escolha = scan.nextInt();

		if (escolha == 1) {
			System.out.println("Digite o numero da pizza que quer remover:");
			int numeroPizza = scan.nextInt();
			Carrinho.removerPedido(numeroPizza);
			Carrinho.exibeCarrinho();
		} else if (escolha == 2) {
			Menu.exibeMenu();
			Pedido.escolheTipoDePizza();

		} else if (escolha == 3) {
			Pagamento.formaDePagamento(Cliente.getNome());
		} else {
			System.out.println("Opção inválida");
		}
	}

    public static void escolheBrinde() {
        double quantidadeBebidas = Math.floor((double) Carrinho.pedidos.size() / 2);
        
        if (Carrinho.pedidos.size() == 2) {
            System.out.println("\nATENÇÃO!\nComo você comprou " + Carrinho.pedidos.size() +
                    " pizzas, você tem direito a " + quantidadeBebidas + " bebida(s)!!\nDuas opções são disponibilizadas:");
            while (quantidadeBebidas > 0) {
                System.out.println("\nEscolha o número da sua bebida:\n1- Refrigerante (2L)\n2- Suco natural (1L)");
                int opcaoEscolhida = scan.nextInt();

                if (opcaoEscolhida == 1) {
                    System.out.println("Escolha a bebida:\n1- Coca-cola\n2- Guaraná\n3- Sprite\n4- Fanta Laranja");
                    int bebidaEscolhida = scan.nextInt();
                    switch (bebidaEscolhida) {
                        case 1:
                            System.out.println("Coca-cola adicionada ao pedido!");
                            break;
                        case 2:
                            System.out.println("Guaraná adicionado ao pedido!");
                            break;
                        case 3:
                            System.out.println("Sprite adicionado ao pedido!");
                            break;
                        case 4:
                            System.out.println("Fanta laranja adicionada ao pedido!");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                } else if (opcaoEscolhida == 2) {
                    System.out.println("Escolha a opção desejada:\n1- Suco de laranja\n2- Suco de acerola\n" +
                            "3- Suco de melancia\n4- Suco de maracujá");
                    int bebidaEscolhida = scan.nextInt();
                    switch (bebidaEscolhida) {
                        case 1:
                            System.out.println("Suco de laranja adicionado ao pedido!");
                            break;
                        case 2:
                            System.out.println("Suco de acerola adicionado ao pedido!");
                            break;
                        case 3:
                            System.out.println("Suco de melancia adicionado ao pedido!");
                            break;
                        case 4:
                            System.out.println("Suco de maracujá adicionado ao pedido!");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                } else {
                    System.out.println("A opção digitada não existe!");
                }
                quantidadeBebidas--;
            }
        }
    }

}	




