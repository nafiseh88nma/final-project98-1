package model.repository;


import model.entity.Electronic_PaymentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Electronic_PaymentRepo implements AutoCloseable {
    private PreparedStatement preparedStatement ;
    private Connection connection;
    public Electronic_PaymentRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void create_electronic_payment()throws Exception{
        preparedStatement=connection.prepareStatement("CREATE  TABLE card(numb varchar2(30),cvv2 varchar2(30),password2 varchar2(30) , mojoudi NUMBER )");
        preparedStatement.executeUpdate();
        connection.commit();

        preparedStatement=connection.prepareStatement("INSERT INTO card(numb,cvv2,password2,mojoudi)values(?,?,?,?)");
        preparedStatement.setString(1,"1234567891234567");
        preparedStatement.setString(2,"5434");
        preparedStatement.setString(3,"6464");
        preparedStatement.setLong(4,1230000);
        preparedStatement.executeUpdate();
        connection.commit();
        ////2
        preparedStatement=connection.prepareStatement("INSERT INTO card(numb,cvv2,password2,mojoudi)values(?,?,?,?)");
        preparedStatement.setString(1,"1235438901243346");
        preparedStatement.setString(2,"3453");
        preparedStatement.setString(3,"9012");
        preparedStatement.setLong(4,150000);
        preparedStatement.executeUpdate();
        connection.commit();
        ////3
        preparedStatement=connection.prepareStatement("INSERT INTO card(numb,cvv2,password2,mojoudi)values(?,?,?,?)");
        preparedStatement.setString(1,"1298643581709725");
        preparedStatement.setString(2,"0982");
        preparedStatement.setString(3,"7887");
        preparedStatement.setLong(4,580000);
        preparedStatement.executeUpdate();
        connection.commit();
        ////4
        preparedStatement=connection.prepareStatement("INSERT INTO card(numb,cvv2,password2,mojoudi)values(?,?,?,?)");
        preparedStatement.setString(1,"9871528273h82323");
        preparedStatement.setString(2,"9042");
        preparedStatement.setString(3,"1234");
        preparedStatement.setLong(4,90000);
        preparedStatement.executeUpdate();
        connection.commit();
    }
    /////////////////////////////////////////////اپدیت موجودی کارت//////////////////////////////////////////////////////
    public void electronic_payment_update_mojoudi(String number , Long pardakhti , Long mojoudi)throws Exception{
        preparedStatement=connection.prepareStatement("update card set mojoudi=? where numb=?");
        preparedStatement.setLong(1,(mojoudi-pardakhti));
        preparedStatement.setString(2,number);
        preparedStatement.executeUpdate();
    }
    ///////////////////////////////////////////////استعلام موجودی کارت select////////////////////////////////////////////
    public Long card_mojoudi_select (String number)throws Exception{
        preparedStatement = connection.prepareStatement("select mojoudi from card where numb=?");
        ResultSet resultSet = preparedStatement.executeQuery();
        Long moujodi = null ;
        while (resultSet.next()){
            moujodi=resultSet.getLong("mojoudi");
        }
        return moujodi;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Electronic_PaymentEntity> select_all()throws Exception{
        preparedStatement=connection.prepareStatement("select * from card");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Electronic_PaymentEntity> list = new ArrayList<>();
        while (resultSet.next()){
            Electronic_PaymentEntity e = new Electronic_PaymentEntity();
            e.setNumber(resultSet.getString("numb"));
            e.setCvv2(resultSet.getString("cvv2"));
            e.setPassword2(resultSet.getString("password2"));
            e.setMojoudi(resultSet.getLong("mojoudi"));
            list.add(e);
        }
        return  list;
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
