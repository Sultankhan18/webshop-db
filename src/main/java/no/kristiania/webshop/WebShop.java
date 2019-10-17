package no.kristiania.webshop;

import org.postgressql.ds.PGSimpleDataSource;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;4444
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class WebShop {

    public static void main(String[] args) throws IQException, SQLException {
       new WebShop().run();
    }

    private static void run() throws IQException, SQLException {
        System.out.println("Please type the name of a new product");

        String productName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        Properties properties = new Properties();
        properties.load(new FileReader("webshop.properties"));

        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jbdc:postgresql://localhost:5432/mywebshopdb");
        dataSource.setUser("mywebshop");

    }
}
