package modelo;

public enum Instrumento {
    
	VIOLIN_I("Violino I"),
	VIOLIN_II("Violino II"),
	VIOLIN_III("Violino III"),
	VIOLA("Viola"),
	CELLO("Cello"),
	PIANO("Piano"),
	VIOLAO("Violao"),
	FLUTE_I("Flauta I"),
	FLUTE_II("Flauta II"),
	CLARINET_I("Clarinete I"),
	CLARINET_II("Clarinete II"),
	ALTO_SAX("Sax Alto"),
	TENOR_SAX("Sax Tenor"),
	TRUMPET("Trompete"),
	TROMBONE("Trombone"),
	PERCUSSION("Percussao");
	
	private String nome;
	
	private Instrumento(String nome) {
		this.nome = nome;
	}
	
	public  String getnome() {
		return nome;
	}
	
}
