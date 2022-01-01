package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Order;

@Repository
public class OrderRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Order> ORDER_ROW_MAPPER =(rs,i)->{
		Order order =new Order();
		order.setDestinationName(rs.getString("destinationName"));
		order.setDestinationEmail(rs.getString("destinationEmail"));
	    order.setDestinationZipcode(rs.getString("destinationZipcode"));
	    order.setDestinationAddress(rs.getString("destinatiomAdress"));
	    order.setDestinationTel(rs.getString("destinationTel"));
	    
	    return order;
	};

	public void orderInsert(Order order) {
		String insertSql= "INSERT INTO orders(user_id,total_price,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,status) "
				+ "VALUES(:userId,:totalPrice,:destinationName,:destinationEmail,:destinationZipcode,:destinationAddress,:destinationTel,1)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		template.update(insertSql, param);
		
	}
}
