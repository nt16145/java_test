package nt16145;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "nt16145.k1_2", urlPatterns = { "/nt16145.k1_2" })

public class k1_2 extends HttpServlet {
  private int[][] kdata = {
    // 年度 M A J S K
    { 30, 746, 788, 629, 461, 547 }, { 29, 742, 775, 540, 422, 525 }, { 28, 702, 727, 476, 416, 518 },
    { 27, 640, 631, 523, 415, 512 }, { 26, 509, 487, 429, 297, 425 }, { 25, 435, 383, 333, 213, 261 },
    { 24, 235, 236, 287, 95, 113 }, { 23, 332, 350, 242, 156, 137 }, { 22, 332, 350, 254, 156, 133 },
    { 21, 381, 400, 288, 160, 137 }, { 20, 540, 590, 412, 200, 179 }, { 19, 579, 603, 430, 270, 200 },
    { 18, 504, 480, 344, 208, 155 }, { 17, 321, 330, 256, 130, 105 }, { 16, 279, 301, 220, 126, 73 },
    { 15, 190, 233, 169, 74, 49 }, { 14, 213, 231, 172, 93, 85 }, { 13, 269, 270, 207, 135, 106 },
    { 12, 237, 235, 189, 129, 161 }, { 11, 203, 242, 162, 106, 130 }, { 10, 262, 288, 195, 125, 120 },
    { 9, 268, 326, 206, 142, 171 }, { 8, 200, 244, 149, 105, 215 }, { 7, 175, 213, 102, 75, 94 },
    { 6, 187, 198, 81, 86, 209 } };

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    int i,j,k,check_1=0,check_2=0;
    String year1_s = request.getParameter("year1");
    String year2_s = request.getParameter("year2");
    if(year1_s.equals(""))
      check_1 = 1;
    if(year2_s.equals(""))
      check_2 = 1;
    int year1=0;
    if(check_1 == 0)
      year1 = Integer.parseInt(year1_s);
    int year2=0;
    if(check_2 == 0)
      year2 = Integer.parseInt(year2_s);
    if(year1 < 6 || check_1 == 1)
      year1 = 6;
    if(year2 < 6 || check_2 == 1)
      year2 = 6;
    if(year1 > 30)
      year1 = 30;
    if(year2 > 30)
      year2 = 30;
    // 出力形式を設定する
    response.setContentType("text/html; charset=UTF-8");
    // 出力先 out を定義する
    PrintWriter out = response.getWriter();
    // HTTPリクエストのエンコーディングを UTF-8 とする
    request.setCharacterEncoding("utf-8");

    out.println("<h1>本校の学科別求人一覧</h1>");
    out.println("平成" + year1 + "年度から、平成" + year2 + "年度までの求人一覧");
    out.println("<table border=\"1\">");
    out.println("<tr>");
    out.println("<th>年度</th>");
    out.println("<th>M</th>");
    out.println("<th>A</th>");
    out.println("<th>J</th>");
    out.println("<th>S</th>");
    out.println("<th>K</th>");
    out.println("</tr>");
    for(i=year1;i<=year2;i=i+1) {
      for(k=0;k<=24;k=k+1) {
        if(i==kdata[k][0]) {
          out.println("<tr>");
          for(j=0;j<=5;j=j+1) {
            out.println("<td>" + kdata[k][j] + "</td>");
          }
          out.println("</tr>");
        }
      }
    }
    out.println("</table>");
    out.println("<hr>");
    out.println("<form action=\"/webapps/nt16145.k1_1\" method=\"GET\">");
    out.println("<input type=\"submit\" value=\"もどる\">");
    out.println("</form>");
    out.println("No.23　中村太一<br>");
    out.println("</body></html>");
  }
}
