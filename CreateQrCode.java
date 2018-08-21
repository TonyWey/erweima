package ewm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQrCode {

	public static void main(String[] args) {
		int height = 300;
		int width = 300;
		String format = "png";
//		try {
//			PrintWriter out = new PrintWriter(new File("d:\\wd.txt"));
//			 out.println("");
//		} catch (FileNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		String content = "BEGIN:VCARD"+"\n"
				+ "VERSION:2.1"+"\n"
				+ "FN:李逵"+"\n"
				+ "NICKNAME:黑旋风"+"\n"
				+ "ORG:光山县第二高级中学"+"\n"
				+ "TITLE:高中生"+"\n"
				+ "TEL;HOME;VOICE:13569739272"+"\n"
				+ "ADR;WORK:;信阳市光山县"+"\n"
				+ "ADR;HOME:;;信阳市光山县"+"\n"
				+ "X-QQ:1779224164"+"\n"
				+ "END:VCARD";
		//String content = "http://www.imooc.com";
		try {
			//;POSTAL;PARCEL
			//解决中文乱码问题
			content = new String(content.getBytes("utf-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		//将要展示的二维码内容设置在集合中
		HashMap hash = new HashMap();
		hash.put(EncodeHintType.CHARACTER_SET, "ISO-8859-1");
		hash.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
		
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
			//Path file = new File("D:/code/img.png").toPath();
			File file = new File("d:\\img2.png");
			try {
				
				MatrixToImageWriter.writeToFile(bitMatrix, format, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (WriterException e) {
			e.printStackTrace();
		}

	}

}
