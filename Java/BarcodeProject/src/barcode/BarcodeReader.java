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
			 * �摜�f�[�^��ǂݍ���
			 * �摜�f�[�^��ǂݍ��񂾂�A�ʂ̃t�@�C���ŕۑ�����
			 */
			BufferedImage image = ImageIO.read(new File(input));
			FileWriter file = new FileWriter("file.txt");
			BufferedWriter bw = new BufferedWriter(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap bitmap = new BinaryBitmap(binarizer);
			//Code128�ǂݍ���
			Code128Reader reader = new Code128Reader();
			Result rs = reader.decode(bitmap);
			//�Ԃ����ʂ�String�ϐ���ϊ�����
			String r = String.valueOf(rs);
			bw.write(r);
			bw.close();
		}
		catch(NotFoundException e) {
			 System.err.println("[" + input + "] �C���[�W�̒��Ƀo�[�R�[�h��������Ȃ����߃f�R�[�h�ŗ�O������.");
	         e.printStackTrace();
		}
		catch (FormatException e) {
            System.err.println("[" + input + "] �͏����s���̂��߃f�R�[�h�ŗ�O������.");
            e.printStackTrace();
        } 
		catch (IOException e) {
            System.err.println("[" + input + "] ��ǂݍ��ނƂ��ɗ�O������.");
            e.printStackTrace();
        }
	}
}
