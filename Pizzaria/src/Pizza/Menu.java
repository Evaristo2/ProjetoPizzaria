package Pizza;

import InteracaoComCliente.Cliente;

public class Menu {
		

    public enum Sabores {
        CALABRESA("Calabresa", 1, 35.00),
        MUSSARELA("Mussarela", 2, 34.00),
        BAIANA("Baiana", 3, 40.00),
        PORTUGUESA("Portuguesa", 4, 38.00),
        PALMITO("Palmito", 5, 36.00),
        VEGANA("Vegana", 6, 32.00);

        private final String desc;
        private final int num;
        private final double preco;

        Sabores(String desc, int num, double preco) {
            this.desc = desc;
            this.num = num;
            this.preco = preco;
        }

        public String getDesc() {
            return desc;
        }

        public int getNum() {
            return num;
        }

        public double getPreco() {
            return preco;
        }

        public static Sabores escolherPorIndex(int numeroDaPizza) {
            for (Sabores sabor : Sabores.values()) {
                if (sabor.num == numeroDaPizza) {
                    return sabor;
                }
            }
            return null;
        }
    }


    public static void exibeMenu() {
        System.out.println("\nPerfeito " + Cliente.getNome() + ", agora vamos dar uma olhada no Cardápio.");
        System.out.println("\n************************");
        System.out.println("Cardápio: ");

        for (Menu.Sabores sabores : Menu.Sabores.values()) {
            System.out.println(sabores.getNum() + " - " + sabores.getDesc() + " - R$ " + sabores.getPreco());

        }
        System.out.println("************************");

    }
}