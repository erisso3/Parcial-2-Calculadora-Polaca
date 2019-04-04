/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author eriss
 */
public class Parentesisinvalidoexception extends Exception {

    /**
     * Creates a new instance of <code>Parentesisinvalidoexception</code>
     * without detail message.
     */
    public Parentesisinvalidoexception() {
    }

    /**
     * Constructs an instance of <code>Parentesisinvalidoexception</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public Parentesisinvalidoexception(String msg) {
        super(msg);
    }
}
