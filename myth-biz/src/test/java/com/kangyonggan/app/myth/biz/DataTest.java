package com.kangyonggan.app.myth.biz;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
public class DataTest {

    @Test
    public void testGenSQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myth?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
            PreparedStatement ps = conn.prepareStatement("SELECT id, tags FROM article");

            ResultSet rs = ps.executeQuery();

            StringBuilder sb = new StringBuilder("INSERT INTO dictionary_medi \n(source_id, dictionary_code, type)\nVALUES");
            while (rs.next()) {
                Long id = rs.getLong(1);
                String tags = rs.getString(2);

                String tagArr[] = tags.split(" ");
                for (String tag : tagArr) {

                    PreparedStatement ps2 = conn.prepareStatement("SELECT code FROM dictionary where value = '" + tag + "'");

                    ResultSet rs2 = ps2.executeQuery();
                    rs2.next();
                    String code = rs2.getString(1);

                    sb.append("\n\t").append("(").append(id).append(",'").append(code).append("', 'tag'),");
                }
            }

            sb.deleteCharAt(sb.lastIndexOf(",")).append(";");
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
