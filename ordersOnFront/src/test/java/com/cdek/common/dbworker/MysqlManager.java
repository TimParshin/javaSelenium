package com.cdek.common.dbworker;

import com.cdek.common.dataModel.OrderData;
import org.testng.annotations.Test;

import java.sql.*;

public class MysqlManager {

    @Test
    public void mysqlConnetor() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://172.16.100.31:3308/express40?" +
                    "user=expresscourier&password=95751535");

            //
            Statement st = conn.createStatement();
            String query = "SELECT \n" +
                    "o.NumberOrd,\n" +
                    "oi.NumberIn,\n" +
                    "oi.SellerAddress,\n" +
                    "oi.ShipperName,\n" +
                    "oi.ShipperAddress,\n" +
                    "oi.DateInvoice,\n" +
                    "#tin.TaxpayerIdentificationNumber,\n" +
                    "pas.PasSer,\n" +
                    "pas.PasNum,\n" +
                    "pas.DateIssue,\n" +
                    "pas.IssuedBy,\n" +
                    "pas.DateOfBirth,\n" +
                    "ig.NameEx,\n" +
                    "ig.WeightBrutto,\n" +
                    "ig.Link\n" +
                    "FROM orders o\n" +
                    "INNER JOIN orders_inparams oi ON oi.ID_order = o.ID\n" +
                    "#INNER JOIN orders_TIN tin ON tin.ID_order = o.ID\n" +
                    "INNER JOIN orders_passport pas ON pas.NumberOrd = o.NumberOrd AND pas.ID_type = 1\n" +
                    "INNER JOIN orders_include_goods ig ON ig.ID_order = o.ID\n" +
                    "WHERE oi.NumberIn IN \n" +
                    "('CommonAutoFirst000001', #вставить номера заказов\n" +
                    "'CommonAutoFirst000002', # по системе ИМ\n" +
                    "'CommonAutoFirst000003',\n" +
                    "'CommonAutoFirst000004',\n" +
                    "'CommonAutoFirst000005',\n" +
                    "'CommonAutoFirst000006',\n" +
                    "'CommonAutoFirst000007',\n" +
                    "'CommonAutoFirst000008',\n" +
                    "'CommonAutoFirst000009',\n" +
                    "'CommonAutoFirst000010');";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String numberOrd = new OrderData().getNumberOrd(rs.getString("NumberOrd"));
                System.out.println(numberOrd);
            }

            rs.close();
            st.close();
            conn.close();
            
        } catch (
                SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


}
