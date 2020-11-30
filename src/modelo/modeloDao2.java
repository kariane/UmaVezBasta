package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//ou import java.sql.*;(para importar tudo da api)
import java.util.ArrayList;
import java.util.List;

public class modeloDao2 {
    private final String usuario="root";
    private final String senha="";
    private final String url="jdbc:mysql://localhost:3306/relatos.bd";
    private Connection con=null;
    private PreparedStatement st;
    private ResultSet rs;

   public Connection iniciar() throws SQLException{
       return con=DriverManager.getConnection(url,usuario,senha);
   }
   public void inserir(modelo modelo,Connection con) throws SQLException{
       try{
       String sql="INSERT INTO relatos(nome_relator, relato, regiao_relato) VALUES(?,?,?)";
       st=con.prepareStatement(sql);
       st.setString(1, modelo.getNome_relator());
       st.setString(2, modelo.getRelato());
       st.setString(3, modelo.getRegiao_relato());
       st.executeUpdate();
       System.out.println("Inserido com sucesso");
       }finally{
           con.close();
           st.close();
       }
   }
   
   public List<modelo> listar(Connection con) throws SQLException{
       List<modelo> lista=new ArrayList<>();
       
       try{
          String sql="SELECT * FROM relato ORDER BY nome_relator";
          st=con.prepareStatement(sql);
          rs=st.executeQuery();
          
          modelo modelo;
          while(rs.next()){
            modelo=new modelo();
           modelo.setId_relato(rs.getInt("id_relato"));
           modelo.setNome_relator(rs.getString("nome_relator"));
           modelo.setRelato(rs.getString("relato"));
           modelo.setRegiao_relato(rs.getString("regiao_relato"));
           lista.add(modelo);
       }
       }finally{
            con.close();
           st.close();
       }
       return lista;
   }
}
