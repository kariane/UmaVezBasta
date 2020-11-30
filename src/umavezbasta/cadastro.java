package umavezbasta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import modelo.modelo;
import modelo.modeloDao;
import umavezbasta.UmaVezBasta;

public class cadastro {
    static Scanner reader = new Scanner(System.in);
    static modelo modelo=new modelo();
    static modeloDao Dao=new modeloDao();
    static String resp, nome, sobrenome, email, telefone, senha;
  
  static void cadastro(){
    
        System.out.println("Digite as informações pedidas para fazer o cadastro.\n");
        System.out.print("Primeiro nome:");
        nome = reader.next();
        System.out.print("Sobrenome:");
        sobrenome = reader.next();
        System.out.print("Telefone(9********):");
        telefone = reader.next();
        System.out.print("Email:");
        email = reader.next();
        System.out.print("Defina uma senha:");
        senha =reader.next();
         modelo.setNome(nome);
         modelo.setSobrenome(sobrenome);
         modelo.setTelefone(telefone);
         modelo.setEmail(email);
         modelo.setSenha(senha);
          try{
            Connection con=Dao.iniciar();
            System.out.println("Conectado");
            Dao.inserir(modelo, con);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if (nome != null && sobrenome != null && telefone != null && email != null && senha != null) {
            System.out.println("========================================\n"
                    + "Nome:" + nome + "\nSobrenome:" + sobrenome + "\nTelefone:" + telefone +
                    "\nEmail:" + email + "\nSenha:" + senha);
            System.out.println("Confirma?[sim/nao]");
            resp=reader.next();
            if (resp.equalsIgnoreCase("sim")) {
                //cadastraUsuario();
                System.out.println("Usuário cadastrado");
                UmaVezBasta.homePage();
            }else if (resp.equalsIgnoreCase("não")){
                cadastro();
            }else{
                 System.out.println("informação incorreta");
                UmaVezBasta.homePage();
            }
        }else{
            System.out.println("Você não preencheu todas as informações.");
            cadastro();
        }
    }  
}
