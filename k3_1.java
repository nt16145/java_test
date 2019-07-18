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
      String n1_value = null;
      String n2_value = null;
      String o_value = null;
      int operate = 0;
      out.println("<form action=\"/webapps/nt16145.k3_2\" method=\"GET\">");
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
          String str = cookies[i].getName();
          // クッキー username が存在する場合，その内容を表示する
          if (str.equals("number1")) {
            n1_value = cookies[i].getValue();
            // 取得した文字列をUTF8でURLデコードする
            n1_value = URLDecoder.decode(n1_value, "utf-8");
          }

          if(str.equals("number2")) {
            n2_value = cookies[i].getValue();
            n2_value = URLDecoder.decode(n2_value, "utf-8");
          }
          if(str.equals("operator")) {
            o_value = cookies[i].getValue();
            o_value = URLDecoder.decode(o_value, "utf-8");
            operate = Integer.parseInt(o_value);
          }
        }
      }
      out.println("<input type=\"text\" value=" + n1_value +" name=\"number1\" size=10>");
      out.println("<select name=\"operator\">");
      if(cookies != null && operate == 1) {
        out.println("<option value=\"1\" selected>+");
      }
      else {
        out.println("<option value=\"1\">+");
      }
      if(cookies != null && operate == 2) {
        out.println("<option value=\"2\" selected>-");
      }
      else {
        out.println("<option value=\"2\">-");
      }
      if(cookies != null && operate == 3) {
        out.println("<option value=\"3\" selected>*");
      }
      else {
        out.println("<option value=\"3\">*");
      }
      if(cookies != null && operate == 4) {
        out.println("<option value=\"4\" selected>/");
      }
      else {
        out.println("<option value=\"4\">/");
      }
      out.println("</select>");
      out.println("<input type=\"text\" value=" + n2_value + " name=\"number2\" size=10>");
      out.println("<br>");
      out.println("<input type=\"submit\" value=\"送信\">");
      out.println("<input type=\"reset\" value=\"クリア\">");
      out.println("</form>");



      out.println("<hr>");
      out.println("No.23　中村太一<br>");
      out.println("</body></html>");
    }
}
