package model.repository;


import model.entity.CarEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarRepo implements AutoCloseable {

    private PreparedStatement preparedStatement ;
    private Connection connection;
    public CarRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                "rastin" , "java");
        connection.setAutoCommit(false);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void create_car()throws Exception{
        preparedStatement=connection.prepareStatement("CREATE  TABLE car(name varchar2(30),Plaque varchar2(20),Certificate varchar2(30),card varchar2(30) , insurance varchar2(30))");
        preparedStatement.executeUpdate();
        connection.commit();

        preparedStatement=connection.prepareStatement("INSERT INTO car(name,Plaque,Certificate,card,insurance)values(?,?,?,?,?)");
        preparedStatement.setString(1,"mobinarastin");//اسم راننده
        preparedStatement.setString(2,"78v81455");//شماره پلاک
        preparedStatement.setString(3,"9380849639");//شماه گواهی نامه
        preparedStatement.setString(4,"102/8292773");//شماره کارت ماشین
        preparedStatement.setString(5,"1398/5/1/400/3233/20186");//شماره بیمه نامه ماشین
        preparedStatement.executeUpdate();
        connection.commit();
        ////2
        preparedStatement=connection.prepareStatement("INSERT INTO car(name,Plaque,Certificate,card,insurance)values(?,?,?,?,?)");
        preparedStatement.setString(1,"taharastin");//اسم راننده
        preparedStatement.setString(2,"45m65411");//شماره پلاک
        preparedStatement.setString(3,"9671149219");//شماه گواهی نامه
        preparedStatement.setString(4,"111/8542763");//شماره کارت ماشین
        preparedStatement.setString(5,"1397/2/2/200/3223/22182");//شماره بیمه نامه ماشین
        preparedStatement.executeUpdate();
        connection.commit();
        ////3
        preparedStatement=connection.prepareStatement("INSERT INTO car(name,Plaque,Certificate,card,insurance)values(?,?,?,?,?)");
        preparedStatement.setString(1,"nafisemahmod");//اسم راننده
        preparedStatement.setString(2,"11n43410");//شماره پلاک
        preparedStatement.setString(3,"9812124963");//شماه گواهی نامه
        preparedStatement.setString(4,"123/5332743");//شماره کارت ماشین
        preparedStatement.setString(5,"1397/12/30/450/1133/21116");//شماره بیمه نامه ماشین
        preparedStatement.executeUpdate();
        connection.commit();
        ////4
        preparedStatement=connection.prepareStatement("INSERT INTO car(name,Plaque,Certificate,card,insurance)values(?,?,?,?,?)");
        preparedStatement.setString(1,"sinarad");//اسم راننده
        preparedStatement.setString(2,"81h91355");//شماره پلاک
        preparedStatement.setString(3,"9580849439");//شماه گواهی نامه
        preparedStatement.setString(4,"101/8212773");//شماره کارت ماشین
        preparedStatement.setString(5,"1394/5/4/401/3253/25346");//شماره بیمه نامه ماشین
        preparedStatement.executeUpdate();
        connection.commit();
        ////5
        preparedStatement=connection.prepareStatement("INSERT INTO car(name,Plaque,Certificate,card,insurance)values(?,?,?,?,?)");
        preparedStatement.setString(1,"1");//اسم راننده
        preparedStatement.setString(2,"1");//شماره پلاک
        preparedStatement.setString(3,"1");//شماه گواهی نامه
        preparedStatement.setString(4,"1");//شماره کارت ماشین
        preparedStatement.setString(5,"1");//شماره بیمه نامه ماشین
        preparedStatement.executeUpdate();
        connection.commit();
    }
        //////////////////////////////////////////////////Select////////////////////////////////////////////////////////
        public ArrayList<CarEntity> car_select()throws Exception{
            preparedStatement=connection.prepareStatement("select * from car");
            ResultSet resultSet =preparedStatement.executeQuery();
            ArrayList<CarEntity> list = new ArrayList<>();
            while (resultSet.next()){
                CarEntity c = new CarEntity();
                c.setName(resultSet.getString("name"));
                c.setCard(resultSet.getString("card"));
                c.setPlaque(resultSet.getString("Plaque"));
                c.setCertificate(resultSet.getString("Certificate"));
                c.setInsurance(resultSet.getString("insurance"));
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
