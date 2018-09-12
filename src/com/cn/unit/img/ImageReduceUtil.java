package com.cn.unit.img;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩工具类
 * @author 10011037@qq.com 
 * 2016-02-12
 */
@SuppressWarnings("restriction")
public class ImageReduceUtil {

	protected static Logger logger = LoggerFactory.getLogger(ImageReduceUtil.class);

	/**
	 * 裁剪并压缩、使用方型区域颜色平均算法
	 * @param originalFile 原文件
	 * @param resizedFile 目标文件
	 * @param boxWidth 缩略图最大宽度
	 * @param quality 缩略图质量
	 * @throws IOException
	 */
	public static void resizeFix(String originalPath, String resizedPath,
			int boxWidth, float quality) {
		File originalFile = new File(originalPath);
		File resizedFile = new File(resizedPath);
		if (quality > 1) {
			quality = 1;
		}

		ImageIcon ii = null;
		try {
			ii = new ImageIcon(originalFile.getCanonicalPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image i = ii.getImage();
		Image resizedImage = null;

		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);
		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(boxWidth, (boxWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((boxWidth * iWidth) / iHeight,
					boxWidth, Image.SCALE_SMOOTH);
		}

		// 获取图片中的所有像素
		Image temp = new ImageIcon(resizedImage).getImage();

		// 创建缓冲
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

		// 复制图片到缓冲流中
		Graphics g = bufferedImage.createGraphics();

		// 清除背景并开始画图
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// 柔和图片.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);
		bufferedImage.flush();
		try {
			FileOutputStream out = new FileOutputStream(resizedFile);

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

			JPEGEncodeParam param = encoder
					.getDefaultJPEGEncodeParam(bufferedImage);

			param.setQuality(quality, true);

			encoder.setJPEGEncodeParam(param);
			encoder.encode(bufferedImage);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
