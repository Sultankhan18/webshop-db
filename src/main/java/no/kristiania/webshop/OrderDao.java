package no.kristiania.webshop;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class OrderDao extends AbstractDao<Order> {

    public OrderDao(DataSource dataSource) {
        super(dataSource);

    }


    @Override
    protected void insertObject(Order order, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, order.getName());

    }

    @Override
    protected Order readObject(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setName(rs.getString("name"));
        return order;
    }

    public void inseret(Order product) throws SQLException {
        insert(product, "insert into orders (name) values (?)");
    }

    public List<Order> listAll() throws SQLException {
        return listAll("select * from products");
    }
}
