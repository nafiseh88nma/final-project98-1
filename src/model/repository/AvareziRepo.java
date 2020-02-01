package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AvareziRepo implements AutoCloseable{
    private PreparedStatement preparedStatement ;
    private Connection connection;
    public AvareziRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        //connection.setAutoCommit(false);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void create_avarezi()throws Exception{
        preparedStatement=connection.prepareStatement("create table avarezi(id varchar2(30) PRIMARY KEY  , location varchar2(30))");
        preparedStatement.executeUpdate();
        //////////////////////////////////////
        preparedStatement=connection.prepareStatement("insert into avarezi(id,location)values(?,?)");
        preparedStatement.setString(1,"111");
        preparedStatement.setString(2,"kashan_natanz");
        preparedStatement.executeUpdate();
        //////////////////////////////////////
        preparedStatement=connection.prepareStatement("insert into avarezi(id,location)values(?,?)");
        preparedStatement.setString(1,"121");
        preparedStatement.setString(2,"qazvin_rodbar");
        preparedStatement.executeUpdate();
        /////////////////////////////////////
        preparedStatement=connection.prepareStatement("insert into avarezi(id,location)values(?,?)");
        preparedStatement.setString(1,"413");
        preparedStatement.setString(2,"tehran_qom");
        preparedStatement.executeUpdate();
        /////////////////////////////////////
        preparedStatement=connection.prepareStatement("insert into avarezi(id,location)values(?,?)");
        preparedStatement.setString(1,"981");
        preparedStatement.setString(2,"esfehan_kashan");
        preparedStatement.executeUpdate();

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
