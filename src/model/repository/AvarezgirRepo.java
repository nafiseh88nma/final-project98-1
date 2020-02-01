package model.repository;

import model.entity.AvarezgirEntity;
import model.entity.CarEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AvarezgirRepo  implements  AutoCloseable{

    private PreparedStatement preparedStatement ;
    private Connection connection;
    public AvarezgirRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void create_Avarezgir()throws Exception{
        preparedStatement=connection.prepareStatement("CREATE  TABLE Avarezgir(name varchar2(30),password varchar2(30))");
        preparedStatement.executeUpdate();
        connection.commit();

        preparedStatement=connection.prepareStatement("INSERT INTO Avarezgir(name,password)values(?,?)");
        preparedStatement.setString(1,"asgharrad");
        preparedStatement.setString(2,"asghar1212");
        preparedStatement.executeUpdate();
        connection.commit();
        ////2
        preparedStatement=connection.prepareStatement("INSERT INTO Avarezgir(name,password)values(?,?)");
        preparedStatement.setString(1,"alirajaee");
        preparedStatement.setString(2,"ali54345");
        preparedStatement.executeUpdate();
        connection.commit();
        ////3
        preparedStatement=connection.prepareStatement("INSERT INTO Avarezgir(name,password)values(?,?)");
        preparedStatement.setString(1,"mohsensaeedi");
        preparedStatement.setString(2,"091232432");
        preparedStatement.executeUpdate();
        connection.commit();
        ////4
        preparedStatement=connection.prepareStatement("INSERT INTO Avarezgir(name,password)values(?,?)");
        preparedStatement.setString(1,"soheylalizadeh");
        preparedStatement.setString(2,"soheyia");
        preparedStatement.executeUpdate();
        connection.commit();
    }
    //////////////////////////////////////////////////Select////////////////////////////////////////////////////////
    public ArrayList<AvarezgirEntity> Avarezgir_select()throws Exception{
        preparedStatement=connection.prepareStatement("select * from Avarezgir");
        ResultSet resultSet =preparedStatement.executeQuery();
        ArrayList<AvarezgirEntity> list = new ArrayList<>();
        while (resultSet.next()){
            AvarezgirEntity c = new AvarezgirEntity();
            c.setName(resultSet.getString("name"));
            c.setPassword(resultSet.getString("password"));
            list.add(c);
        }
        return list;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void commite()throws Exception{
        connection.commit();
    }
}
