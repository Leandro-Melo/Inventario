package inventario;

import java.util.ArrayList;
import java.util.Scanner;


public class ProductTester {

	static int tempNumItem;
	static String tempProduto;
	static int tempQtdUnidadesEstoque;
	static double tempPreco;
	static boolean tempStatus;
	static String sts;
	static int maxSize = -1;
	static int removeInventario;
	static int addInventario;
	
	static Scanner sc = new Scanner(System.in);
	
	//criando um vetor flexivel de Produtos com o parametro passado pelo usuario 
	static ArrayList<Produto> produtos = new ArrayList<>();
	
	public static void main(String[] args) {
		sistema();
		
	}
	
	private static void sistema() {
		try {
			System.out.println("1. Adicionar ao Inventário");
			System.out.println("2. Exibir Inventário");
			System.out.println("3. Adicionar ao Estoque");
			System.out.println("4. Deduzir do Estoque");
			System.out.println("5. Descontinuar Produto");
			System.out.println("0. Sair");
			int resposta = sc.nextInt();
			
			switch (resposta) {
			case 0: {
				break;
			}
			case 1: {
				getNumProdutos();
				sistema();
				break;
			}
			case 2: {
				displayInventario(produtos);
				sistema();
				break;
			}
			case 3: {
				if(produtos.size()>0) {
					System.out.print("Digite o número do item que quer adicionar ao estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<produtos.size();i++) {
			        	Produto p = produtos.get(i);
			        	if(p.getNumItem() == n ) {
			        		System.out.print("Quantos itens quer adicionar ao estoque de " + p.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		p.addEstoque(resposta);
			        		System.out.println("Quantidade adicionada ao estoque com sucesso!");
			        	}else {System.out.println("Item não encontrado no invetário");}
					}
		        }else {System.out.println("Não há produtos no inventário");}
				sistema();
				break;
			}
			case 4: {
				if(produtos.size()>0) {
					System.out.print("Digite o número do item que quer remover do estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<produtos.size();i++) {
			        	Produto p = produtos.get(i);
			        	if(p.getNumItem() == n ) {
			        		System.out.print("Quantos itens quer remover do estoque de " + p.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		p.retiraEstoque(resposta);
			        		System.out.println("Quantidade removidade do estoque com sucesso!");
			        	}else {System.out.println("Item não encontrado no invetário");}
					}
		        }else {System.out.println("Não há produtos no inventário");}
				sistema();
				break;
			}
			case 5: {
				if(produtos.size()>0) {
					System.out.print("Digite o número do item que quer descontinuar: ");
					int n = sc.nextInt();
					for(int i=0; i<produtos.size();i++) {
			        	Produto p = produtos.get(i);
			        	if(p.getNumItem() == n ) {
			        		p.setStatus(false);
			        		System.out.println("Produto " + p.getProduto() + " Descontinuado");
			        	}else {System.out.println("Item não encontrado no invetário");}
					}
		        }else {System.out.println("Não há produtos no inventário");}
				sistema();
				break;
			}
			default:
				throw new IllegalArgumentException("Digite um número entre 0 e 5 ");
			}
			
		}catch (IllegalArgumentException e) {
			e.getMessage();
		}
		
	}
	
	private static void getNumProdutos() {
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
		addToInventario(maxSize);
	}
	
	private static void addToInventario(int n) {
		//um loop para inserir a quantidade de produtos do tamanho do vetor
		for(int i=0; n > i; i++) {
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
				
			produtos.add( new Produto(tempNumItem, tempProduto, tempQtdUnidadesEstoque, tempPreco, tempStatus));
				
		}
		
	}
	
	private static void displayInventario(ArrayList<Produto> produtos) {
		//loop para imprimir todos os produtos do vetor
		for(Produto p : produtos) {
			System.out.print(p.toString());
			System.out.println("\n");
		}
	}

}
