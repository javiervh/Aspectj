package com.example.aspect;

public class BancoConAspect {
	private static double saldo;
	public BancoConAspect(){
		setMonto(100.0);
	}
	
	public void hacerDeposito(double cantidad){
		if(cantidad <= 0) {
			System.out.println("No se puede realizar esta transaccion por este monto");
	    }
	    else {
	    	saldo += cantidad;
	    	//return "Movimiento depo realizado a las ";
	    }
	}
	public void hacerRetiro(double cantidad){
		if(this.saldo < cantidad) {
			System.out.println("No hay fondos suficientes para esta transaccion.");     	 
		}
		else {
		   	 this.saldo -= cantidad;
		   	//return "Movimiento reti realizado a las ";
		}
	}
	public void setMonto(double cantidad){
		saldo=cantidad;
	}
	public String hacerConsulta(){
		String text = String.format("%.2f",saldo);
		return text+"</h1><br>Consulta realizada. ";
	}
	public static double getSaldo(){
		return saldo;
	}
}
