package model.repository;

import model.entity.AccidentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccidentRepo implements  AutoCloseable{
    private PreparedStatement preparedStatement ;
    private Connection connection;
    public AccidentRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    /////////////////////////////////////////////ساخت table/////////////////////////////////////////////////////////////
    public  void create_accidents()throws Exception{
        preparedStatement=connection.prepareStatement("CREATE TABLE accidents(officer_name varchar2(30),officer_code varchar2(30),Plaque varchar2(30),Certificate varchar2(30),card varchar2(30),Location varchar2(30),dat varchar2(30) , insurance varchar2(30))");
        preparedStatement.executeUpdate();
        connection.commit();
    }
    ///////////////////////////////////////////////////////////////////////insert تصادف/////////////////////////////////
    public void accident_insert(AccidentEntity accidentEntity)throws Exception{
        preparedStatement=connection.prepareStatement("insert into accidents(officer_name,officer_code,Plaque,Certificate,card,Location,dat,insurance)values(?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,accidentEntity.getOfficer_name());
        preparedStatement.setString(2,accidentEntity.getOfficer_code());
        preparedStatement.setString(3,accidentEntity.getPlaque());
        preparedStatement.setString(4,accidentEntity.getCertificate());
        preparedStatement.setString(5,accidentEntity.getCard());
        preparedStatement.setString(6,accidentEntity.getLocation());
        preparedStatement.setString(7,accidentEntity.getDate());
        preparedStatement.setString(8,accidentEntity.getInsurance());
        preparedStatement.executeUpdate();
    }
    ////////////////////////////////////////////////////select تصادف////////////////////////////////////////////////////
    public ArrayList<AccidentEntity> accident_select()throws Exception{
        preparedStatement=connection.prepareStatement("select * from accidents");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<AccidentEntity> list  = new ArrayList<>();
        while (resultSet.next()){
            AccidentEntity a = new AccidentEntity();
            a.setOfficer_name(resultSet.getString("officer_name"));
            a.setOfficer_code(resultSet.getString("officer_code"));
            a.setPlaque(resultSet.getString("Plaque"));
            a.setCertificate(resultSet.getString("Certificate"));
            a.setCard(resultSet.getString("card"));
            a.setLocation(resultSet.getString("Location"));
            a.setDate(resultSet.getString("dat"));
            a.setInsurance(resultSet.getString("insurance"));
            list.add(a);
        }
        return list ;
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
