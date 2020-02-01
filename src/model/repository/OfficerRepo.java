package model.repository;

import model.entity.OfficerEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OfficerRepo implements AutoCloseable {

    private PreparedStatement preparedStatement ;
    private Connection connection;
    public OfficerRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void create_officer()throws Exception{
        preparedStatement=connection.prepareStatement("CREATE  TABLE officer(name varchar2(30) ,code varchar2(20) ,password varchar2(30))");
        preparedStatement.executeUpdate();
        connection.commit();
        preparedStatement=connection.prepareStatement("INSERT INTO officer(name,code,password)values(?,?,?)");
        preparedStatement.setString(1,"alirahimi");
        preparedStatement.setString(2,"1232");
        preparedStatement.setString(3,"1111");
        preparedStatement.executeUpdate();
        connection.commit();
        ////2
        preparedStatement=connection.prepareStatement("INSERT INTO officer(name,code,password)values(?,?,?)");
        preparedStatement.setString(1,"mohsenkheyri");
        preparedStatement.setString(2,"1078");
        preparedStatement.setString(3,"1234");
        preparedStatement.executeUpdate();
        connection.commit();
        ////3
        preparedStatement=connection.prepareStatement("INSERT INTO officer(name,code,password)values(?,?,?)");
        preparedStatement.setString(1,"sinamoradi");
        preparedStatement.setString(2,"8912");
        preparedStatement.setString(3,"sina1234");
        preparedStatement.executeUpdate();
        connection.commit();
        ////4
        preparedStatement=connection.prepareStatement("INSERT INTO officer(name,code,password)values(?,?,?)");
        preparedStatement.setString(1,"rezakarimi ");
        preparedStatement.setString(2,"9876");
        preparedStatement.setString(3,"1234");
        preparedStatement.executeUpdate();
        connection.commit();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<OfficerEntity> Officer_select()throws Exception {
        preparedStatement = connection.prepareStatement("select * from officer");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<OfficerEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            OfficerEntity o = new OfficerEntity();
            o.setName(resultSet.getString("name"));
            o.setCode(resultSet.getString("code"));
            o.setPassword(resultSet.getString("password"));
            list.add(o);
        }
        return list;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
    //////////////////////////////////////////////////////////////////////////////
    public void commite()throws Exception{
        connection.commit();
    }
}
