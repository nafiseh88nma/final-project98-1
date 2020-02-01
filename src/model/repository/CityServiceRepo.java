package model.repository;


import model.entity.CityServiceEntity;
import model.entity.RoadServiceEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CityServiceRepo implements AutoCloseable {

    private PreparedStatement preparedStatement ;
    private Connection connection;
    public CityServiceRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void create_cityservice()throws Exception{
        preparedStatement=connection.prepareStatement("create table city_service(Plaque varchar2(30) , typ varchar2(30) ,tim varchar2(20))");
        preparedStatement.executeUpdate();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void insert_cityservice(CityServiceEntity cityServiceEntity)throws Exception{
        preparedStatement=connection.prepareStatement("insert into city_service(Plaque,typ,tim)VALUES (?,?,?)");
        preparedStatement.setString(1,cityServiceEntity.getPlaque());
        preparedStatement.setString(2,cityServiceEntity.getType());
        preparedStatement.setString(3,cityServiceEntity.getDate());
        preparedStatement.executeUpdate();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void commite()throws Exception{
        connection.commit();
    }



}
