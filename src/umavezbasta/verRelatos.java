package umavezbasta;

import java.util.Scanner;
import umavezbasta.UmaVezBasta;
public class verRelatos {
     static Scanner reader = new Scanner(System.in);
     static String resp;
      static void verRelatos(){
        //exibirRelatos();
        System.out.println("Para voltar digite voltar.");
        resp = reader.nextLine(); 
        
        if (resp != null) {
            UmaVezBasta.homePage();
        }else{
            
        }
    }
}
