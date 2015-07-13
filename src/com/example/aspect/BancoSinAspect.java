package com.example.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BancoSinAspect {
	private double saldo;
	public BancoSinAspect(){
		setMonto(100.0);
	}
	public String hacerDeposito(double cantidad){
		if(cantidad <= 0) {
		   	return "No se puede realizar esta transaccion por este monto";
	    }
	    else {    	 
		   	this.saldo += cantidad;    	 
		   	return "Movimiento realizado a las "+registrarMovimiento();    	 
	    }
	}
	public String hacerRetiro(double cantidad){
		if(this.saldo < cantidad) {
		     return "No hay fondos suficientes para esta transaccion.";    	 
	    }
	    else {    	   	 
		    this.saldo -= cantidad;    	 
		    return "Movimiento realizado a las "+registrarMovimiento();
	    }
	}
	public void setMonto(double cantidad){
		this.saldo=cantidad;
	}
	public String hacerConsulta(){
		String text = String.format("%.2f",this.saldo);
		return text+"</h1><br>Consulta realizada a las "+registrarMovimiento();
	}
	
	public String registrarMovimiento(){
		Date hora = new Date();    	 
	    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy.MM.dd G 'a las' HH:mm:ss");
	    return formatoDeFecha.format(hora);
	}
}
