/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author rolo_
 */
import org.springframework.jdbc.datasource.DriverManagerDataSource;
public class Conexion {
    public DriverManagerDataSource Conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.47:3306/correos");
        dataSource.setUsername("conrapida");
        dataSource.setPassword("rolo1355");
       
        
        return dataSource;
    }
}
