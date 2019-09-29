/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author mosen
 */
public class GenericDao<T> {
    public T save(T t){
    
    Session s =HibernateUtil.getSessionFactory().openSession();
    s.getTransaction().begin();
    s.save(t);
    s.getTransaction().commit();
    s.close();
    
    return t;
        }
    
    
    public T update (T t){
    
    Session s =HibernateUtil.getSessionFactory().openSession();
    s.getTransaction().begin();
    s.update(t);
    s.getTransaction().commit();
    s.close();
    
    return t;
        }
    
    public T getById(Class c,Serializeble Id){
        Session s =HibernateUtil.getSessionFactory().openSession();
        T o=(T) s.get(c, (Serializable) Id);
        s.close();
        return o;
    }
    
    
    
}
