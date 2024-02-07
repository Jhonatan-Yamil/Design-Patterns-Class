package patrones;

import java.util.Scanner;

public class Sistema {
	Scanner sc = new Scanner(System.in);
	private boolean conectado;
	int intento=1;
	private int pin;
	private Cliente usuario;
	
	public Sistema(Cliente usuario) {
		this.usuario = usuario;
		this.pin = usuario.getPin();
	}
	public void inicio() {
		System.out.println("Ingrese su pin por favor");
		int usuarioPin = sc.nextInt();
		if(!conectado) {
			probarPin(usuarioPin);			
		}
	}
	
	public boolean probarPin(int usuarioPin) {
		if(pin == usuarioPin) {
			conectado=true;
			//usuario = new Cliente("Juan", 100);
			opciones();
		}else {
			if(intento == 3) {
				System.out.println("Intentaste 3 veces, debes comunicarte con alguien del banco para volver a intentar!");
			}else {				
			intento++;
			System.out.println("Salio un error, vuelve a ingresar tu pin por favor");
			inicio();
			}
		}
		return conectado;
	}
	
	public void opciones() {
		System.out.println("Escoja una de los opciones por favor");
		System.out.println("1. Saldo");
		System.out.println("2. Depósito");
		System.out.println("3. Retiros");
		System.out.println("4. Salir");
		int nroOpcion= sc.nextInt();
		
		switch(nroOpcion) {
		case 1:
			System.out.println("Su saldo es " + usuario.getSaldo());
			opciones();
			break;
		
		case 2:
			if(usuario.getSaldo()> 0) {
				System.out.println("Ingrese el monto a depositar por favor");
				int montoDep = sc.nextInt();
				usuario.setSaldo(usuario.getSaldo() + montoDep);
				System.out.println("Monto depositado satisfactoriamente");
				opciones();
			}else {
				System.out.println("No tienes un saldo disponible para hacer el depósito");
				opciones();
			}
			break;
		case 3:
			if(usuario.getSaldo() > 0) {
				System.out.println("Ingrese el monto a retirar por favor");
				int retiro= sc.nextInt();
				if(retiro<=usuario.getSaldo()) {
					usuario.setSaldo(usuario.getSaldo()-retiro);
					System.out.println("Retiro realizado satisfactoriamente!");
					opciones();
				}else {
					System.out.println("Monto a retirar sobrepasa el saldo, vuelva a intentar por favor");
					opciones();
				}
			}else {
				System.out.println("No puedes hacer ningún retiro debido a que no tienes saldo disponible!");
				opciones();
			}
			break;
		case 4:
			System.out.println("Que tenga buen día!!!");
			break;
		}
	}
}
