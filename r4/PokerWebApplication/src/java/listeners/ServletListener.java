package listeners;


import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krzys
 */
public class ServletListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent attre) {
        System.out.println("Attribute " + attre.getName() + " has been added with value: " + attre.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent attre) {
        System.out.println("Attribute " + attre.getName() + " has been romoved");

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent attre) {
        System.out.println("Attribute " + attre.getName() + " has been replaced, with value: " + attre.getValue());
    }
    
}
