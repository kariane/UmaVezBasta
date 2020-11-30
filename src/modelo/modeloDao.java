package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//ou import java.sql.*;(para importar tudo da api)
import java.util.ArrayList;
import java.util.List;

public class modeloDao {
    private final String usuario="root";
    private final String senha="";
    private final String url="jdbc:mysql://localhost:3306/cliente.bd";
    private Connection con=null;
    private PreparedStatement st;
    private ResultSet rs;

   public Connection iniciar() throws SQLException{
       return con=DriverManager.getConnection(url,usuario,senha);
   }
   public void inserir(modelo modelo,Connection con) throws SQLException{
       try{
       String sql="INSERT INTO cliente2(nome,sobrenome, email,telefone, senha) VALUES(?,?,?,?,?)";
       st=con.prepareStatement(sql);
       st.setString(1, modelo.getNome());
       st.setString(2, modelo.getSobrenome());
       st.setString(3, modelo.getEmail());
       st.setString(4, modelo.getTelefone());
       st.setString(5, modelo.getSenha());
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
          String sql="SELECT * FROM modelo ORDER BY nome";
          st=con.prepareStatement(sql);
          rs=st.executeQuery();
          
          modelo modelo;
          while(rs.next()){
            modelo=new modelo();
           modelo.setId(rs.getInt("id"));
           modelo.setNome(rs.getString("nome"));
           modelo.setNome(rs.getString("sobrenome"));
           modelo.setEmail(rs.getString("email"));
           modelo.setTelefone(rs.getString("telefone"));
           modelo.setSenha(rs.getString("senha"));
           lista.add(modelo);
       }
       }finally{
            con.close();
           st.close();
       }
       return lista;
   }
}
