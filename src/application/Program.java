package application;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		boasVindas();
		
		System.out.println("Vamos lá, me permita te conhecer melhor, qual é o seu nome?");
		System.out.print("Meu nome é: ");
		String nomeUsuario = sc.nextLine();
		
		System.out.println();
		System.out.println("Beleza " + nomeUsuario + ", qual é o produto que você vende?");
		System.out.print("Eu vendo: ");
		String nomeProduto = sc.nextLine();
		
		System.out.println();
		
		System.out.println("Que bacana " + nomeUsuario + ", então você vende " + nomeProduto + "!");
		System.out.print("Me informe a quantidade: ");
		int quantidadeProduto = sc.nextInt();
		
		System.out.println();
		
		System.out.println("E qual é o valor dessa preciosidade?");
		System.out.print("O valor: ");
		double valorProduto = sc.nextDouble();
		
		System.out.println();
		
		System.out.println("Vamos para as vendas!");
		System.out.println("As regras para o uso do sistema são simples...");
		System.out.println("1 - Quando você realizar uma venda, apenas insira a quantidade e pressione Enter!");
		System.out.println("2 - Quando parar de vender ao fim do dia então insira a letra 'P' e pressione Enter!");
		
		System.out.println("A partir de agora vamos pra cima !\n");
		
		boolean estouVendendo = true;
		int somaVenda = 0;
		
		do {
			
			System.out.println("Quanto você vendeu?");
			String qtdVenda = sc.next().trim();
			
			if(isNumeric(qtdVenda)) {
				if (Integer.valueOf(qtdVenda) >= 0 && Integer.valueOf(qtdVenda) <= quantidadeProduto) {
					somaVenda += Integer.valueOf(qtdVenda);
					System.out.println("Venda do produto " + nomeProduto + " realizada!");
					quantidadeProduto -= Integer.valueOf(qtdVenda);
				}
			}else {
				if (qtdVenda.trim().equalsIgnoreCase("P")) {
					estouVendendo = false;
				}else {
					System.out.println("Você inseriu um valor incorreto!");
				}
			}
			
			if (quantidadeProduto <= 0) break;
			
		}while(estouVendendo);
		
		System.out.printf("Você vendeu %d %s e lucrou %.2f.\n", somaVenda, nomeProduto, (somaVenda * valorProduto));
		
		if (quantidadeProduto != 0) System.out.println("Sobraram " + quantidadeProduto + " " + nomeProduto + ".");
				
		sc.close();
	}
	
	public static void boasVindas() {
		
		System.out.println("-= Sistema de vendas do produto (v1.0) =-");
		System.out.println();
		System.out.println("*************************************");
		System.out.println("*                                   *");
		System.out.println("*  O Sistema que te ajuda a vender  *");
		System.out.println("*                                   *");
		System.out.println("*                    by Miguel D.F  *");
		System.out.println("*                                   *");
		System.out.println("*************************************");
		System.out.println();
		
		int horaAgora = LocalDateTime.now().getHour();
		
		if (horaAgora >= 6 && horaAgora < 12) {
			System.out.println("Bom dia, usuário!");
		}else if (horaAgora >= 12 && horaAgora < 18) {
			System.out.println("Boa tarde, usuário!");
		}else if ((horaAgora >= 18 && horaAgora < 23) || (horaAgora >= 0 && horaAgora < 6)) {
			System.out.println("Boa noite, usuário!");
		}
		
	}
	
	private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }

}
