package com.company;

/**
 * Clase principal Solitario
 */
public class Solitario {

    private Primario primario;
    private Secundario secundario;
    private Columna[] columnas;
    private Palo[] palos;

    private static final int NUM_COLUMNAS = 7;
    private static final int NUM_PALOS = 4;

    public Solitario() {

        this.primario = new Primario();
        this.secundario = new Secundario();

        this.columnas = new Columna[NUM_COLUMNAS];
        for (int i = 0; i < columnas.length; i++) {
            this.columnas[i] = new Columna(i + 1, primario);
        }

        this.palos = new Palo[NUM_PALOS];

        for (int i = 0; i < palos.length; i++) {
            this.palos[i] = new Palo();
        }

    }

    private void jugar() {
        Menu menu = new Menu();
        int opcion;
        do {
            this.mostrar();
            menu.mostrar();
            opcion = menu.getOpcion();
            switch (opcion) {
                case 1:
                    primario.moverA(secundario);
                    break;
                case 2:
                    secundario.moverA(this.recogerColumna("A"));
                    break;
                case 3:
                    this.recogerColumna("De").moverA(this.recogerColumna("A"));
                    break;
                case 4:
                    this.recogerColumna("De").moverA(this.recogerPalo("A"));
                    break;
                case 5:
                    secundario.moverA(this.recogerPalo("A"));
                    break;
               case 6:
                    this.recogerPalo("De").moverA(this.recogerColumna("A"));
                    break;
                case 7:
                    this.recogerColumna("De").voltear();
                    break;
                case 8:
                    secundario.volcarA(primario);
                    break;
                case 9:
                    break;
            }
        } while (opcion != 9);
    }

    private Palo recogerPalo(String prefijo) {
        InOut InOut = new InOut();
        int numPalo;
        boolean error;
        do {
            InOut.out("¿" + prefijo + " qué palo? [1-" + NUM_PALOS + "]: ");
            numPalo = InOut.inInt();
            error = !new Intervalo(1, NUM_PALOS).incluye(numPalo);
            if (error) {
                InOut.out("¡¡¡Error!!! Debe ser un número entre 1 y " + NUM_PALOS);
            }
        } while (error);
        return palos[numPalo - 1];
    }

    private Columna recogerColumna(String prefijo) {
        InOut InOut = new InOut();
        int numColumna;
        boolean error;
        do {
            InOut.out("¿" + prefijo + " qué columna? [1-" + NUM_COLUMNAS + "]: ");
            numColumna = InOut.inInt();
            error = !new Intervalo(1, NUM_COLUMNAS).incluye(numColumna);
            if (error) {
                InOut.out("¡¡¡Error!!! Debe ser un número entre 1 y " + NUM_COLUMNAS);
            }
        } while (error);
        return columnas[numColumna - 1];
    }

    private void mostrar() {
        this.primario.mostrar();
        this.secundario.mostrar();

        for (int i = 0; i < columnas.length; i++) {
            columnas[i].mostrar();
        }

        for (int i = 0; i < palos.length; i++) {
            palos[i].mostrar();
        }
    }

    public static void main(String[] args) {

        new Solitario().jugar();
    }
}
