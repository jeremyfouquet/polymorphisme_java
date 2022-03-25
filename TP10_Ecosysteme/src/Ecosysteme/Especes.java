package Ecosysteme;


public abstract class Especes {
	private boolean vivant = true;

	public Especes() {
		// TODO Auto-generated constructor stub
	}
	
	public void estMange() {
		mourir();
		EcoSysteme.especes.remove(this);
	}

	public void mourir() {
		this.vivant = false;
	}

	//GETTERS, SETTERS, EQUALS, TOSTRING
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}	
	@Override
	public String toString() {
		return "Especes [vivant=" + vivant + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especes other = (Especes) obj;
		return vivant == other.vivant;
	}
		
}
