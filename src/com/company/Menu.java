package com.company;

public class Menu {

    public void mostrar() {
        InOut inOut = new InOut();
        inOut.out("\n1.Mover de primario a secundario");
        inOut.out("\n2.Mover de secundario a columna");
        inOut.out("\n3.Mover de columna a columna");
        inOut.out("\n4.Mover de columna a palo");
        inOut.out("\n5.Mover de secundario a palo");
        inOut.out("\n6.Mover de palo a columna");
        inOut.out("\n7.Voltear carta en columna");
        inOut.out("\n8.Volcar todas las cartas de secundario a primario");
        inOut.out("\n9.Salir");
    }

    public int getOpcion() {
        // Falta comprobar que la opción esté entre 1 y 9
        InOut inOut = new InOut();
        return inOut.inInt();
    }
}
