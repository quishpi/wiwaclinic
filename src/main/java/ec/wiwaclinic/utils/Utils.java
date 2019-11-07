package ec.wiwaclinic.utils;

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

	public static Boolean validarRuc(String numced) {
		if (numced.length() != 13) {
			return false;
		}
		String cedula = numced.substring(0, 10);
		String cerocerouno = numced.substring(10, 13);
		if (!cerocerouno.equals("001")) {
			return false;
		}

		return validarCedula(cedula);
	}

	public static Boolean validarCedula(String numced) {

		if (numced.isEmpty()) {
			return false;
		}
		Integer tam = numced.length();// ontiene el numero de digitos de numced
		Integer i = 0;// contador
		Integer suma = 0;// almacena la suma de la multiplicacion de los 8 digitos primeros
		Integer ban = 2;// para multiplicar con 2 o 1
		Integer comp;// calcula el valor resultante restando del inmediato superior para comparar
		if (tam == 10) {
			for (i = 0; i < 9; i++) { // multiplica por 2 o 1 los nueve primeros digitos
				// almacena la suma de los resultados en sum.
				int mul = 0;
				int aux = 0;// variables auxiliar temporal
				aux = Integer.parseInt(Character.toString(numced.charAt(i)));
				if (ban == 2) {
					mul = aux * 2;
					ban = 1;
				} else {
					if (ban == 1) {
						mul = aux * 1;
						ban = 2;
					}
				}
				if (mul > 9) {
					mul = mul - 9;
				}
				suma = suma + mul;
			}

			if (suma.toString().substring(1, 1).equals("0")) {
				comp = 0;
			} else { // resta la suma de los 9 digitos del mediato superior para
				// comparar con el ultimo digito de la cedula
				comp = Integer.parseInt(Character.toString(suma.toString().charAt(0))) + 1;
				comp = comp * 10;
				comp = comp - suma;
			}
			// Compara con el ultimo digito
			if (Character.toString(numced.charAt(9)).equals(comp.toString())) {
				return true;// CEDULA CORRECTO
			} else {
				return false;
			} // CEDULA INCORRECTO
		} else {
			if (tam < 10) {
				return false;// < 10 caracteres
			}
			if (tam > 10) {
				return false;// > 10 caracteres
			}
		} // fin if (tam==10)
		return true;
	}

}
