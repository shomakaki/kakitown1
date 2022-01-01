package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Item;


@Repository
public class ItemRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
//	private static final RowMapper<Item> ITEM_ROW_MAAPPER
//		=new BeanPropertyRowMapper<>(Item.class);
	
	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs,i)->{
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPriceM(rs.getInt("price_m"));
		item.setPriceL(rs.getInt("price_l"));
		item.setImagePath(rs.getString("image_path"));
//		item.setImagePath2(rs.getString("imagePath2"));
//		item.setImagePath3(rs.getString("imagePath3"));
		return item;
	};
	
	
	public List<Item> findAll(){
		String sql ="SELECT * FROM items ";
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		System.out.println(itemList);
		return itemList;
	}
	public List<Item> search(String name){
		String sql ="SELECT * FROM items WHERE name LIKE :name ";
		SqlParameterSource param = new MapSqlParameterSource("name","%"+ name +"%");
		List<Item> itemList = template.query(sql,param, ITEM_ROW_MAPPER);
//		System.out.println(itemList);
		return itemList;
	}
	public Item load(Integer id) {
		String loadSql = "SELECT * FROM items WHERE id =:id";
		SqlParameterSource param = new MapSqlParameterSource("id",id);
		Item item = template.queryForObject(loadSql, param, ITEM_ROW_MAPPER);
		return item;
	}
}