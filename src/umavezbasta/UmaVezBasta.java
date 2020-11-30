package umavezbasta;


import java.util.Scanner;

import umavezbasta.relatos;
import umavezbasta.cadastro;
import umavezbasta.login;
import umavezbasta.verRelatos;

public class UmaVezBasta {
     static Scanner reader = new Scanner(System.in);
       
    
    static String resp;
    
    public static void main(String[] args) {
        homePage();
    }

    static void homePage() {
        System.out.println("Bem-Vindo(a) ao serviço de de denuncia Uma Vez Basta\n\n Para continuar selecione uma das opções:"
                + "\n[1] Cadastrar\n[2] Login\n[3] Denunciar\n[4] Ver Relatos\n[5] Loja");
        
        resp = reader.next();
        
        switch(resp){
            case "1":
                cadastro.cadastro();
                break;
            case "2":
                login.login();
                break;
            case "3":
                relatos.denuncia();
                break;
            case "4":
                verRelatos.verRelatos();
            case "5":
                //loja();
                break;
            default:
                homePage();
                break;
        }
    }
}
