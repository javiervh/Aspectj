package com.example.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

@Aspect
public aspect AspectBanco {
	
	/*before():execution (public* BancoConAspect.hacerDeposito(..)) {
		Date hora=new Date();
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss");
		System.out.println("Movimiento realizado a las " + formatoDeFecha.format(hora));
	}*/
	
	@Before("execution(* com.example.aspect.BancoConAspect.hacerRetiro(..))")
	public void CheckRetiro(ProceedingJoinPoint jp) {
		System.out.println("Método: "+jp.getSignature().getName() );
	    Object[] args = jp.getArgs();
		String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
	    Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
    	System.out.println("  "  + 0 + ". " + names[0] +
             " : " +            types[0].getName() +
             " = " +            args[0]);
    	if(Double.parseDouble(args[0].toString())>BancoConAspect.getSaldo()){
    		//System.out.println("No se puede continuar");
    		JOptionPane.showMessageDialog(null, "No hay fondos suficientes para esta transacción.", "Alerta", JOptionPane.ERROR_MESSAGE);
    	}
    	else
    		jp.proceed();   
	}
	
	@Before("execution(* com.example.aspect.BancoConAspect.hacerDeposito(..))")
	public void CheckDeposito(ProceedingJoinPoint jp) {
		System.out.println("Método: "+jp.getSignature().getName() );
	    Object[] args = jp.getArgs();
		String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
	    Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
    	System.out.println("  "  + 0 + ". " + names[0] +
             " : " +            types[0].getName() +
             " = " +            args[0]);
    	if(Double.parseDouble(args[0].toString())<=0){
    		//System.out.println("No se puede continuar");
    		JOptionPane.showMessageDialog(null, "No se puede realizar esta transacción. \nError Monto", "Alerta", JOptionPane.ERROR_MESSAGE);
    	}
    	else
    		jp.proceed();  
    	System.out.println("*********");
	}
	after():execution (public* BancoConAspect.hacer*(..)) {
		Date hora=new Date();
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss");
		//System.out.println("Movimiento realizado a las " + formatoDeFecha.format(hora));
		GuiAspect.textArea.setText("Movimiento realizado a las " + formatoDeFecha.format(hora));
	}
	after():execution (public* BancoConAspect.hacerConsulta(..)) {
		Date hora=new Date();
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss");
		GuiAspect.textArea.setText(GuiAspect.textArea.getText()+"<br>Consulta realizada a las "+formatoDeFecha.format(hora));
		System.out.println("Consulta realizadad a las "+formatoDeFecha.format(hora));
	}
}
