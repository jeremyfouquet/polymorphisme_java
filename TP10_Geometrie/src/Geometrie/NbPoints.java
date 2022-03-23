package Geometrie;

public enum NbPoints {
    deux("2", 2, 1),
    trois("3", 3, 3),
	quatre("4", 4, 4);

    private String Val;
    private int NumVal;
    private int NumSegment;

    NbPoints(String Val, int NumVal, int NumSegment) {
        this.Val = Val;
        this.NumVal = NumVal;
        this.NumSegment = NumSegment;
    }

    public String getVal() {
        return Val;
    }

    public int getNumVal() {
        return NumVal;
    }

    public int getNumSegment() {
        return NumSegment;
    }
}