package org.example.jpabulksave.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.jpabulksave.entity.Test;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void bulkUpdateUsers(List<Test> tests) {
        String sql = "UPDATE test SET nick_name = ? WHERE name = ?";

        int batchSize = 1000;  // 청크 크기 설정
        int totalSize = tests.size();

        for (int i = 0; i < totalSize; i += batchSize) {
            int end = Math.min(i + batchSize, totalSize);
            List<Test> batchList = tests.subList(i, end);

            jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Test test = batchList.get(i);
                    ps.setString(1, "SENDED3");
                    ps.setString(2, test.getName());
                }

                @Override
                public int getBatchSize() {
                    return batchList.size();
                }
            });
        }
    }


    @Transactional
    public void bulkInsertUsers(List<Test> tests) {
        String sql = "Insert INTO test (id, name, nick_name) VALUES (?, ?, ?,?,?,?,?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Test test = tests.get(i);
                ps.setString(1, test.getId());
                ps.setString(2, test.getName());
                ps.setString(3, test.getNickName1());
                ps.setString(4, test.getNickName2());
                ps.setString(5, test.getNickName3());
                ps.setString(6, test.getNickName4());
                ps.setString(7, test.getNickName5());
                ps.setString(8, test.getNickName6());
                ps.setString(9, test.getNickName7());
                ps.setString(10, test.getNickName8());
            }

            @Override
            public int getBatchSize() {
                return tests.size();
            }
        });
    }
}
