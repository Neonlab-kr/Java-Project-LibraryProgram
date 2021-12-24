package Util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageCheck{
	public static boolean isImage(File file) {
	    /*
	    // Solution 1
	    String mimeType = new MimetypesFileTypeMap().getContentType(file);
	    log.info("MimeType Type = " + mimeType);
	    String type = mimeType.split("/")[0].toLowerCase();
	    log.info("File Type = " + type);
	    return type.equals("image");
	    */
	    boolean b = false;
	    try {
	        b = (ImageIO.read(file) != null);
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(null, "이미지를 찾을 수 없습니다.", "이미지 오류", JOptionPane.ERROR_MESSAGE);
	    }
	    return b;
	}
}