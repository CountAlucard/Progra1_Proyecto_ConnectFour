package Proyecto;

import java.util.Scanner;

public class ConnectFour {
    Usuarios user = new Usuarios();  
    
    
    Scanner lea = new Scanner(System.in);
    boolean seguir = true, login = true, mprin = true, profile = true, crear = true, play = true, game = true, loop = true;    
    String user1, pass,re, user2, seguro, retiro;
    int opcion, count = 0, score, score1, score2;
    
    
    public void MainMenu()
    {       
        do{ 
            System.out.println("\n\tCONNECT FOUR: THE GAME\n");
            System.out.println("Log In (1)");
            System.out.println("Crear Usuario (2)");
            System.out.println("Imprimir usuarios (3)");
            System.out.println("Exit (4)");

            int resp = lea.nextInt();

            System.out.println();


            switch(resp){
                case 1:
                    LogIn();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    user.print();
                    break;
                case 4:
                    seguir = false;
                    break;

            }
        }while(seguir);
        
    }
    
    //Funcion para ingresar con el usuario al juego.
    public void LogIn()
    {        
        do{
            System.out.println("\tWELCOME TO CONNECT FOUR\n\t\tLOGIN");
            System.out.print("\nUSERNAME: ");

            for(int i = 0; i < 1; i++){
                user1 = lea.next();

                if(user.searchPlayer(user1) != null){
                    System.out.print("\nPASSWORD: ");
                    pass = lea.next();
                    if(user.existPass(pass)){
                        do{
                            loginMenu();
                        }while(mprin);                      
                        break;
                    }
                    else if(!(user.existPass(pass))){
                        System.out.println("\nPassword incorrecta.");
                        i--;
                        break;
                    }
                }
                else{
                    System.out.print("\nUsuario no registrado.");
                    login = false;
                    break;
                }
            }
        }while(login);
        
    }
    
    //Funcion para crear un nuevo usuario.
    public void createUser()
    {        
        
        System.out.println("\tWELCOME TO CONNECT FOUR\n\t\tCREATE USER");
        System.out.println();					

        do{           
            System.out.println("Ingrese su nombre");
            lea.useDelimiter("\n");
            String nom = lea.next();
            System.out.println("Ingrese nombre de usuario: ");
            String usu = lea.next();
            System.out.println("Ingrese su password: ");
            String pass = lea.next();
            score = 0;
            
            if(user.crear(nom, usu, pass, score)){
                System.out.println("Usuario creado con exito! ");
            }
            else{
                System.out.println("El usuario ya existe! ");
            }

            System.out.println();

            this.crear = false;
            break;
            
        }while(crear);
        
        seguir = true;
    }
    
    //Menu del juego.
    public void loginMenu()
    {             
            System.out.println("\n\tCONNECT FOUR: THE GAME\n\t\tMAIN MENU");
            System.out.println("Jugar Connect Four (1)");
            System.out.println("Ranking (2)");
            System.out.println("My Profile (3)");
            System.out.println("Log Out (4)");

            this.opcion = lea.nextInt();
            System.out.println();
            
            switch(opcion){
                case 1:
                    Jugar();
                    break;
                case 2:
                    Ranking();
                    break;
                case 3:
                    MyProfile();
                    break;
                case 4:
                    login = false;
                    mprin = false;
                    break;
            }        
        
    }
    
