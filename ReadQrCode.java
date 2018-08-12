package ewm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ReadQrCode {

	public static void main(String[] args) {

		MultiFormatReader formatReader = new MultiFormatReader();
		File file = new File("d:\\\\img2.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BinaryBitmap binaryBitamp = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		HashMap hash = new HashMap();
		hash.put(EncodeHintType.CHARACTER_SET, "ISO-8859-1");
		try {
			Result result = formatReader.decode(binaryBitamp,hash);
			System.out.println("解析结果:"+result);
			System.out.println("二维码格式类型:"+result.getBarcodeFormat());
			System.out.println("二维码文本内容:"+result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
