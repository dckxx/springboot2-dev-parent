package com.dckxx.common.util;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

@Component
public class MyJdbcTemplate extends JdbcTemplate {
    public MyJdbcTemplate(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object...args) throws DataAccessException {
        List<T> results = this.query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
        return requiredSingleResult(results);
    }

    private <T> T requiredSingleResult(Collection<T> results) throws IncorrectResultSizeDataAccessException {
        int size = (results != null ? results.size() : 0);
        if (size == 0) {
//            throw new EmptyResultDataAccessException(1);
            return null;
        }
        /*
        if (results.size() > 1) {
		 throw new IncorrectResultSizeDataAccessException(1, size);
        }
        */
        //多条时，也返回第一条数据
        return results.iterator().next();
    }
}
