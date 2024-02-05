<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thread.DTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<%
    // セッションスコープに保存されたデータを取得
    List<DTO> DTOlist = (List<DTO>)session.getAttribute("DTOlist");
    if (DTOlist == null) {
        System.out.println("DTOlist is null"); // ログにメッセージを出力
    } else {
        System.out.println("DTOlist size: " + DTOlist.size()); // ログにDTOlistのサイズを出力
    }
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB登録一覧</title>
</head>
<body>
	<h1>スレッドの一覧</h1>
	 
<table>
	
    <%for(int i = 0; i < DTOlist.size(); i++){%>
        <%DTO dto = (DTO)DTOlist.get(i);%>
        <tr>
            <td><%=dto.getThread_ID()%></td>
            <td><%=dto.getThread_Name()%></td>
            <td><%=dto.getCreator_Name()%></td>
           
        </tr>
    <% } %>
    
</table>
</body>
</html>
