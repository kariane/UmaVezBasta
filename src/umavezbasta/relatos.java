
package umavezbasta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import modelo.modelo;

import modelo.modeloDao2;
import umavezbasta.UmaVezBasta;

public class relatos {
    static Scanner reader = new Scanner(System.in);
    static modelo modelo=new modelo();
    static modeloDao2 Dao2=new modeloDao2();
    
    
    static String nome, resp, relato, regiao;
    static int cep;
    static void denuncia(){
     System.out.println("Escreva seu relato abaixo.");
        relato = reader.next();
        
        System.out.println("Deseja se manter anonima(o)?\n[sim/não]");
        resp = reader.next();
        
        if (resp.equalsIgnoreCase("sim")){
           nome = null; 
            System.out.println("Digite a região de São Paulo onde ocorreu:\n[norte/oeste/sul/leste/centro]");
        regiao = reader.next();
        
        System.out.println("Confira as informações antes de salva-las:\n RELATO: " + relato +"\nREGIÃO:"+ regiao+ "\nConfirma as informações?\n[sim/não]");
        resp = reader.next();
        if (resp.equalsIgnoreCase("sim")) {
            System.out.println("Relato salvo!");
            //cadastraRelato();
        }else{
            denuncia();
        }
        
        System.out.println("Deseja deixar esse comentário visivel para insentivar outras pessoas a denuciar?\n[sim/não]");
        resp = reader.next();
        
        if (resp.equalsIgnoreCase("sim")) {
            //adicionarRelato();
            System.out.println("Agradecemos seu relato e sentimos muito pelo que aconteceu!");
            UmaVezBasta.homePage();
        }else if(resp.equalsIgnoreCase("não")){
            System.out.println("Agradecemos seu relato e sentimos muito pelo que aconteceu!");
           UmaVezBasta.homePage();
        } 
        else{
            System.out.println("informação incorreta");
             UmaVezBasta.homePage();
        }
         }

        else{
            System.out.println("Digite seu nome:");
            nome = reader.next();
             System.out.println("Digite a região de São Paulo onde ocorreu:\n[norte/oeste/sul/leste/centro]");
        regiao = reader.next();
        
        System.out.println("Confira as informações antes de salva-las:\n RELATO: " + relato + "\nNOME: "+nome+"\nREGIÃO:"+ regiao+"\nConfirma as informações?\n[sim/não]");
        resp = reader.next();
        if (resp.equalsIgnoreCase("sim")) {
            System.out.println("Relato salvo!");
            //cadastraRelato();
        }else{
            denuncia();
        }
        
        System.out.println("Deseja deixar esse comentário visivel para insentivar outras pessoas a denuciar?\n[sim/não]");
        resp = reader.next();
        
        if (resp.equalsIgnoreCase("sim")) {
            //adicionarRelato();
            System.out.println("Agradecemos seu relato e sentimos muito pelo que aconteceu!");
            UmaVezBasta.homePage();
        }else{
            System.out.println("Agradecemos seu relato e sentimos muito pelo que aconteceu!");
           UmaVezBasta.homePage();
        }
    }
        modelo.setNome_relator(nome);
        modelo.setRelato(relato);
        modelo.setRegiao_relato(regiao);
       try{
            Connection con=Dao2.iniciar();
            System.out.println("Conectado");
            Dao2.inserir(modelo, con);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }       
}
