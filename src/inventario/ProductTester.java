package inventario;

import java.util.ArrayList;
import java.util.Scanner;


public class ProductTester {

	//Produto
	static int tempNumItem;
	static String tempProduto;
	static int tempQtdUnidadesEstoque;
	static double tempPreco;
	static boolean tempStatus;
	static String sts;
	static int maxSize = -1;
	static int removeInventario;
	static int addInventario;
	//CD
	static String tempArtista, tempSeloGravacao;
	static int tempNumMusica;
	//DVD
	static String tempDuracao;
	static int tempClassificacaoEtaria;
	static String tempEstudio;
	//instanciando Scanner
	static Scanner sc = new Scanner(System.in);
	//criando arrays flexiveis 
	static ArrayList<Produto> produtos = new ArrayList<>();
	static ArrayList<CD> cds = new ArrayList<>();
	static ArrayList<DVD> dvds = new ArrayList<>();
	
	public static void main(String[] args) {
		sistema();
		
	}
	
	//metodo de opções para o usuario
	private static void sistema() {
		//tratamento de erro para verificar a i/o
		try {
			System.out.println("1. Adicionar ao Inventário");
			System.out.println("2. Exibir Inventário");
			System.out.println("3. Adicionar ao Estoque");
			System.out.println("4. Deduzir do Estoque");
			System.out.println("5. Descontinuar Produto");
			System.out.println("0. Sair");
			int resposta = sc.nextInt();
			
			switch (resposta) {
			case 0: {//sai do programa
				System.exit(0);
			}
			case 1: {//chama o metodo de cadastro e volta as opções iniciais
				getNumProdutos();
				sistema();
				break;
			}
			case 2: {//opções para imprimir o inventario e volta as opções iniciais
				//tratamento de erro para verificar o array	
				try {
					System.out.println("Qual inventario quer ver: ");
					System.out.println("0. Todos");
					System.out.println("1. Produtos");
					System.out.println("2. CD");
					System.out.println("3. DVD");
					r = sc.nextInt();
					//tratamento de erro para verificar a i/o
					try {
						switch (r) {
						case 0: {//imprime os 3 arrays
							if(produtos.size() < 1) {
								throw new Exception("Sem produtos cadastrados\n");//lançamento de exceção caso o array esteja vazio
							}else {
								displayInventario(produtos);
							}
							if(cds.size() < 1) {
								throw new Exception("Sem CDs cadastrados\n");///lançamento de exceção caso o array esteja vazio
							}else {
								displayInventarioCD(cds);
							}
							if(dvds.size() < 1) {
								throw new Exception("Sem DVDs cadastrados\n");//lançamento de exceção caso o array esteja vazio
							}else {
								displayInventarioDVD(dvds);
							}
							break;
						}
						case 1: {//imprime os produtos
							if(produtos.size() < 1) {
								throw new Exception("Sem produtos cadastrados\n");//lançamento de exceção caso o array esteja vazio
							}
							
							displayInventario(produtos);
							break;
						}
						case 2: {//imprime os cds
							if(cds.size() < 1) {
								throw new Exception("Sem CDS cadastrados\n");//lançamento de exceção caso o array esteja vazio
							}
							
							displayInventarioCD(cds);
							break;
						}
						case 3: {//imprime os dvds
							if(dvds.size() < 1) {
								throw new Exception("Sem DVDs cadastrados\n");//lançamento de exceção caso o array esteja vazio
							}else {
								displayInventarioDVD(dvds);
							}
							break;
						}
						default://default caso insirido um valor diferente das opções
							throw new IllegalArgumentException("Insira um valor entre 1 e 3\n");//lançamento de exceção de numero invalido
						}
						}catch (IllegalArgumentException e) {//captura a exceção de numero invalido
							System.out.println(e.getMessage());
						}
		
				}catch (Exception e) {//captura a exceção de array vazio
					System.out.println(e.getMessage());
				}
		
				sistema();
				break;
			}
			case 3: {//chama o metodo adicionar no inventario e volta as opções iniciais
				addInInventario();
				sistema();
				break;
			}
			case 4: {//chama o metodo remover do inventario e volta as opções iniciais
				removeInInventario();
				sistema();
				break;
			}
			case 5: {//chama o metodo descontinuar item e volta as opções iniciais
				descontinuarItem();
				sistema();
				break;
			}
			default://default caso insirido um valor diferente das opções
				throw new IllegalArgumentException("Digite um número entre 0 e 5\n ");//lançamento de exceção de numero invalido
			}
			
		}catch (IllegalArgumentException e) {//captura a exceção de numero invalido
			System.out.print(e.getMessage());
		}
		
	}
	
	
	
