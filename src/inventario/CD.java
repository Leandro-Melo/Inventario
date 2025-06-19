package inventario;

public class CD extends Produto {
	
	//Declarações de variaveis
	private String nomeArtista;
	private String seloGravacao;
	private int numMusica;
	
	//Metodo construror vazio para instancia de classe
	public CD() {
		
	}
	
	//Metodo construtor para criar objetos Produto
	public CD(int numItem, String produto, String nomeArtista, String seloGravacao, int numMusica, int qtdUnidadeEstoque, double preco, boolean status) {
		super(numItem, produto,qtdUnidadeEstoque, preco, status);
		this.nomeArtista = nomeArtista;
		this.seloGravacao = seloGravacao;
		this.numMusica = numMusica;
	}

	//metodo para imprimir cd sobrecarregado da superclasse(Produto)
	@Override
	public String toString() {
		return 			 "Número do Item         : " + super.getNumItem() 
				+ "\n" + "Nome                   : " + super.getProduto() 
				+ "\n" + "Artista                : " + nomeArtista
				+ "\n" + "Músicas no Álbum       : " + numMusica
				+ "\n" + "Selo de gravação       : " + seloGravacao
				+ "\n" + "Quantidade em estoque  : " + super.getQtdUnidadesEstoque()
				+ "\n" + String.format("Preço                  : %.2f", super.getPreco())  
				+ "\n" + String.format("Valor do estoque       : %.2f", super.getInventoryValue())
				+ "\n" + "Status do produto      : " + (super.isStatus()==true ? "Ativo" : "Descontinuado");
	}
	
	//retorna o nomeArtista
	public String getNomeArtista() {
		return nomeArtista;
	}

	//metodo para alterar o valor de nomeArtista
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	//retorna o seloGravacao
	public String getSeloGravacao() {
		return seloGravacao;
	}

	//metodo para alterar o valor de seloGravacao
	public void setSeloGravacao(String seloGravacao) {
		this.seloGravacao = seloGravacao;
	}

	//retorna o numMusica
	public int getNumMusica() {
		return numMusica;
	}

	//metodo para alterar o valor de numMusica
	public void setNumMusica(int numMusica) {
		this.numMusica = numMusica;
	}
	
	
}
