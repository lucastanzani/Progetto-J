/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

/**
 *
 * @author Nickelsilver
 * @param <T>
 */
public interface JSONCommand<T> {
    
    public abstract T execute(String toDecode);
    
}