	static int r;
	//metodo para cadastro de itens no inventario
	private static void getNumProdutos() {
	
		//tratamento de erro para verificar a i/o
		try {
			System.out.println("O que vai ser adicionado: ");
			System.out.println("1. Produto");
			System.out.println("2. CD");
			System.out.println("3. DVD");
			r = sc.nextInt();
					
			try {
				switch (r) {
				case 1: {//insere a quantidade de produtos a serem cadastrados
						
					System.out.println("Digite a quantidade de Produtos a serem adicionados");
					System.out.print("Digite 0 se não quiser adicionar Produtos: ");
					maxSize = sc.nextInt();
					sc.nextLine();
					if(maxSize < 0) {
						throw new EntradaNumericaNegativaException("Valor número invalido insirido\n");//lançamento de exceção de numero negativo
					}
					break;
				}
				case 2: {//insere a quantidade de cds a serem cadastrados
							
					System.out.println("Digite a quantidade de CDs a serem adicionados");
					System.out.print("Digite 0 se não quiser adicionar CDs: ");
					maxSize = sc.nextInt();
					sc.nextLine();
					if(maxSize < 0) {
						throw new EntradaNumericaNegativaException("Valor número invalido insirido\n");//lançamento de exceção de numero negativo
					}
					break;
				}
				case 3: {//insere a quantidade de dvs a serem cadastrados
							
					System.out.println("Digite a quantidade de DVDs a serem adicionados");
					System.out.print("Digite 0 se não quiser adicionar DVDs: ");
					maxSize = sc.nextInt();
					sc.nextLine();
					if(maxSize < 0) {
						throw new EntradaNumericaNegativaException("Valor número invalido insirido\n");//lançamento de exceção de numero negativo
					}
					break;
				}
				default:
					throw new IllegalArgumentException("Insira um valor entre 1 e 3\n");//lançamento de exceção de numero invalido
				}
				}catch (IllegalArgumentException e) {//captura a exceção de numero invalido
					System.out.print(e.getMessage());
					getNumProdutos();	
				}
	
		}catch (EntradaNumericaNegativaException e) {//captura a exceção de numero negativo
			System.out.println(e.getMessage() );
			getNumProdutos();
		}
		System.out.print("\n");
					
		//um if identificando se há itens para cadastrar ou não
		if(maxSize == 0) {
			System.out.print("Não ha produtos cadastrados!!\n\n");
		}else {
			if(r == 1) {
				addToInventario(maxSize);//chama o metodo de cadastro de produtos
			}else if(r == 2) {
				addToInventarioCD(maxSize);//chama o metodo de cadastro de cds
			}else {
				addToInventarioDVD(maxSize);//chama o metodo de cadastro de dvds
			}
		}
	}
	
