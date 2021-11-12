package com.project.salsa_Modas_Manager.repository;
//@Slf4j
//public class ExecuteQuery<T extends DefaultDAO<T>> {
//
//    protected String dataSource;
//    JdbcTemplate jdbcTemplate;
//    public List<T> list(Map<String, String> param, String query, T map) {
//        log.info("T => {}", map.getClass().getName());
//        log.info("param => {}", param);
//        log.info("query => {}", query);
//
//        return jdbcTemplate.query(query, new RowMapper<T>() {
//
//            @Override
//            public T mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
//                return map.mapper(resultSet);
//            }
//        });
//    }
//
//}
