package nt16145;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "nt16145.k3_1", urlPatterns = { "/nt16145.k3_1" })

public class k3_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();

		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>k3_1</title>");
		out.println("</head><body>");
		out.println("<h1>二項演算</h1><hr>");
		out.println("二つの数値と演算子を指定してください<br>");

		// この部分を完成させる




		out.println("<hr>");
		out.println("No.出席番号　氏名<br>");
		out.println("</body></html>");
    }
}