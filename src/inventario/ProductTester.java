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
		
		Scanner sc = new Scanner(System.in);
		
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
		System.out.println("");
		
		if(sts.equalsIgnoreCase("Ativo")) {
			tempStatus = true;
		}else {tempStatus=false;}
		
		Produto p1 = new Produto(tempNumItem, tempProduto, tempQtdUnidadesEstoque, tempPreco, tempStatus);
		
		System.out.print(p1.toString());
		
		System.out.print("\n");
		System.out.print("\n");
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
		System.out.println("");
		
		if(sts.equalsIgnoreCase("Ativo")) {
			tempStatus = true;
		}else {tempStatus=false;}
		
		Produto p2 = new Produto(tempNumItem, tempProduto, tempQtdUnidadesEstoque, tempPreco, tempStatus);
		
		System.out.print(p2.toString());
	}

}
