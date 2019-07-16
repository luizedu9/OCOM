package modelo;

public enum Sexo {
    
	MASCULINO("Masculino"),
    FEMININO("Feminino"),
	INDETERMINADO("Indeterminado");
	
	private String descricao;
	
	private Sexo(String descricaco){
		this.descricao = descricaco;
	}
	
	public  String getDescricao(){
		return descricao;
	}
	
}
