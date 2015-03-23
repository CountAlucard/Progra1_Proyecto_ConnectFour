/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;


/**
 *
 * @author Carlos
 */
public class Player {
    public String nombre;
    public String usuario;
    public String password;
    public int score = 0;
        
    public Player(String nom, String usu, String pass, int sc)
    {
        this.nombre = nom;
        this.usuario = usu;
        this.password = pass;
        this.score = sc;
    }
    
        
    public String getNombre()
    {
        return nombre;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int sc)
    {
        this.score = sc;
    }
    
    public void setPassword(String pass)
    {
        this.password = pass;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setUsuario(String usua)
    {
        this.usuario = usua;
    }
    
    public String getUsuario()
    {
        return usuario;        
    }
    
    public void deleteUser()
    {
        this.nombre = null;
        this.password = null;        
    }
    
    public void Print()
    {
        System.out.println("\nNombre: "+nombre+"\nUsuario: "+usuario+"\nPassword: "+password+"\nScore: "+score+"\n");
        
    }

}
