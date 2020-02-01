package model.repository;


import model.entity.Enteration_officerEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Enteration_officerRepo implements AutoCloseable {

    private PreparedStatement preparedStatement ;
    private Connection connection;
    public Enteration_officerRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }


    public void create_enteration_officer()throws Exception{
        preparedStatement=connection.prepareStatement("create table enteration( nam varchar2(30) , code varchar2(20) , tim varchar2(30) , servcode varchar2(20) , servname varchar2(30))");
        preparedStatement.executeUpdate();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void insert_interationoffocer(Enteration_officerEntity E)throws Exception{
        preparedStatement=connection.prepareStatement("insert into enteration(nam,code,tim,servcode,servname)values(?,?,?,?,?)");
        preparedStatement.setString(1,E.getName());
        preparedStatement.setString(2,E.getCode());
        preparedStatement.setString(3,E.getTime());
        preparedStatement.setString(4,E.getServcode());
        preparedStatement.setString(5,E.getServname());
        preparedStatement.executeUpdate();
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
