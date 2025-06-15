package inventario;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tempNumItem;
		String tempProduto;
		int tempQtdUnidadesEstoque;
		double tempPreco;
		boolean tempStatus;
		String sts;
		int maxSize = -1;
		
		Scanner sc = new Scanner(System.in);
		
		//loop para inserir um número valido(=>0)
		do {
				//tratamento de erro para verificar a i/o
				try {
					System.out.println("Digite a quantidade de produtos a serem adicionados");
					System.out.print("Digite 0 se não quiser adicionar produtos: ");
					maxSize = sc.nextInt();
					sc.nextLine();
					if(maxSize < 0) {
						throw new EntradaNumericaNegativaException("Valor número invalido insirido");//lançamento de exceção de numero negativo
					}
				}catch (EntradaNumericaNegativaException e) {
					System.out.println(e.getMessage() );
				}
				System.out.print("\n");
		}while(maxSize<0);
			
		//um if identificando se há itens para cadastrar ou não	
		if(maxSize == 0) {
			System.out.print("Não ha produtos cadastrados!!");
		}
		else {
			//criando um vetor flexivel de Produtos com o parametro passado pelo usuario 
			Produto [] produtos = new Produto [maxSize];
			//um loop para inserir a quantidade de produtos do tamanho do vetor
			for(int i=0; produtos.length > i; i++) {
				System.out.println("Digite o " + (i+1) +"º produto");
				System.out.print("Digite o numero do produto: ");
				tempNumItem = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite qual é o produto: ");
				tempProduto = sc.nextLine();
				System.out.print("Digite a quantidade do produto: ");
				tempQtdUnidadesEstoque = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite o preço do produto: ");
				tempPreco = Double.parseDouble(sc.nextLine());
				System.out.print("Digite o status do produto: ");
				sts = sc.nextLine();
				System.out.println("\n");
					
				if(sts.equalsIgnoreCase("Ativo")) {
					tempStatus = true;
				}else {tempStatus=false;}
					
				produtos[i] = new Produto(tempNumItem, tempProduto, tempQtdUnidadesEstoque, tempPreco, tempStatus);
					
			}
			
			//loop para imprimir todos os produtos do vetor
			for(Produto p : produtos) {
				System.out.print(p.toString());
				System.out.println("\n");
			}
			
		}	
		
	}

}
