package com.cn.unit.img;


public class Test {

	public static void main(String[] args) {
		
		// 图片路径
        String imgPath = "d:/2.jpg";
        // 水印图片
        String iconPath = "d:/1.png";
        
        // 获取原图片宽度和高度
        int[] exif = ImageExifUtil.getImgWH(imgPath);
        int boxWidth = 640;
        if(exif[0]<boxWidth){
        	boxWidth = exif[0];
        }
        // 压缩图片
        ImageReduceUtil.resizeFix(imgPath, imgPath, boxWidth, 1f);

        // 获取压缩后图片宽度和高度
        int[] imgExif = ImageExifUtil.getImgWH(imgPath);
        // 获取水印图片宽度和高度
        int[] iconExif = ImageExifUtil.getImgWH(iconPath);
        
        // 计算图片水印的坐标
        Integer width = imgExif[0]/2-iconExif[0]/2;
		Integer height = imgExif[1]/2-iconExif[1]/2;
        
        System.out.println("给图片添加水印图片开始...");
        // 初始化添加水印参数
        ImageRemarkUtil.setImageMarkOptions(0.7f, width, height, null, null);
        // 给图片添加水印图片
        ImageRemarkUtil.markImageByIcon(iconPath, imgPath, imgPath);
        System.out.println("给图片添加水印图片结束...");
	}

}
