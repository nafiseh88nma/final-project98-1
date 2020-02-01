package model.repository;

import model.entity.RoadServiceEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class RoadServiceRepo implements AutoCloseable{
    private PreparedStatement preparedStatement ;
    private Connection connection;
    public RoadServiceRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void create_roadservice()throws Exception{
        preparedStatement=connection.prepareStatement("create table road_service(id references avarezi , model varchar2(30) , price varchar2(20) , Plaque varchar2(30))");
        preparedStatement.executeUpdate();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void insert_roadservice(RoadServiceEntity roadServiceEntity)throws Exception{
        preparedStatement=connection.prepareStatement("insert into road_service(id,model,price,Plaque)VALUES (?,?,?,?)");
        preparedStatement.setString(1,roadServiceEntity.getId());
        preparedStatement.setString(2,roadServiceEntity.getModel());
        preparedStatement.setString(3,roadServiceEntity.getPrice());
        preparedStatement.setString(4,roadServiceEntity.getPlaque());
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
