/**
 * 
 */
package br.com.caelum.livraria.common;

import javax.ejb.ApplicationException;

/**
 * @author Ramon Vieira
 *
 */

@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5013320412494076667L;

}
