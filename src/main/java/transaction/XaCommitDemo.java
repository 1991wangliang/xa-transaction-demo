package transaction;

import java.sql.Connection;
import java.sql.Statement;


public class XaCommitDemo extends BaseDemo {

    public static void main(String[] args) throws Exception {
        init();

        utm.begin(); // 开启xa事务

        Connection c1 = adsb1.getConnection();
        Statement stmt = c1.createStatement();
        stmt.execute("insert into t_test(name) values('db1-name')");
        stmt.close();
        c1.close();

        Connection c2 = adsb2.getConnection();
        Statement stmt2 = c2.createStatement();
        stmt2.execute("insert into t_test(name) values('db2-name')");
        stmt2.close();
        c2.close();

        utm.commit(); // 提交xa事务

        shutdown();
    }

}
