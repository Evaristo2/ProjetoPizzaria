package InteracaoComCliente;

import java.util.ArrayList;
import java.util.List;

import Pizza.Menu.Sabores;
import Pizza.Pizza;

public class Carrinho {
    public static List<Pizza> pedidos = new ArrayList<>();

    public static void exibeCarrinho() {
        System.out.println("Itens no carrinho:");
        for (Pizza pizza : pedidos) {
            System.out.println(pizza);
        }
    }

    public static void removerPedido(int numeroDoPedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (i + 1 == numeroDoPedido) {
                pedidos.remove(i);
                break;
            }
        }
	}

}
