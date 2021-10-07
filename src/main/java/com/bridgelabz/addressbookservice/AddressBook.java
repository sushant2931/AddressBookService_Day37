package com.bridgelabz.addressbookservice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/address_book_system";
        String userName = "root";
        String password = "Sushant@123";
        Connection connection = null;
        try {
            //1 . load and register the driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    public List<Contacts> retrieveData() throws SQLException {
        ResultSet resultSet = null;
        List<Contacts> employeeInfoList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from address_book;";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                Contacts contacts = new Contacts();
                contacts.setFirstName(resultSet.getString("firstName"));
                contacts.setLastName(resultSet.getString("lastName"));
                contacts.setAddress(resultSet.getString("address"));
                contacts.setCity(resultSet.getString("city"));
                contacts.setState(resultSet.getString("state"));
                contacts.setZip(resultSet.getLong("zip"));
                contacts.setPhoneNumber(resultSet.getLong("phoneNumber"));
                contacts.setEmail(resultSet.getString("email"));
                employeeInfoList.add(contacts);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;

    }

    public void updateContacts(long phoneNumber, long zip) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "update address_book set zip=" + zip + " where phoneNumber=" + phoneNumber + "";
            int result = statement.executeUpdate(query);
            if (result == 1)
                System.out.println("zip updated");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }
    public List<Contacts> retrieveDataBetweenRange() throws SQLException {
        ResultSet resultSet = null;
        List<Contacts> employeeInfoList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from address_book where start_date between '2020-08-01' AND '2020-09-30'";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                Contacts contacts = new Contacts();
                contacts.setFirstName(resultSet.getString("firstName"));
                contacts.setLastName(resultSet.getString("lastName"));
                contacts.setAddress(resultSet.getString("address"));
                contacts.setCity(resultSet.getString("city"));
                contacts.setState(resultSet.getString("state"));
                contacts.setZip(resultSet.getLong("zip"));
                contacts.setPhoneNumber(resultSet.getLong("phoneNumber"));
                contacts.setEmail(resultSet.getString("email"));
                System.out.println(employeeInfoList.add(contacts));;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;
    }
    public List<Contacts> retrieveDataByValue() throws SQLException {
        ResultSet resultSet = null;
        List<Contacts> employeeInfoList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from address_book where start_date between '2020-08-01' and '2020-09-30' group by city or state";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                Contacts contacts = new Contacts();
                contacts.setFirstName(resultSet.getString("firstName"));
                contacts.setLastName(resultSet.getString("lastName"));
                contacts.setAddress(resultSet.getString("address"));
                contacts.setCity(resultSet.getString("city"));
                contacts.setState(resultSet.getString("state"));
                contacts.setZip(resultSet.getLong("zip"));
                contacts.setPhoneNumber(resultSet.getLong("phoneNumber"));
                contacts.setEmail(resultSet.getString("email"));
                System.out.println(employeeInfoList.add(contacts));;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;
    }
}





