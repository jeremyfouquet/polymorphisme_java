package Geometrie;

public enum NbPoints {
    deux("2", 2, 1, "Segment"),
    trois("3", 3, 3, "Triangle"),
	quatre("4", 4, 4, "Quadrilatere");

    private String Val;
    private int NumVal;
    private int NumSegment;
    private String Forme;

    NbPoints(String Val, int NumVal, int NumSegment, String Forme) {
        this.Val = Val;
        this.NumVal = NumVal;
        this.NumSegment = NumSegment;
        this.Forme = Forme;
    }

    public String getVal() {
        return this.Val;
    }

    public int getNumVal() {
        return this.NumVal;
    }

    public int getNumSegment() {
        return this.NumSegment;
    }
    
    public String getForme() {
        return this.Forme;
    }
}