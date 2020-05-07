package ru.Dmi3ev.dao;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.RowMapper;
        import org.springframework.stereotype.Repository;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import org.springframework.stereotype.Repository;
        import ru.Dmi3ev.model.Item;

        import java.sql.SQLException;
        import java.text.SimpleDateFormat;
        import java.util.List;
        import java.sql.Types;
        import javax.xml.bind.SchemaOutputResolver;
        import java.sql.ResultSet;

@Repository
public class ItemDAO {

    JdbcTemplate template;
    private static Logger logger= LoggerFactory.getLogger(ItemDAO.class);

    public List<Item> getAllItem(){
        logger.info("Вызов метода getAllItem");
        try{
            return template.query("select * from item",new RowMapper<Item>(){

                public Item mapRow(ResultSet rs, int row) throws SQLException {
                    Item item =  new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setPrice(rs.getInt("price"));
                    return item;
                }
            });

        }catch (Exception e){
            logger.error("Ошибка при выполнении метода listAllTasks: ", e);
            return null;
        }
    }

    public Item getItemById(int id){
        logger.info("Вызов метода getItemById");
        String query="select * from item where id=?";
        try{
            return template.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<Item>(Item.class));
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода getItemById: ", e);
            return null;
        }
    }

    public int update(Item item){
        logger.info("Вызов метода update");
        String query="update item set name=?, price=? where id=?";
        System.out.println(item.getId() + item.getName() + item.getPrice());
        Object[] params = {item.getName(), item.getPrice(), item.getId() };
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.INTEGER};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода update: ", e);
            return -1;
        }
    }

    public int addItem(Item item){
        logger.info("Вызов метода addItem");
        String query="insert into item(name, price) values (?, ?)";
        Object[] params = {item.getName(), item.getPrice()};
        int[] types = {Types.VARCHAR, Types.INTEGER};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода insert: ", e);
            return -1;
        }
    }

    public int delete(int id){
        logger.info("Вызов метода delete");
        String query="delete from item where id=?";
        Object[] params = {id};
        int[] types = {Types.INTEGER};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода delete: ", e);
            return -1;
        }
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

}