    //Juego de Connect Four.
    public void Jugar()
    {   
        System.out.println("Player 1: "+user1);
        
        do{ //SE PIDE INGRESAR EL PLAYER 2 DEL TECLADO
            System.out.println("Ingrese usuario contrincante: ");
            
            for(int z = 0; z < 1; z++){
                user2 = lea.next();

                if(user.exist(user2)){
                    System.out.println("Player 2: "+user2);
                    System.out.println();
                    String[][] f = createPattern();
                    loop = true;
                    game = true;
                    count = 0;

                    do{
                        do{
                            printPattern(f);
                            if (count % 2 == 0) {
                                dropRedPattern(f);
                                RetirarP1();
                            }
                            
                            else {
                                dropYellowPattern(f);
                                RetirarP2();
                            }
                            count++;                                      
                            if (checkWinner(f) != null)
                            {
                               if (checkWinner(f) == "R"){
                                  printPattern(f);
                                  System.out.println("Payer1("+ user1 +") ha ganado, +10 puntos.");                                 
                                  score1 += score + 10;
                                  user.setScoreFor(user1, score1);
                                  
                               }
                               else if (checkWinner(f)== "Y"){
                                  printPattern(f);
                                  System.out.println("Player2("+ user2 +") ha ganado, +10 puntos.");       
                                  score2 = score + 10;
                                  user.setScoreFor(user2, score2);
                               }                                                                                     
                                loop = false;
                                play = false;

                             }

                        }while(loop);

                        game = false;

                    }while(game);                                
                    break;
                }
                else{
                    System.out.println("Usuario no encontrado. Intente de nuevo.");
                    z--;
                    break;
                }
            }
        }while(play);
                    
    }
    
    //Funcion para que se retire el player1.
    public void RetirarP1()
    {
       System.out.println("Desea retirarse?");
        retiro = lea.next();
        if(retiro.equalsIgnoreCase("si")) {
            System.out.println("Player2("+user2+") ha ganado por forfeit +10 puntos");
            score2 += score + 10;
            user.setScoreFor(user2, score2);
            loop = false;
            play = false;
        }
    }
    
    //Funcion para que se retire el player2.
    public void RetirarP2()
    {
        System.out.println("Desea retirarse?");
        retiro = lea.next();
        if(retiro.equalsIgnoreCase("si")) {
            System.out.println("Player1("+user1+") ha ganado por forfeit +10 puntos");
            score1 += score + 10;
            user.setScoreFor(user1, score1);
            loop = false;
            play = false;
        }
    }
    
    //Sistema de ranking.
    public void Ranking()
    {
        System.out.println("\n\tCONNECT FOUR: THE GAME\n\t\tRANKING");
        user.Ranking();
    }
    
    //Ver mis datos, aqui el usuario puede editar sus datos del perfil, ver sus partidas y eliminar la cuenta.
    public void MyProfile()
    {                
        System.out.println("\n\tCONNECT FOUR: THE GAME\n\t\tMY PROFILE");
        MisDatos();
        System.out.println("\nEditar mi perfil (1)");
        System.out.println("Ver mis ultimas partidas (2)");
        System.out.println("Eliminar Cuenta! (3)");
        int profile = lea.nextInt();
        
        switch(profile){
            case 1:
                EditarDatos();
                break;
            case 2:
                break;
            case 3:     
                EliminarCuenta();
                mprin = false;
                login = false;
                break;
                                 
        }                
                      
        
    }
    
    //Funcion para imprimir en pantalla el Nombre, Usuario, Password y Score.
    public void MisDatos()
    {
        user.printCurrent(user1);        
    }
    
    //Funcion para editar los datos del usuario.
    public void EditarDatos()
    {
        System.out.println("\nEditar nombre (1)");
        System.out.println("Editar usuario (2)");
        System.out.println("Editar password (3)");
        System.out.println("Regresar a Mi Perfil (4)");
        int datos = lea.nextInt();
        
        switch(datos){
            case 1:                
                user.setNameFor(user1,lea.next());                
                break;
            case 2:
                user.setUserFor(user1, lea.next());                
                break;
            case 3:
                user.setPasswordFor(user1,lea.next());                
                break;
            case 4:
                break;
        }
        
    }
    
    public void EliminarCuenta()
    {
        System.out.println("Seguro que desea eliminar esta cuenta? ");
        String seguro = lea.next();
        
        if(seguro.equalsIgnoreCase("si")){
            user.eliminarCuenta(user1);
            System.out.println("La cuenta ha sido eliminado con exito! ");
        }
    }
    
    //Funcion para crear el Tablero de Connect Four.
    public static String[][] createPattern()
  {

    String[][] f = new String[7][15];

    for (int i =0;i<f.length;i++)
    {
       for (int j =0;j<f[i].length;j++)
      {
        if (j% 2 == 0) f[i][j] ="|";
        else f[i][j] = " ";
        
        
        if (i==6) f[i][j]= "-";
      }
       
    }
    return f;
  }
   
