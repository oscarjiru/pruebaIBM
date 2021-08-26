package prueba;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public String driver = "com.mysql.jdbc.Driver";
    public String database = "database";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    public String username = "root";
    public String password = "123456789";

    public Connection conectarMySQL() throws IOException {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            
            String sql = "SELECT * FROM proveedores WHERE id_proveedor = 1";
        	
        	Statement  st = con.createStatement();
        	ResultSet rs = st.executeQuery(sql);
        	
        	if (rs.equals(null)) {
				System.out.println("El cliente no tiene proveedores asignados");
			}
        	
        	File fichero = new File ("C:\\Users\\ojimenezr\\Escritorio\\fichero.txt");
        	
        	if (!fichero.exists()) {
        		fichero.createNewFile();
            }
        	
        	FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(rs.getString("id_proveedor") +", " +
					rs.getString("nombre")+ ", " +
					rs.getString("fecha_alta")+ ", " +
					rs.getString("id_cliente"));
            
  	
        	while (rs.next()) {
        		bw.write(rs.getString("id_proveedor") +", " +
    					rs.getString("nombre")+ ", " +
    					rs.getString("fecha_alta")+ ", " +
    					rs.getString("id_cliente"));
        	}
        	
        	bw.close();
        	rs.close();
        	st.close();

        	
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

}