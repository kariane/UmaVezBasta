package umavezbasta;

import java.util.Scanner;
import modelo.modelo;
import modelo.modeloDao;
public class login {
    static Scanner reader = new Scanner(System.in);
    static modelo modelo=new modelo();
    static modeloDao Dao=new modeloDao();
    static String resp, email,senha;
    static void login(){
        System.out.println("Digite o email cadastrado:");
        email = reader.nextLine();
        
        System.out.println("Digite a senha:");
        senha = reader.nextLine();
        
        if (email != null && senha != null) {
            //usuarioLogin();
        }else{
            login();
        }
    }
}
