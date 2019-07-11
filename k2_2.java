    
package nt16145;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.*;

@WebServlet(name = "nt16145.k2_2", urlPatterns = { "/nt16145.k2_2" })

public class k2_2 extends HttpServlet {
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

    private int width = 1000, height = 1000;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // 出力形式を設定する
        response.setContentType("image/jpeg; charset=UTF-8");
        // 画像用バッファの確保
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Graphicsオブジェクトの生成
        Graphics g = bi.getGraphics();
        // HTTPリクエストのエンコーディングを UTF-8 とする
        request.setCharacterEncoding("utf-8");

        // この部分を完成させる
        String x_axis;
        String y_axis;
        int i=0,j=0,hairetu = 0;
        int y_value = 6;
        int gakka = Integer.parseInt(request.getParameter("gakka"));
        /*if(gakka_s == "Ｍ") {
          gakka = 1;
        } else if(gakka_s == "Ａ") {
          gakka = 2;
        } else if(gakka_s == "Ｊ") {
          gakka = 3;
        } else if(gakka_s == "Ｊ") {
          gakka = 4;
        } else if(gakka_s == "Ｋ") {
          gakka = 5;
        }*/
        g.setColor(Color.white);
        g.fillRect(0,0,900,900);
        g.setColor(Color.black);
        g.drawLine(50,50,50,850);
        g.drawLine(50,850,850,850);
        Font f1 = new Font("SansSerif",Font.PLAIN,18);
        g.setFont(f1);
        if(gakka == 1){
          g.drawString("求人企業数(機械工学科)",25,25);
        }else if(gakka == 2){
          g.drawString("求人企業数(電気電子工学科)",25,25);
        }else if(gakka == 3){
          g.drawString("求人企業数(情報工学科)",25,25);
        }else if(gakka == 4){
          g.drawString("求人企業数(物質工学科)",25,25);
        }else if(gakka == 5){
          g.drawString("求人企業数(環境都市工学科)",25,25);
        }
        g.drawString("No,23 中村太一",750,25);
        for(i=0;i<801;i = i + 200) {
          x_axis = String.valueOf(i);
          g.drawString(x_axis,20,850-i);
        }
        g.drawString("年度",900,850);

        for(i=60;i<801 ;i = i + 30) {
          y_axis = String.valueOf(y_value);
          g.drawString(y_axis,i,875);
          g.setColor(Color.green);
          for(j=24;j>-1;j--) {
            if(y_value == kdata[j][0]) { 
              g.fillRect(i,850-(kdata[j][gakka]),16,kdata[j][gakka]);
            }
          }
          g.setColor(Color.black);
          y_value = y_value + 1;
        }
        // 画像出力に必要な処理
        ServletOutputStream sout = response.getOutputStream();
        Iterator ite = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter w = (ImageWriter) ite.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(sout);
        w.setOutput(ios);
        w.write(bi);

        // 終了処理
        sout.close();
        g.dispose();
    }
}
