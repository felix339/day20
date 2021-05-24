package com.student.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author JOKRE
 */
public class JdbcUtil {
    static ComboPooledDataSource cp = new ComboPooledDataSource();
    static QueryRunner qr = new QueryRunner(cp);

    public static QueryRunner getQueryRunner(){
        return qr;
    }
}
