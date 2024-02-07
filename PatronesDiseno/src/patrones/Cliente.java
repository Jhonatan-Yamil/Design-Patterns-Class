package patrones;

public class Cliente {
	private String nombre;
	private double saldo;
	private int pin;
	
	public Cliente(String nombre, int saldo, int pin) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.pin = pin;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double nuevoSaldo) {
		this.saldo = nuevoSaldo;
	}
	public int getPin() {
		return pin;
	}
}
