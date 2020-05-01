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
		String input = "barcode.png";
		try {
			/*
			 * 画像データを読み込む
			 * 画像データを読み込んだら、別のファイルで保存する
			 */
			BufferedImage image = ImageIO.read(new File(input));
			FileWriter file = new FileWriter("file.txt");
			BufferedWriter bw = new BufferedWriter(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap bitmap = new BinaryBitmap(binarizer);
			//Code128読み込む
			Code128Reader reader = new Code128Reader();
			Result rs = reader.decode(bitmap);
			//返す結果はString変数を変換する
			String r = String.valueOf(rs);
			bw.write(r);
			bw.close();
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
