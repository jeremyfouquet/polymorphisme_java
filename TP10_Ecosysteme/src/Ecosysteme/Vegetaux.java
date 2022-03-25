package Ecosysteme;

public abstract class Vegetaux extends Especes {
	private int graineEtPollen = 1;

	public Vegetaux() {
		EcoSysteme.especes.add(this);
		// TODO Auto-generated constructor stub
	}
	
	protected abstract void enleveGraineEtPollen();

	//GETTERS, SETTERS, EQUALS, TOSTRING
	public int getGraineEtPollen() {
		return graineEtPollen;
	}
	public void setGraineEtPollen(int graineEtPollen) {
		this.graineEtPollen = graineEtPollen;
	}
	@Override
	public String toString() {
		return "Vegetaux [graineEtPollen=" + graineEtPollen + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vegetaux other = (Vegetaux) obj;
		return graineEtPollen == other.graineEtPollen;
	}

}
