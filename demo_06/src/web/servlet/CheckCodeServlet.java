package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Classname ${NAME}
 * @Description 验证码
 * @Date 2022-11-18 20:32
 * @Created by @tb659
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int width = 100;
    int height = 50;

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    Graphics g = image.getGraphics();

    g.setColor(Color.PINK);
    g.fillRect(0, 0, width, height);

    g.setColor(Color.BLUE);
    g.drawRect(0, 0, width - 1, height - 1);

    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdrfghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();
    for (int i = 1; i <= 4; i++) {
      g.drawString(str.charAt(random.nextInt(str.length())) + "", width / 5 * i, height / 2);
    }

    g.setColor(Color.GREEN);
    for (int i = 0; i < 10; i++) {
      int i1 = random.nextInt(width);
      int i2 = random.nextInt(width);
      int i3 = random.nextInt(height);
      int i4 = random.nextInt(height);
      g.drawLine(i1, i2, i3, i4);
    }

    ImageIO.write(image, "jpg", response.getOutputStream());

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
