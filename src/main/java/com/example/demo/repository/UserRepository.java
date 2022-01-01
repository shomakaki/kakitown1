package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
//	public static final RowMapper<User> USER_ROW_MAPPER =(rs,i)-> {
//		User user =new User();
//		user.setId(rs.getInt("id"));
//		user.setName(rs.getString("name"));
//		user.setEmail(rs.getString("email"));
//		user.setPassword(rs.getString("password"));
//		user.setConfirmPassword(rs.getString("confirmPassword"));
//		user.setZipcode(rs.getString("zipcode"));
//		user.setAddress(rs.getString("address"));
//		user.setTelephone(rs.getString("telephone"));
//		return user;
//	};
	private static final RowMapper<User>  USER_ROW_MAPPER
				=new BeanPropertyRowMapper<>(User.class);
	
	public User insert(User user) {
		
		String insertSql="INSERT INTO users(name,email,password,zipcode,address,telephone) "
				+ "VALUES (:name,:email,:password,:zipcode,:address,:telephone)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String[] keyColumnNames= {"id"};
		template.update(insertSql,param,keyHolder,keyColumnNames);
		user.setId(keyHolder.getKey().intValue());
		return user;
	}
	public User load(String email) {
		String loadSql="SELECT * FROM users WHERE email = :email";
		
		SqlParameterSource param = new MapSqlParameterSource("email",email);
		User user = template.queryForObject(loadSql, param, USER_ROW_MAPPER);
		System.out.println("rep"+user);
		return user;
	}

}
