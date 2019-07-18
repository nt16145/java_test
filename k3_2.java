package nt16145;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "nt16145.k3_2", urlPatterns = { "/nt16145.k3_2" })
public class k3_2 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws  IOException, ServletException {

      // 出力形式を設定する
      response.setContentType("text/html; charset=UTF-8");
      // 出力先 out を定義する
      PrintWriter out = response.getWriter();
      // HTTPリクエストのエンコーディングを UTF-8 とする
      request.setCharacterEncoding("utf-8");

      // HTMLドキュメントを出力する
      out.println("<html><head>");
      out.println("<title>k3_2</title>");
      out.println("</head><body>");
      out.println("<h1>二項演算</h1><hr>");

      // この部分を完成させる
      float number1 = 0.0f;
      float number2 = 0.0f;
      if(!request.getParameter("number1").equals("")) {
        try {
          number1 = Float.parseFloat(request.getParameter("number1"));
        } catch (NumberFormatException e) {
          number1 = 1;
        }
      }
      else {
        number1 = 1;
      }
      int operate = Integer.parseInt(request.getParameter("operator"));

      if(!request.getParameter("number2").equals("")) {
        try {
          number2 = Float.parseFloat(request.getParameter("number2"));
        } catch (NumberFormatException e) {
          number2 = 1;
        }
      }
      else {
        number2 = 1;
      }
      //String enumber1 = URLEncoder.encode(number1, "utf-8");
      Cookie cookie = new Cookie("number1", String.valueOf(number1));
      response.addCookie(cookie);
      //String eoperate = URLEncoder.encode(operate, "utf-8");
      cookie = new Cookie("operator", String.valueOf(operate));
      response.addCookie(cookie);
      //String enumber2 = URLEncoder.encode(number2,"utf-8");
      cookie = new Cookie("number2",String.valueOf(number2));
      response.addCookie(cookie);


      out.println("<b>(" + number1 + ")");
      float result = 0;
      if(operate == 1) {
        out.println("+");
        result = number1 + number2;
      }
      else if(operate == 2) {
        out.println("-");
        result = number1 - number2;
      }
      else if(operate == 3) {
        out.println("*");
        result = number1 * number2;
      }
      else if(operate == 4) {
        out.println("/");
        result = number1 / number2;
      }
      out.println("(" + number2 + ") = " + result + "</b>");
      out.println("<br>");
      out.println("<form action=\"/webapps/nt16145.k3_1\" method=\"GET\">");
      out.println("<input type=\"submit\" value=\"もどる\">");
      out.println("</form>");
      out.println("<hr>");
      out.println("No.23　中村太一<br>");
      out.println("</body></html>");

    }
}