    //Funcion para imprimir el Tablero en pantalla.
  public static void printPattern(String[][] f)
  {
    for (int i =0;i<f.length;i++)
    {
      for (int j=0;j<f[i].length;j++)
      {
        System.out.print(f[i][j]);
      }
      System.out.println();
    }
  }
   
  //Con el siguiente codigo establecemos los movimientos de la ficha roja (el primer player).
  public static void dropRedPattern(String[][] f)
  {
    System.out.println("Player1 coloque una ficha roja en la columna (0–6): ");
    Scanner scan = new Scanner (System.in);     

    int c = 2*scan.nextInt()+1;
    
    for (int i =5;i>=0;i--)
    {
      if (f[i][c] == " ")
      {
        f[i][c] = "R";
        break;
      }
       
    }
  }
   
  //Con el siguiente codigo establecemos los movimientos de la ficha amarilla (el segundo player).
  public static void dropYellowPattern(String[][] f)
  {
    System.out.println("Player2 coloque una ficha amarilla en la columna (0–6): ");
    Scanner scan = new Scanner (System.in);
    int c = 2*scan.nextInt()+1;
    for (int i =5;i>=0;i--)
    {
      if (f[i][c] == " ")
      {
        f[i][c] = "Y";
        break;
      }
       
    }
  }

  //Con el siguiente codigo se corrobora el ganador de forma diagonal, vertical y horizontal.
  public static String checkWinner(String[][] f)
  {
      
    //Para verificar una linea horizontal.
    for (int i =0;i<6;i++)
    {
      for (int j=0;j<7;j+=2)
      {
        if ((f[i][j+1] != " ")
        && (f[i][j+3] != " ")
        && (f[i][j+5] != " ")
        && (f[i][j+7] != " ")
        && ((f[i][j+1] == f[i][j+3])
        && (f[i][j+3] == f[i][j+5])
        && (f[i][j+5] == f[i][j+7])))
 
        //Si se encuentra un patron con el mismo color,
        //se retornara el color para saber quien gano.
          return f[i][j+1];  
      }
    }
     
    //Para verificar en una linea vertical    
    for (int i=1;i<15;i+=2)
    {
      for (int j =0;j<3;j++)
      {
            if((f[j][i] != " ")
            && (f[j+1][i] != " ")
            && (f[j+2][i] != " ")
            && (f[j+3][i] != " ")
            && ((f[j][i] == f[j+1][i])
            && (f[j+1][i] == f[j+2][i])
            && (f[j+2][i] == f[j+3][i])))
              return f[j][i];  
      }  
    }
     
    //Para la linea diagonal de la columna superior izquierda 
    //hasta la fila inferior derecha
    //Tendremos que recorrer las 3 filas superiores
    //y luego ir de izquierda a derecha con respecto a las columnas.
    for (int i=0;i<3;i++)
    {
       
      for (int j=1;j<9;j+=2)
      {
            if((f[i][j] != " ")
            && (f[i+1][j+2] != " ")
            && (f[i+2][j+4] != " ")
            && (f[i+3][j+6] != " ")
            && ((f[i][j] == f[i+1][j+2])
            && (f[i+1][j+2] == f[i+2][j+4])
            && (f[i+2][j+4] == f[i+3][j+6])))
              return f[i][j];  
      }  
    }
     
    //Similar con el metodo diagonal anterior, solo que esta vez
    //la trayectoria sera al revez, empezando desde la columna superior derecha.
    
    for (int i=0;i<3;i++)
    {
      for (int j=7;j<15;j+=2)
      {
            if((f[i][j] != " ")
            && (f[i+1][j-2] != " ")
            && (f[i+2][j-4] != " ")
            && (f[i+3][j-6] != " ")
            && ((f[i][j] == f[i+1][j-2])
            && (f[i+1][j-2] == f[i+2][j-4])
            && (f[i+2][j-4] == f[i+3][j-6])))
              return f[i][j];  
      }  
    }
     
    //Si despues de recorrer todo el Tablero no encontramos a un ganadro,
    //hay que retornar algo que nos indique que no hay ganador.
    return null;
  }
  

}
