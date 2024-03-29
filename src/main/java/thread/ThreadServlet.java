package thread;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登録データを一覧表示するクラス

public class ThreadServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //データベース一覧表示
        DAO dao = new DAO();
        List<DTO> DTOlist;
		try {
			DTOlist = dao.showAllList();
			//セッションの開始
	        HttpSession session = request.getSession();
	        //セッションスコープにデータ登録
	        session.setAttribute("DTOlist",DTOlist);

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TestThread.jsp");
        dispatcher.forward(request, response);
    }
}