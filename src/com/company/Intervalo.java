package com.company;

public class Intervalo {

	private double inferior;
	private double superior;

	public Intervalo(double inferior, double superior) {
		this.inferior = inferior;
		this.superior = superior;
	}

	public boolean incluye(double valor) {
		return inferior <= valor && valor <= superior;
	}
}

