package no.kristiania.webshop;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductDaoTest {

    @Test
    void shouldListInsertedProducts() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:myTestDatabase");

        dataSource.getConnection().createStatement().executeUpdate(
                "create table PRODUCTS (id serial primary key, name varchar(1000) not null)"
        );

        ProductDao dao = new ProductDao(dataSource);
            String product = sampleProduct();
            dao.insert(product);
            assertThat(dao.listAll())
                    .contains(product);

            }

    private String sampleProduct() {
    }
}
    }
}
