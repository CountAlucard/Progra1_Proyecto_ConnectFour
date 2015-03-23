import java.util.*;

public class MainMenu{
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);

        String user, pass, nombre, user2, answer, re;

        //Arreglo para los usuarios
        String usuarios[] = {"-","-","-","-","-","-","-","-","-","-",};
        String[][] f = new String[7][15];
        int cantidad = usuarios.length;
        boolean seguir = true, login = true, mprin = true, profile = true, crear = true, play = true, game = true, ranking = true, player1 = true, player2 = true;


        do{
            //WELCOME TO CONNECT FOUR
            System.out.println("\tCONNECT FOUR: THE GAME\n");

            System.out.println("Log In (1)");
            System.out.println("Crear Usuario (2)");
            System.out.println("Exit (3)");

            int resp = lea.nextInt();

            System.out.println();

            switch(resp){
                    //LOGIN SCREEN------------------------------------------------
                    case 1:
                            System.out.println("\tWELCOME TO CONNECT FOUR\n\t\tLOGIN");

                            do{
                                    System.out.print("\nUSERNAME: ");
                                    user = " ";	

                                    for(int i = 0; i < 1; i++){
                                            user = lea.next();

                                            if(Arrays.asList(usuarios).contains(user)){
                                                    System.out.print("\nPASSWORD: ");
                                                    pass = lea.next();
                                                    if(pass.equalsIgnoreCase("honduras")){
                                                            login = false;
                                                            break;
                                                    }
                                                    else{
                                                            System.out.println("\nPassword incorrecta.");
                                                            i--;
                                                            break;
                                                    }
                                            }
                                            else{
                                                    System.out.print("\nUsuario no registrado.");
                                                    i--;
                                                    break;
                                            }
                                    }
                            }while(login);

                            System.out.println();

                            //MENU PRINCIPAL-----------------------------------------------------
                            do{

                                    System.out.println("\tCONNECT FOUR: THE GAME\n\t\tMAIN MENU");
                                    System.out.println("Jugar Connect Four (1)");
                                    System.out.println("Ranking (2)");
                                    System.out.println("My Profile (3)");
                                    System.out.println("Log Out (4)");

                                    int opcion = lea.nextInt();
                                    System.out.println();

                                    switch(opcion){
                                            case 1:
                                                            System.out.println("Player 1: "+user);
                                                    do{ //SE PIDE INGRESAR EL PLAYER 2 DEL TECLADO
                                                            System.out.println("Ingrese usuario contrincante: ");

                                                            for(int z = 0; z < 1; z++){
                                                                    user2 = lea.next();

                                                                    if(Arrays.asList(usuarios).contains(user2)){
                                                                            System.out.println("Player 2: "+user2);
                                                                            System.out.println();

                                                                        for (int i =0;i<f.length;i++){  
                                                                           for (int j =0;j<f[i].length;j++){
                                                                            if (j% 2 == 0){
                                                                                    f[i][j] ="|";
                                                                            }
                                                                            else{
                                                                                    f[i][j] = " ";	
                                                                            } 
                                                                            if (i==6) {
                                                                                    f[i][j]= "-";
                                                                            }
                                                                          }
                                                                        }

                                                                        for (int i =0;i<f.length;i++){
                                                                          for (int j=0;j<f[i].length;j++){
                                                                            System.out.print(f[i][j]);
                                                                          }
                                                                          System.out.println();
                                                                        }

                                                                        do{
                                                                                        do{
                                                                                                                 //We need to have the user tell us what column he wants
                                                                                                                //to drop a red into
                                                                                                                //Note: the user isn't supposed to know that we have 15 columns
                                                                                                                //starting at index 0 till 14 but just 6 nice ones
                                                                                                                System.out.println("Player1 coloque un disco rojo en la columna (0 to 6): ");

                                                                                                                //Thankfully, there's a simple formula for converting a 1-2-3-4-5-6 
                                                                                                                //user column number into a 1-3-5-7-9-11-13
                                                                                                                int c = 2*lea.nextInt()+1;

                                                                                                                //Now that we know our column, we have to loop
                                                                                                                //over each row from the bottom to the top
                                                                                                                //till we find the first  empty space, drop, and
                                                                                                                //then finish (i.e., break) the move
                                                                                                                //Note: although as coders we're used to starting from 
                                                                                                                //0 to the end, here that wouldn't work so well because
                                                                                                                //it would involve multiple if statements, but try it out
                                                                                                                //on your own if you want to
                                                                                                                for (int i =5;i>=0;i--){
                                                                                                                  if (f[i][c] == " "){
                                                                                                                    f[i][c] = "R";
                                                                                                                    break;
                                                                                                                  }  
                                                                                                                }
                                                                                                                for (int i =0;i<f.length;i++){
                                                                                                                  for (int j=0;j<f[i].length;j++){
                                                                                                                    System.out.print(f[i][j]);
                                                                                                                  }
                                                                                                                  System.out.println();
                                                                                                                }

                                                                                                                player1 = false;
                                                                                                                player2 = true;

                                                                                            }while(player1);

                                                                                            do{
                                                                                                            System.out.println("Player2 coloque un disco amarillo en la columna (0 to 6): ");
                                                                                                        int c = 2*lea.nextInt()+1;
                                                                                                        for (int i =5;i>=0;i--){
                                                                                                          if (f[i][c] == " "){
                                                                                                            f[i][c] = "Y";
                                                                                                            break;
                                                                                                          }						       
                                                                                                        }
                                                                                                         for (int i =0;i<f.length;i++){
                                                                                                                for (int j=0;j<f[i].length;j++){
                                                                                                                        System.out.print(f[i][j]);
                                                                                                                }
                                                                                                                System.out.println();
                                                                                                        }
                                                                                                        player2 = false;
                                                                                                        player1 = true;
                                                                                                        break;

                                                                                            }while(player2);
                                                                            }while(game);

                                                                            mprin = false;
                                                                            break;
                                                                    }
                                                                    else{
                                                                            System.out.println("\nUsuario no encontrado. Intente de nuevo.");
                                                                            z--;
                                                                            break;
                                                                    }
                                                            }

                                                    }while(play);

                                                    mprin = true;
                                                    break;

                                            case 2: //AQUI TENEMOS EL RANKING DE LOS USUARIOS
                                                    do{
                                                            System.out.println("\nUsuario\t\tHighscore");
                                                            for(String l : usuarios){
                                                                    System.out.println(l +" "+"\t\t1000" );
                                                            }


                                                            System.out.println("Desea regresar al menu principal? ");
                                                            String tex = lea.next();
                                                            if(tex.equalsIgnoreCase("si")){
                                                                    mprin = true;
                                                                    ranking = false;
                                                                    break;
                                                            }
                                                            else if(tex.equalsIgnoreCase("no")){
                                                                    ranking=true;
                                                            }
                                                    }while(ranking);

                                                    break;

                                            case 3:
                                                    do{
                                                            System.out.println();
                                                            System.out.println("\t\tMy Profile");
                                                            System.out.println("Nombre de Usuario: "+user);
                                                            System.out.println("Victorias: "+5);
                                                            System.out.println();

                                                            System.out.println("Desea regresar al menu principal? ");
                                                            String texto = lea.next();
                                                            if(texto.equalsIgnoreCase("si")){
                                                                    mprin = true;
                                                                    profile = false;
                                                                    break;
                                                            }
                                                    }while(profile);

                                                    break;
                                            case 4:
                                                    mprin = false;

                                                    break;
                                    }

                            }while(mprin);

                            System.out.println();
                            break;

                    //CREATE USER------------------------------------------------
                    case 2:
                            System.out.println("\tWELCOME TO CONNECT FOUR\n\t\tCREATE USER");
                            System.out.println();					

                            do{
                                    for(int i = 0; i < cantidad; i++){
                                            if(usuarios[i] == "-"){
                                                    System.out.print("\nIngrese su usuario: ");
                                                    usuarios[i] = lea.next();

                                                    if(i >= 1){
                                                            for(int c = 0; c < i; c++){
                                                                    if(usuarios[i].equalsIgnoreCase(usuarios[c])){
                                                                            System.out.println("El usuario ya existe.");
                                                                            i--;
                                                                            break;
                                                                    }
                                                            }
                                                            if( i < cantidad - 1){
                                                            System.out.println("\nDesea ingresar otro usuario? ");
                                                            re = lea.next();

                                                                    if(re.equalsIgnoreCase("no")){
                                                                            crear = false;
                                                                            break;
                                                                    }
                                                            }
                                                    }

                                                    if ( i == 0){
                                                    System.out.println("\nDesea ingresar otro usuario? ");
                                                    re = lea.next();

                                                            if(re.equalsIgnoreCase("no")){
                                                                    crear = false;
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }

                                    System.out.println();

                                    crear = false;
                            }while(crear);

                            seguir = true;
                            break;


                    //EXIT-------------------------------------------------------
                    case 3:
                            seguir = false;
                            break;

            }
        }while(seguir);

    }
}