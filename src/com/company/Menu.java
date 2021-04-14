package com.company;

/**
 * Gestión del menu de opciones
 *
 */
public class Menu {

    private static final String[] TITULOS_OPCIONES = new String[]{
            "\n1. Mover de primario a secundario",
            "\n2. Mover de secundario a columna",
            "\n3. Mover de columna a columna",
            "\n4. Mover de columna a palo",
            "\n5. Mover de secundario a palo",
            "\n6. Mover de palo a columna",
            "\n7. Voltear carta en columna",
            "\n8. Volcar secundario en primario",
            "\n9. Salir"
    };

    private static final Intervalo OPCIONES = new Intervalo(1,9);

    public void mostrar(){
        InOut InOut = new InOut();
        for (String tituloOpcion : TITULOS_OPCIONES) {
            InOut.out(tituloOpcion);
        }
    }

    public int getOpcion() {
        InOut InOut = new InOut();
        int opcion;
        boolean error;
        do {
            InOut.out("\n¿Opción? [1-9]: ");
            opcion = InOut.inInt();
            error = !OPCIONES.incluye(opcion);
            if (error){
                InOut.out("¡¡¡Error!!! La opción debe ser entre 1 y 9");
            }
        } while (error);
        return opcion;
    }
}
