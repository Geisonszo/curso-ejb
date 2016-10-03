/**
 * 
 */
package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author Ramon Vieira
 *
 */
public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext contex) throws Exception {
		long millis = System.currentTimeMillis();

        Object o = contex.proceed();

        System.out.println("Class = ["+contex.getTarget().getClass().getSimpleName()+"] - Method = ["+contex.getMethod().getName()+"]");
        System.out.println("[INFO] Tempo gasto no acesso ao BD: " + (System.currentTimeMillis() - millis) + "ms");
        
		return o;
    }
	
}
