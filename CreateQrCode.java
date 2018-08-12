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
				+ "FN:����"+"\n"
				+ "NICKNAME:�ڵ�"+"\n"
				+ "ORG:��ɽ�صڶ��߼���ѧ"+"\n"
				+ "TITLE:������"+"\n"
				+ "TEL;HOME;VOICE:13569739272"+"\n"
				+ "ADR;WORK:;�����й�ɽ��"+"\n"
				+ "ADR;HOME:;;�����й�ɽ��"+"\n"
				+ "X-QQ:1779224164"+"\n"
				+ "END:VCARD";
		//String content = "http://www.imooc.com";
		try {
			//;POSTAL;PARCEL
			//���������������
			content = new String(content.getBytes("utf-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		//��Ҫչʾ�Ķ�ά�����������ڼ�����
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
