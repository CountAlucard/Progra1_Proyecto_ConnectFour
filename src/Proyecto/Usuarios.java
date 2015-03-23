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
public class Usuarios 
{    
    public Player players[];  
    private int contador = 0;
    
    public Usuarios(){
        players = new Player[20];
    }
    
    public void print()
    {
        for(int i=0;i<contador; i++){
            if(players[i].getUsuario() != null)
            players[i].Print();
        }
    }
    
    public void printCurrent(String user)
    {
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(user) && players[c].getUsuario() != null){
                players[c].Print();
            }
        }
    }
    
    public void Ranking()
    {        
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario() != null)
            System.out.println("\nNombre: "+players[c].getNombre()+"\tScore: "+players[c].getScore()+"");
        }
        
    }
    
    public void eliminarCuenta(String user)
    {
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(user)){
                players[c] = new Player("","","",0);
                contador--;
            }
        }
    }
    
    public Player searchPlayer(String user) {
        for (int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(user))
                return players[c];
        }
        return null;
    }
    
    public boolean exist(String user) {
        for (int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(user)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existPass(String pass) {
        for (int c = 0; c < contador; c++){
            if(players[c].getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public boolean crear(String nom, String usu, String pass, int score){
        if( contador < players.length ){
            //todavia hay cupo
            if( searchPlayer(usu) == null ){                
                    players[contador] = new Player(nom, usu, pass, score);
                    contador++;
                    return true;
            }            
        }
        
        return false;
    }
    
    public void setScoreFor(String nom, int newScore)
    {
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(nom)){
                players[c].setScore(newScore);
            }
        }
    }
    
    public void setNameFor (String nom, String nomb)
    {
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(nom)){
                players[c].setNombre(nomb);
            }
        }
    }
    
    public void setUserFor (String nom, String us)
    {
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(nom)){
                players[c].setUsuario(us);
            }
        }        
    }
   
   
    public void setPasswordFor (String nom, String pw)
    {
        for(int c = 0; c < contador; c++){
            if(players[c].getUsuario().equals(nom)){
                players[c].setPassword(pw);
            }
        }
    }
    
    
}
