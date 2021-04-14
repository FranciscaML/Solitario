package com.company;

import java.util.Random;

public class Primario {

    private Carta[] cartas;
    private int indicePrimerHueco;

    private static final int NUM_NUMEROS = 13;

    public Primario() {
        indicePrimerHueco = 0;
        cartas = new Carta[Solitario.NUM_PALOS * NUM_NUMEROS];
        for (int i = 0; i < Solitario.NUM_PALOS; i++) {
            for (int j = 0; j < NUM_NUMEROS; j++) {
                this.poner(new Carta(i, j));
            }
        }
        this.barajar();
    }

    public void mostrar() {
        InOut inOut = new InOut();
        inOut.out("\nPrimario: ");
        if (this.vacia()) {
            inOut.out("<VACIA>");
        } else {
            this.cima().mostrar();
        }
    }

    public void moverA(Secundario secundario) {
        if (this.vacia()) {
            new InOut().out("¡¡¡Error!!! No hay cartas en baraja");
        } else {
            int contador = 3;
            while (contador > 0 && !this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                secundario.poner(carta);
                contador--;
            }
        }
    }

    private void barajar(){
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(Solitario.NUM_PALOS * NUM_NUMEROS);
            int destino = aleatorio.nextInt(Solitario.NUM_PALOS * NUM_NUMEROS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    private boolean vacia() {
        return indicePrimerHueco == 0;
    }

    private boolean completa() {
        return indicePrimerHueco == Solitario.NUM_PALOS * NUM_NUMEROS;
    }

    private Carta cima() {
        assert !this.vacia();
        return cartas[indicePrimerHueco - 1];
    }

    private Carta sacar() {
        assert !this.vacia();
        indicePrimerHueco--;
        return cartas[indicePrimerHueco];
    }

    private void poner(Carta carta) {
        assert carta != null;
        assert !carta.bocaArriba();
        assert !this.completa();
        cartas[indicePrimerHueco] = carta;
        indicePrimerHueco++;
    }


}
