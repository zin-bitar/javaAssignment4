// ---------------------------------------------------------
// Assignment 4
// Written by: Zin Bitar 40305895
// For COMP 248 Section H 2242– Fall 2024
// ---------------------------------------------------------
public class Stamps {

    //making attributes private and creating each
    //initializing the final ones
    private int catA,catB,catC,catD,catE;
    private final int CAT_A_PRICE = 2;
    private final int CAT_B_PRICE = 5;
    private final int CAT_C_PRICE = 10;
    private final int CAT_D_PRICE = 15;
    private final int CAT_E_PRICE = 20;

    // default constructor
    public Stamps(){
        this.catA = 0;
        this.catB = 0;
        this.catC = 0;
        this.catD = 0;
        this.catE = 0;
    }

    //constructor
    public Stamps(int catA, int catB, int catC, int catD, int catE){
        this.catA = catA;
        this.catB = catB;
        this.catC = catC;
        this.catD = catD;
        this.catE = catE;
    }

    //copy method
    public Stamps(Stamps copy){
        this.catA = copy.getCatA();
        this.catB = copy.getCatB();
        this.catC = copy.getCatC();
        this.catD = copy.getCatD();
        this.catE = copy.getCatE();
    }

    //getters and setters
    public int getCatA() {
        return catA;
    }

    public void setCatA(int catA) {
        this.catA = catA;
    }

    public int getCAT_A_PRICE() {
        return CAT_A_PRICE;
    }

    public int getCatB() {
        return catB;
    }

    public void setCatB(int catB) {
        this.catB = catB;
    }

    public int getCAT_B_PRICE() {
        return CAT_B_PRICE;
    }

    public int getCatC() {
        return catC;
    }

    public void setCatC(int catC) {
        this.catC = catC;
    }

    public int getCAT_C_PRICE() {
        return CAT_C_PRICE;
    }

    public int getCatD() {
        return catD;
    }

    public void setCatD(int catD) {
        this.catD = catD;
    }

    public int getCAT_D_PRICE() {
        return CAT_D_PRICE;
    }

    public int getCatE() {
        return catE;
    }

    public void setCatE(int catE) {
        this.catE = catE;
    }

    public int getCAT_E_PRICE() {
        return CAT_E_PRICE;
    }

    //method to add each category of stamps
    public void addStamps(int addToA, int addToB, int addToC, int addToD, int addToE){

        this.setCatA(this.getCatA()+addToA);
        this.setCatB(this.getCatB()+addToB);
        this.setCatC(this.getCatC()+addToC);
        this.setCatD(this.getCatD()+addToD);
        this.setCatE(this.getCatE()+addToE);

    }

    //method to calculate total value of stamps in a registry
    public int StampsTotal(){
        return (catA*CAT_A_PRICE + catB*CAT_B_PRICE + catC*CAT_C_PRICE + catD*CAT_D_PRICE + catE* CAT_E_PRICE);
    }

    //toString
    @Override
    public String toString() {
        return catA + " x $" + CAT_A_PRICE + " + "+ catB + " x $" + CAT_B_PRICE + " + "+ catC + " x $" + CAT_C_PRICE + " + "+ catD + " x $" + CAT_D_PRICE + " + "+ catE + " x $" + CAT_E_PRICE;
    }

    //equals method
    public boolean equals(Stamps another){
        return (this.catA == another.catA && this.catB == another.catB && this.catC == another.catC && this.catD == another.catD && this.catE == another.catE);
    }
}