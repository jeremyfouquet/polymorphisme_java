/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

public enum Sexe {
	male('M'),
	femelle('F');

	private char sexe;
	
	Sexe(char sexe) {
		this.sexe = sexe;
	}

	public char getSexe() {
		return sexe;
	}
	
	
}
