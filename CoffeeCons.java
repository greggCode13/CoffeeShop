public class CoffeeCons {
    String name;
    double pShort;
    double pTall;
    double pGrande;

    CoffeeCons(String name, double pShort, double pTall, double pGrande) {
        this.name = name;
        this.pShort = pShort;
        this.pTall = pTall;
        this.pGrande = pGrande;
    }

    @Override
    public String toString() {
        return String.format(" ! %s ! \nShort - PHP %.2f\nTall - PHP %.2f\nGrande - PHP %.2f", this.name, this.pShort, this.pTall, this.pGrande);
    }
}
