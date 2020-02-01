package model.repository;

import model.entity.RegisertingViolationsEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Registering_ViolationsRepo implements AutoCloseable{
    private PreparedStatement preparedStatement ;
    private Connection connection;

    public Registering_ViolationsRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void create_registering_violations()throws Exception{
        preparedStatement=connection.prepareStatement("CREATE TABLE registering_violations(officer_name varchar2(20),officer_code varchar2(20),name_Infraction varchar2(30),Plaque varchar2(30),Certificate varchar2(30),card varchar2(30), score varchar2(20), price  varchar2(20), dat varchar2(30) , location varchar2(30)  )");
        preparedStatement.executeUpdate();
        connection.commit();
    }
    ///////////////////////////////////////////////تخلفات و نمره منفی insert////////////////////////////////////////////
    public void registering_violations_insert (RegisertingViolationsEntity regisertingViolationsEntity)throws Exception{
        preparedStatement=connection.prepareStatement("insert into registering_violations(officer_name,officer_code,name_Infraction,Plaque,Certificate,card,score,price,dat,location)values(?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,regisertingViolationsEntity.getOfficer_name());
        preparedStatement.setString(2,regisertingViolationsEntity.getOfficer_code());
        preparedStatement.setString(3,regisertingViolationsEntity.getName_Infraction());
        preparedStatement.setString(4,regisertingViolationsEntity.getPlaque());
        preparedStatement.setString(5,regisertingViolationsEntity.getCertificate());
        preparedStatement.setString(6,regisertingViolationsEntity.getCard());
        preparedStatement.setString(7,regisertingViolationsEntity.getNscore());
        preparedStatement.setString(8,regisertingViolationsEntity.getPrice1());
        preparedStatement.setString(9,regisertingViolationsEntity.getDate());
        preparedStatement.setString(10,regisertingViolationsEntity.getLocation());

        preparedStatement.executeUpdate();
    }
    /////////////////////////////////////////select تخلفات و نمره منفی//////////////////////////////////////////////////
    public ArrayList<RegisertingViolationsEntity> registering_violations_select()throws Exception{
        preparedStatement=connection.prepareStatement("select * from registering_violations");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<RegisertingViolationsEntity> list  = new ArrayList<>();
        while (resultSet.next()){
            RegisertingViolationsEntity r = new RegisertingViolationsEntity();
            r.setOfficer_name(resultSet.getString("officer_name"));
            r.setOfficer_code(resultSet.getString("officer_code"));
            r.setName_Infraction(resultSet.getString("name_Infraction"));
            r.setPlaque(resultSet.getString("Plaque"));
            r.setCertificate(resultSet.getString("Certificate"));
            r.setCard(resultSet.getString("card"));
            r.setPrice1(resultSet.getString("price"));
            r.setNscore(resultSet.getString("score"));
            r.setDate(resultSet.getString("dat"));
            r.setLocation(resultSet.getString("location"));
            list.add(r);
        }
        return list ;
    }

    ///////////////////////////////////////////////////////delete تخلفات////////////////////////////////////////////////
    public void registering_violations_delete(String card )throws Exception{//معیار حذف شماره کارت ماشین
        preparedStatement=connection.prepareStatement("delete from registering_violations where card=?");
        preparedStatement.setString(1,card);
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

