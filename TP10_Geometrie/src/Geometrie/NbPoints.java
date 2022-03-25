/** 
 * Jeremy Fouquet
 */
package Geometrie;

public enum NbPoints {
    deux("2","Segment"),
    trois("3","Triangle"),
	quatre("4","Quadrilatere");

    private String Val; // Valeur proposé dans l'input select
    private String Forme; // Nom du type de forme correspondant

    NbPoints(String Val, String Forme) {
        this.Val = Val;
        this.Forme = Forme;
    }

    public String getVal() {
        return this.Val;
    }
    
    public String getForme() {
        return this.Forme;
    }
}