package barcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class BacodeCreate {

	public static void main(String[] args) {
		try {
			String contents = "N124053-0821";
			BarcodeFormat format = BarcodeFormat.CODE_128;
			int width = 200;
			int height = 50;
			Code128Writer writer = new Code128Writer();
			BitMatrix bitMatrix = writer.encode(contents, format, width, height);
			BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
			ImageIO.write(image, "png", new File("barcode.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}
}
