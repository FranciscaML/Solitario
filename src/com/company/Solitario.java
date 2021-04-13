package com.company;

/**
 * Clase principal Solitario
 *
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
        for (int i = 0; i< columnas.length;i++) {
            this.columnas[i] = new Columna(i+1, primario);
        }

        this.palos = new Palo[NUM_PALOS];

        for (int i = 0; i < palos.length;i++) {
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

            InOut inOut = new InOut();
            switch (opcion) {
                case 1:
                    primario.moverA(secundario);
                    break;
                case 2:
                    // POR HACER:
                    // 1. Compartir con el código del caso 3 y siguientes en un método "recogerColumna" o similar
                    // 2. Chequear que el número de columna es correcto
                    // 3. Utilizar constante NUM_COLUMNAS en mensaje mostrado
                    inOut.out("¿A qué columna?[1-7]:");
                    int numColumna = inOut.inInt();
                    secundario.moverA(columnas[numColumna - 1]);
                    break;
                case 3:
                    inOut.out("¿De qué columna?[1-7]:");
                    int colOrigen = inOut.inInt();
                    inOut.out("¿A qué columna?[1-7]:");
                    int colDestino = inOut.inInt();
                    columnas[colOrigen - 1].moverA(columnas[colDestino - 1]);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }

        } while (opcion != 9);


    }

    private void mostrar() {
        this.primario.mostrar();
        this.secundario.mostrar();

        for (int i = 0; i < columnas.length; i++) {
            columnas[i].mostrar();
        }

        for (int i = 0; i < palos.length;i++) {
            palos[i].mostrar();
        }
    }

    public static void main(String[] args) {

        new Solitario().jugar();
    }
}
