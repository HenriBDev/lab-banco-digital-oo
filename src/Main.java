import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Olá, digite seus dados por favor: \n\nNome: ");
		Cliente cliente = new Cliente();
		Conta conta;
		cliente.setNome(scan.nextLine());

		System.out.print("Cpf: ");
		cliente.setCpf(Integer.parseInt(scan.nextLine()));

		System.out.print("Tipo de conta (1 - Corrente, 2 - Poupança): ");
		int tipoConta = scan.nextInt();
		
		if(tipoConta == 1){
			conta = new ContaCorrente(cliente);
		}else{
			conta = new ContaPoupanca(cliente);
		}
		conta.depositar(100);

		int selecao;
		do{
			System.out.print("\nBem-vindo " + cliente.getNome() + "! O que deseja fazer?\n\n1 - Depositar dinheiro\n2 - Sacar dinheiro\n3 - Imprimir extrato\n4 - Sair\n\nEscolha: ");
			selecao = scan.nextInt();
			switch(selecao){
				case 1:
					System.out.print("Digite o valor que deseja depositar: ");
					conta.depositar(scan.nextDouble());
				break;
				case 2:
					System.out.print("Digite o valor que deseja sacar: ");
					conta.sacar(scan.nextDouble());
				break;
				case 3:
					conta.imprimirExtrato();
				break;
				case 4:
					System.out.print("Obrigado por ter usado o programa! ^^\n");
				break;
				default:
					System.out.print("Seleção inválida!");
				break;
			}
		}while(selecao != 4);
	}
}
