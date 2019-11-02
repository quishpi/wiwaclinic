package ec.wiwaclinic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Utils {

	public static void redirectToPage(String page) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + page);
		} catch (IOException e) {
			System.out.println("Error Redirect: " + e.getMessage());
		}
	}

	static public byte[] generateImageForDataBase() throws IOException {
		File file = new File("/home/luis/eclipse-workspace/wiwaclinic/src/main/webapp/resources/images/webmarket.jpg");
		byte[] picInBytes = new byte[(int) file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(picInBytes);
		fileInputStream.close();
		return picInBytes;
	}

}
