import net.glxn.qrgen.javase.QRCode;
import net.glxn.qrgen.core.image.ImageType;

public class QrCodeEncoder {
    public byte[] encode(String text) {
        return QRCode.from(text).to(ImageType.PNG).stream().toByteArray();
    }
}
