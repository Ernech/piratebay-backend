package com.ernesto.backend.dao;

import com.ernesto.backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findUserIdByUsernameAndPassword (String username, String password){
        //Implementamos SQL variable binding para evitar SQL injection
        //String query ="SELECT user_id FROM \"user\" WHERE username = ? AND password = ? ";
        String query = "SELECT user_id FROM \"user\" WHERE username = ? AND UPPER(password) = UPPER(?) ";
        Integer userId =null;
        try{
            userId = jdbcTemplate.queryForObject(query,new Object[]{username,password},Integer.class);
        }catch (Exception e){
            //Do nothing
        }
        return userId;
    }
    public ArrayList<UserModel> findAllActives(){
        String query = "SELECT user_id, username, email, phone_number, cat_user_status FROM \"user\" WHERE status = 1";
        ArrayList<UserModel> result =null;
        try{
            result = (ArrayList<UserModel>) jdbcTemplate.query(query, new RowMapper<UserModel>() {
                @Override
                public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new UserModel(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            });

        }catch (Exception ex){
            throw new RuntimeException();
        }
        return result;

    }

    public ArrayList<String> findAllFeatureCodeByUserId(int userId){
        ArrayList<String> features =null;
        String query = "SELECT\n" +
                "       DISTINCT fea.feature_code\n" +
                "FROM\n" +
                "    \"user\" usr\n" +
                "    JOIN user_role uro ON usr.user_id = uro.user_id\n" +
                "    JOIN \"role\" rle ON rle.role_id = uro.role_id\n" +
                "    JOIN role_feature rfe ON rfe.role_id = rle.role_id\n" +
                "    JOIN feature fea ON fea.feature_id = rfe.feature_id\n" +
                "WHERE\n" +
                "    usr.user_id = ? \n" +
                "    AND usr.status =  1\n" +
                "    AND uro.status = 1\n" +
                "    AND rle.status = 1\n" +
                "    AND rfe.status = 1\n" +
                "    AND fea.status = 1";
        try {
            features = (ArrayList<String>) jdbcTemplate.query(query, new Object[]{userId},
                    new RowMapper<String>(){
                        @Override
                        public String mapRow(ResultSet resultSet, int i) throws SQLException {
                            return resultSet.getString(1);
                        }
                    });
        }
        catch (Exception exception){
            throw new RuntimeException(exception);
        }

        return features;
    }
}
