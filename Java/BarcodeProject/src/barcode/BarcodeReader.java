package barcode;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Reader;

public class BarcodeReader {
	public static final void main(String[] args) throws ChecksumException {
		String input = "C:\\Users\\2016NEC42\\Desktop\\image\\barcode.png";
		try {
			BufferedImage image = ImageIO.read(new File(input));
			FileWriter wr = new FileWriter("C:\\Users\\2016NEC42\\Desktop\\image\\file.txt");
			BufferedWriter wt = new BufferedWriter(wr);
			
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap bitmap = new BinaryBitmap(binarizer);
			Code128Reader reader = new Code128Reader();
			
			Result rs = reader.decode(bitmap);
			
			String r = String.valueOf(rs);
			wt.write(r);
			wt.close();
			System.out.println(rs.getText());

		}
		catch(NotFoundException e) {
			 System.err.println("[" + input + "] イメージの中にバーコードが見つからないためデコードで例外が発生.");
	         e.printStackTrace();
		}
		catch (FormatException e) {
            System.err.println("[" + input + "] は書式不正のためデコードで例外が発生.");
            e.printStackTrace();
        } 
		catch (IOException e) {
            System.err.println("[" + input + "] を読み込むときに例外が発生.");
            e.printStackTrace();
        }
	}
}
