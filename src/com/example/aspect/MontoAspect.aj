package com.example.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import javax.swing.JOptionPane;
@Aspect
public aspect MontoAspect {
	@Before("execution(* com.example.aspect.GuiAspect.actionPerformed(..))")
	public void CheckRetiro(ProceedingJoinPoint jp) {
		System.out.println("Método: "+jp.getSignature().getName() );
	    Object[] args = jp.getArgs();
		String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
	    Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
    	System.out.println("  "  + 0 + ". " + names[0] +
             " : " +            types[0].getName() +
             " = " +            args[0]);
    	if(args[0].equals("")){
    		//System.out.println("No se puede continuar");
    		JOptionPane.showMessageDialog(null, "No se puede continuar.", "Alerta", JOptionPane.ERROR_MESSAGE);
    	}
    	else
    		jp.proceed();   
	}
}
