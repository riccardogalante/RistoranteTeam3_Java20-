package src;

public enum EnumColori {
    ROSSO("\u001B[31m"),
    VERDE("\u001B[32m"),
    BLU("\u001B[34m"),
    GIALLO("\u001B[33m"),
    ARANCIONE("\u001B[38;5;208m");

    private String colore;

    EnumColori(String colore) {
        this.colore = colore;
    }

    public String getColore() {
        return colore;
    }
}