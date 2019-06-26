package com.xjy.cat.mapper;

import com.xjy.cat.model.Token;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TokenMapper {

    @Select("SELECT * FROM cat_access WHERE BINARY accessToken = #{0}")
    Token getByToken(String token);

    @Insert("INSERT INTO cat_access VALUES (null, #{accessToken}, #{userId}, #{createTime})")
    void insert(Token token);

    @Delete("DELETE FROM cat_access WHERE id = #{0}")
    void delete(int id);

}
