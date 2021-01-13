package com.vblog.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * @author lryepoch
 * @date 2021/1/13 11:11
 * @description TODO
 */
//@MappedJdbcTypes(JdbcType.DATE)
//@MappedTypes(String.class)
//public class DateTypeHandler implements TypeHandler {
//    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//    @Override
//    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
//
//    }
//
//    @Override
//    public Object getResult(ResultSet resultSet, String s) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Object getResult(ResultSet resultSet, int i) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
//        return null;
//    }
//}