	//metodo cadastrar produtos
	private static void addToInventario(int n) {
		//um loop para inserir a quantidade de produtos pasasdo no parametro
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
			//compara o status passado pela string e atribui o valor de true ou false a tempStatus	
			if(sts.equalsIgnoreCase("Ativo")) {
				tempStatus = true;
			}else {tempStatus=false;}
			//cria um novo Produto e adiciona ao array	
			produtos.add( new Produto(tempNumItem, tempProduto, tempQtdUnidadesEstoque, tempPreco, tempStatus));
				
		}
		
	}
	
	//metodo cadastrar cds
	private static void addToInventarioCD(int n) {
		//um loop para inserir a quantidade de cds pasasdo no parametro
		for(int i=0; n > i; i++) {
			System.out.println("Digite o " + (i+1) +"º CD");
			System.out.print("Digite o numero do CD: ");
			tempNumItem = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o nome do CD: ");
			tempProduto = sc.nextLine();
			System.out.print("Digite o nome do artista: ");
			tempArtista = sc.nextLine();
			System.out.print("Digite o nome do selo de gravação: ");
			tempSeloGravacao = sc.nextLine();
			System.out.print("Digite o número de músicas: ");
			tempNumMusica = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite a quantidade do produto: ");
			tempQtdUnidadesEstoque = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o preço do produto: ");
			tempPreco = Double.parseDouble(sc.nextLine());
			System.out.print("Digite o status do produto: ");
			sts = sc.nextLine();
			System.out.println("\n");
			//compara o status passado pela string e atribui o valor de true ou false a tempStatus	
			if(sts.equalsIgnoreCase("Ativo")) {
				tempStatus = true;
			}else {tempStatus=false;}
			//cria um novo CD e adiciona ao array		
			cds.add(new CD(tempNumItem, tempProduto, tempArtista, tempSeloGravacao, tempNumMusica, tempQtdUnidadesEstoque, tempPreco, tempStatus));
				
		}
		
	}
	
	
	
	
	//metodo cadastrar dvds
	private static void addToInventarioDVD(int n) {
		//um loop para inserir a quantidade de dvds pasasdo no parametro
		for(int i=0; n > i; i++) {
			System.out.println("Digite o " + (i+1) +"º DVD");
			System.out.print("Digite o número do DVD: ");
			tempNumItem = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite qual é o DVD: ");
			tempProduto = sc.nextLine();
			System.out.print("Digite qual é a durção do DVD: ");
			tempDuracao = sc.nextLine();
			System.out.print("Digite qual é a classificação etaria do DVD: ");
			tempClassificacaoEtaria = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite qual o estudio do DVD: ");
			tempEstudio = sc.nextLine();
			System.out.print("Digite a quantidade do produto: ");
			tempQtdUnidadesEstoque = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o preço do produto: ");
			tempPreco = Double.parseDouble(sc.nextLine());
			System.out.print("Digite o status do produto: ");
			sts = sc.nextLine();
			System.out.println("\n");
			//compara o status passado pela string e atribui o valor de true ou false a tempStatus	
			if(sts.equalsIgnoreCase("Ativo")) {
				tempStatus = true;
			}else {tempStatus=false;}
			//cria um novo DVD e adiciona ao array		
			dvds.add( new DVD(tempNumItem, tempProduto, tempDuracao, tempClassificacaoEtaria, tempEstudio, tempQtdUnidadesEstoque, tempPreco, tempStatus));
				
		}
		
	}
	
	
	//metodo para imprimir os produtos
	private static void displayInventario(ArrayList<Produto> produtos) {
		//loop para imprimir todos os produtos do array
		System.out.println("--------------PRODUTOS--------------");
		for(Produto p : produtos) {
			System.out.print(p.toString());
			System.out.println("\n");
		}
	}
	
	//metodo para imprimir os cds
	private static void displayInventarioCD(ArrayList<CD> cds) {
		//loop para imprimir todos os cds do array
		System.out.println("--------------CD--------------");
		for(CD cd : cds) {
			System.out.print(cd.toString());
			System.out.println("\n");
		}
	}
	
	
	
	//metodo para imprimir os dvds
	private static void displayInventarioDVD(ArrayList<DVD> dvds) {
		//loop para imprimir todos os dvds do array
		System.out.println("--------------DVD--------------");
		for(DVD dvd : dvds) {
			System.out.print(dvd.toString());
			System.out.println("\n");
		}
	}

	//metodo para adicionar a quantidade de itens em determinado estoque de item
	private static void addInInventario() {
		int resposta;
		//tratamento de erro para verificar o array	
		try {
			System.out.println("Qual estoque quer adicionar itens: ");
			System.out.println("1. Produto");
			System.out.println("2. CD");
			System.out.println("3. DVD");
			r = sc.nextInt();
			//tratamento de erro para verificar a i/o	
			try {
				switch (r) {
				case 1: {//adiciona itens ao estoque de produto
					if(produtos.size()<1) {
						throw new Exception("Sem Produtos cadastrados\n");//lançamento de exceção array vazio
					}
					System.out.print("Digite o número do item que quer adicionar ao estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<produtos.size();i++) {
				        Produto p = produtos.get(i);
				        if(p.getNumItem() == n ) {//compara cada item do array para encontrar o item a adcionar ao inventario
				        	System.out.print("Quantos itens quer adicionar ao estoque de " + p.getProduto() + ": ");
				        	resposta = sc.nextInt();
				        	p.addEstoque(resposta);
				        	System.out.println("Quantidade adicionada ao estoque com sucesso!\n");
				        }else {System.out.println("Item não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					
					break;
				}
				case 2: {//adiciona itens ao estoque de cd
					if(cds.size() < 1) {
						throw new Exception("Sem CDs cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do CD que quer adicionar ao estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<cds.size();i++) {
			        	CD cd = cds.get(i);
			        	if(cd.getNumItem() == n ) {//compara cada item do array para encontrar o item a adcionar ao inventario
			        		System.out.print("Quantos CDs quer adicionar ao estoque de " + cd.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		cd.addEstoque(resposta);
			        		System.out.println("Quantidade adicionada ao estoque com sucesso!\n");
			        	}else {System.out.println("Item não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					
					break;
				}
				case 3: {//adiciona itens ao estoque de dvd
					if(dvds.size() < 1) {
						throw new Exception("Sem DVDs cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do DVD que quer adicionar ao estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<dvds.size();i++) {
			        	DVD dvd = dvds.get(i);
			        	if(dvd.getNumItem() == n ) {//compara cada item do array para encontrar o item a adcionar ao inventario
			        		System.out.print("Quantos DVDs quer adicionar ao estoque de " + dvd.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		dvd.addEstoque(resposta);
			        		System.out.println("Quantidade adicionada ao estoque com sucesso!\n");
			        	}else {System.out.println("Item não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
				
					break;
				}
				
				default:
					throw new IllegalArgumentException("Insira um valor entre 1 e 3\n");//lançamento de exceção de numero invalido
				}
				}catch (IllegalArgumentException e) {//captura a exceção de numero invalido
					System.out.print(e.getMessage());
					addInInventario();
				}

		}catch (Exception e) {//captura a exceção de array vazio
			System.out.println(e.getMessage());
			
		}
	}
	
	//metodo para remover a quantidade de itens em determinado estoque de item
	private static void removeInInventario() {
		int resposta;
		//tratamento de erro para verificar o array	
		try {
			System.out.println("Qual estoque quer adicionar itens: ");
			System.out.println("1. Produto");
			System.out.println("2. CD");
			System.out.println("3. DVD");
			r = sc.nextInt();
			//tratamento de erro para verificar a i/o	
			try {
				switch (r) {
				case 1: {
					if(produtos.size() < 1) {
						throw new Exception("Sem Produtos cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do item que quer remover do estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<produtos.size();i++) {
			        	Produto p = produtos.get(i);
			        	if(p.getNumItem() == n ) {//compara cada item do array para encontrar o item a remover do inventario
			        		System.out.print("Quantos itens quer remover do estoque de " + p.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		p.retiraEstoque(resposta);
			        		System.out.println("Quantidade removidade do estoque com sucesso!\n");
			        	}else {System.out.println("Item não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					
					break;
				}
				case 2: {
					if(cds.size() < 1) {
						throw new Exception("Sem CDs cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do CD que quer remover do estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<cds.size();i++) {
			        	CD cd = cds.get(i);
			        	if(cd.getNumItem() == n ) {//compara cada item do array para encontrar o item a remover do inventario
			        		System.out.print("Quantos CDs quer remover do estoque de " + cd.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		cd.retiraEstoque(resposta);
			        		System.out.println("Quantidade removida do estoque com sucesso!\n");
			        	}else {System.out.println("CD não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					
					break;
				}
				case 3: {
					if(dvds.size() < 1) {
						throw new Exception("Sem DVDs cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do DVD que quer retirar do estoque: ");
					int n = sc.nextInt();
					for(int i=0; i<dvds.size();i++) {
			        	DVD dvd = dvds.get(i);
			        	if(dvd.getNumItem() == n ) {//compara cada item do array para encontrar o item a remover do inventario
			        		System.out.print("Quantos DVDs quer remover do estoque de " + dvd.getProduto() + ": ");
			        		resposta = sc.nextInt();
			        		dvd.retiraEstoque(resposta);
			        		System.out.println("Quantidade removida do estoque com sucesso!\n");
			        	}else {System.out.println("DVD não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					break;
				}
				
				default:
					throw new IllegalArgumentException("Insira um valor entre 1 e 3\n");//lançamento de exceção de numero invalido
				}
				}catch (IllegalArgumentException e) {//captura a exceção de numero invalido
					System.out.print(e.getMessage());
					removeInInventario();
				}

		}catch (Exception e) {//captura a exceção de array vazio
			System.out.println(e.getMessage());
			
		}
	}

	//metodo para descontinuar determinado item 
	private static void descontinuarItem() {
		//tratamento de erro para verificar a i/o
		try {
			System.out.println("Qual estoque quer descontinuar itens: ");
			System.out.println("1. Produto");
			System.out.println("2. CD");
			System.out.println("3. DVD");
			r = sc.nextInt();
				
			try {
				switch (r) {
				case 1: {
					if(produtos.size() < 1) {
						throw new Exception("Sem produtos cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do item que quer descontinuar: ");
					int n = sc.nextInt();
					for(int i=0; i<produtos.size();i++) {
			        	Produto p = produtos.get(i);
			        	if(p.getNumItem() == n ) {//compara cada item do array para encontrar o item a descontinuar
			        		p.setStatus(false);
			        		System.out.println("Produto " + p.getProduto() + " Descontinuado\n");
			        	}else {System.out.println("Item não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}							
					break;
				}
				case 2: {
					if(cds.size() < 1) {
						throw new Exception("Sem CDs cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do CD que quer descontinuar: ");
					int n = sc.nextInt();
					for(int i=0; i<cds.size();i++) {
			        	CD cd = cds.get(i);
			        	if(cd.getNumItem() == n ) {//compara cada item do array para encontrar o item a descontinuar
			        		cd.setStatus(false);;
			        		System.out.println("CD " + cd.getProduto() +" descontinuado com sucesso!\n");
			        	}else {System.out.println("CD não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					
					break;
				}
				case 3: {
					if(dvds.size() < 1) {
						throw new Exception("Sem DVDs cadastrados\n");//lançamento de exceção array vazio
					}
					
					System.out.print("Digite o número do DVD que quer descontinuar: ");
					int n = sc.nextInt();
					for(int i=0; i<dvds.size();i++) {
			        	DVD dvd = dvds.get(i);
			        	if(dvd.getNumItem() == n ) {//compara cada item do array para encontrar o item a descontinuar
			        		dvd.setStatus(false);
			        		System.out.println("DVD " + dvd.getProduto() +" descontinuado com sucesso!\n");
			        	}else {System.out.println("DVD não encontrado no invetário\n");}//retorno caso não encontre o item passado
					}
					break;
				}
				
				default:
					throw new IllegalArgumentException("Insira um valor entre 1 e 3\n");//lançamento de exceção de numero invalido
				}
				}catch (IllegalArgumentException e) {//captura a exceção de numero invalido
					System.out.print(e.getMessage());
					descontinuarItem();
				}

		}catch (Exception e) {//captura a exceção de array vazio
			System.out.println(e.getMessage());
			
		}
	}
	
}
