package inventario;

import java.text.DecimalFormat;

public class Produto {

	//Declarações de variaveis
	private int numItem;
	private String produto;
	private int qtdUnidadesEstoque;
	private double preco;
	private boolean status;
	
	//Metodo construror vazio para instancia de classe
	public Produto() {
		
	}
	
	//Metodo construtor para criar objetos Produto
	public Produto(int numItem, String produto, int qtdUnidadeEstoque, double preco, boolean status) {
		this.numItem = numItem;
		this.produto = produto;
		this.qtdUnidadesEstoque = qtdUnidadeEstoque;
		this.preco = preco;
		this.status = status;
	}

	
	//retorna o numItem
	public int getNumItem() {
		return numItem;
	}

	//metodo para alterar o valor de numItem
	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}

	//retorna o produto
	public String getProduto() {
		return produto;
	}

	//metodo para alterar o valor de produto
	public void setProduto(String produto) {
		this.produto = produto;
	}

	//retorna a qtdUnidadesEstoque
	public int getQtdUnidadesEstoque() {
		return qtdUnidadesEstoque;
	}

	//metodo para alterar o valor de qtdUnidadesEstoque
	public void setQtdUnidadesEstoque(int qtdUnidadesEstoque) {
		this.qtdUnidadesEstoque = qtdUnidadesEstoque;
	}

	//retorna o preco
	public double getPreco() {
		return preco;
	}

	//metodo para alterar o valor de preco
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	//retorna o status
	public boolean isStatus() {
		return status;
	}

	//metodo para alterar o valor de status
	public void setStatus(boolean status) {
		this.status = status;
	}

	//metodo para imprimir produto
	@Override
	public String toString() {
		return 			 "Número do Item         : " + numItem 
				+ "\n" + "Nome                   : " + produto 
				+ "\n" + "Quantidade em estoque  : " + qtdUnidadesEstoque
				+ "\n" + String.format("Preço                  : %.2f", preco)  
				+ "\n" + String.format("Valor do estoque       : %.2f", getInventoryValue())
				+ "\n" + "Status do produto      : " + (status == true ? "Ativo" : "Descontinuado");
	}
	
	//metodo para retornar o valor total do estoque
	public double getInventoryValue() {
		return qtdUnidadesEstoque * preco;
	}
	
	//metodo para adicionar itens ao estoque de um produto
	public void addEstoque(int n) {
		try {//compara se o valor passado é 0 ou negativo
			if(n<1) {
				throw new Exception("Digite um número maior que 0");//lança uma exceção para um numero invalido
			}
			qtdUnidadesEstoque += n;
		}catch(Exception e){//captura a exceção de numero invalido
			System.out.print( e.getMessage());
		}
		
	}
	
	//metodo para remover itens do estoque de um produto
	public void retiraEstoque(int n) {
		try {//compara se o valor passado é 0 ou negativo ou maior que o numero de produtos do estoque
			if(n<1 || n>qtdUnidadesEstoque) {
				throw new Exception("Digite um número entre 1 e " + qtdUnidadesEstoque);//lança uma exceção para um numero invalido
			}
			qtdUnidadesEstoque -= n;
		}catch(Exception e) {//captura a exceção de numero invalido
			System.out.print( e.getMessage());
		}
	}
	
	
}
