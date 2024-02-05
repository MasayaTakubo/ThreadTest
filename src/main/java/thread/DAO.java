package thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO{
    private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";    //URL
    private static final String user = "info";  //DBユーザー
    private static final String pass = "pro";    //DBパスワード/
    private List<DTO> DTOlist = new ArrayList<>();   //リストに格納

    //データベース一覧表示メソッド
    public List<DTO> showAllList() throws ClassNotFoundException {
    Class.forName("oracle.jdbc.driver.OracleDriver");
        //JDBC読み込み
        try (Connection connect = DriverManager.getConnection(url,user,pass)){
        	

            //データベースから氏名を取得するSQL文
            String sql ="select thread_id, thread_name, creator_name from thread";
            PreparedStatement ps = connect.prepareStatement(sql);

            //SQL文の実行
            ResultSet resultset = ps.executeQuery();

            while(resultset.next()){

                //データベースから取得した値をセット
                DTO dto = new DTO();

                //氏名の取得
                dto.setThread_ID(resultset.getInt("thread_id"));
                dto.setThread_Name(resultset.getString("thread_name"));
                dto.setCreator_Name(resultset.getString("creator_name"));
                

                DTOlist.add(dto);
            }

            resultset.close();
            ps.close();

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return DTOlist;
    }
}


