package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Item;

@Repository
public class CartRepository {
	
	

	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs,i)->{
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPriceM(rs.getInt("price_m"));
		item.setPriceL(rs.getInt("price_l"));
		item.setImagePath(rs.getString("image_path"));
		
		return item;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public Item load(Integer id) {
		String loadSql = "SELECT * FROM items WHERE id =:id";
		SqlParameterSource param = new MapSqlParameterSource("id",id);
		Item item = template.queryForObject(loadSql, param, ITEM_ROW_MAPPER);
		return item;
	}
}
