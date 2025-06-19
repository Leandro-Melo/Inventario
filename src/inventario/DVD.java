package inventario;

public class DVD extends Produto {

	//Declarações de variaveis
	private String duracao;
	private int classificacaoEtaria;
	private String estudio;
	
	//Metodo construror vazio para instancia de classe
	public DVD() {
		
	}
	
	//Metodo construtor para criar objetos DVD
	public DVD(int numItem, String produto, String duracao, int classificacaoEtaria, String estudio, int qtdUnidadeEstoque, double preco, boolean status) {
		super(numItem, produto,qtdUnidadeEstoque, preco, status);
		this.duracao = duracao;
		this.classificacaoEtaria = classificacaoEtaria;
		this.estudio = estudio;
	}
	
	//metodo para imprimir dvd sobrecarregado da superclasse(Produto)
	@Override
	public String toString() {
		return 			 "Número do Item          : " + super.getNumItem() 
				+ "\n" + "Nome                    : " + super.getProduto() 
				+ "\n" + "Duração do Filme        : " + duracao
				+ "\n" + "Classificação Etária    : " + classificacaoEtaria
				+ "\n" + "Estudio Cenematográfico : " + estudio
				+ "\n" + "Quantidade em estoque   : " + super.getQtdUnidadesEstoque()
				+ "\n" + String.format("Preço                   : %.2f", super.getPreco())  
				+ "\n" + String.format("Valor do estoque        : %.2f", super.getInventoryValue())
				+ "\n" + "Status do produto       : " + (super.isStatus()==true ? "Ativo" : "Descontinuado");
	}

	//retorna duracao
	public String getDuracao() {
		return duracao;
	}

	//metodo para alterar o valor de duracao
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	//retorna classificacaoEtaria
	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	//metodo para alterar o valor de classificacaoEtaria
	public void setClassificacaoEtaria(int classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}

	//retorna estudio
	public String getEstudio() {
		return estudio;
	}

	//metodo para alterar o valor de estudio
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
}
