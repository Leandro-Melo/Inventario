package inventario;

import java.text.DecimalFormat;

public class Produto {

	//Declarações de campo de instância
	private int numItem;
	private String produto;
	private int qtdUnidadesEstoque;
	private double preco;
	private DecimalFormat df = new DecimalFormat("#.##");
	
	//Metodo construror vazio para instancia de classe

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

	@Override
	public String toString() {
		return 			 "Número do Item         : " + numItem 
				+ "\n" + "Nome                   : " + produto 
				+ "\n" + "Quantidade em estoque  : " + qtdUnidadesEstoque
				+ "\n" + "Preço                  : "+ df.format(preco)  
				+ "\n" + "Valor do estoque       : " + df.format(getInventoryValue())  
				+ "\n" + "Status do produto      : " + (status == true ? "Ativo" : "Descontinuado");
	}
	
	private double getInventoryValue() {
		return qtdUnidadesEstoque * preco;
	}
	
	public void addEstoque(int n) {
		try {
			if(n<1) {
				throw new Exception("Digite um número maior que 0");
			}
			qtdUnidadesEstoque += n;
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	
	public void retiraEstoque(int n) {
		try {
			if(n<1 || n>qtdUnidadesEstoque) {
				throw new Exception("Digite um número entre 1 e " + qtdUnidadesEstoque);
			}
			qtdUnidadesEstoque -= n;
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	
}
