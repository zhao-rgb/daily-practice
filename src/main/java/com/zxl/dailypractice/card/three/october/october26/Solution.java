package com.zxl.dailypractice.card.three.october.october26;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author: zhaoxl
 * @date: 2023/10/26
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;

        // 创建一个新的BufferedImage
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // 填充背景色（粉色）
        g.setColor(new Color(255, 182, 193)); // 粉色
        g.fillRect(0, 0, width, height);

        // 加载爱心图片
        try {
            BufferedImage heartImage = ImageIO.read(new File("heart.png"));
            int heartWidth = heartImage.getWidth();
            int heartHeight = heartImage.getHeight();

            // 绘制爱心图片
            g.drawImage(heartImage, (width - heartWidth) / 2, 100, null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置字体和文本颜色
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.BLACK);

        // 绘制文本
        String text = "喜欢沈雨坪";
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textX = (width - textWidth) / 2;
        int textY = 350;
        g.drawString(text, textX, textY);

        // 保存生成的图像
        try {
            ImageIO.write(image, "PNG", new File("LoveImage.png"));
            System.out.println("带有爱心图片和文本的图像已生成到 LoveImage.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
