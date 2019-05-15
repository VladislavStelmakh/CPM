package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public List<Usuario> usuarios = new ArrayList<Usuario>();

	public void read(String archivo) throws Exception {
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String fileRead = br.readLine();

			while (fileRead != null)
			{
				String[] token = fileRead.split(":");

				String DNI = String.valueOf(token[0]);
				String nombre = String.valueOf(token[1]);
				String apellidos = String.valueOf(token[2]);
				String contraseña = String.valueOf(token[3]);

				Usuario usuario = new Usuario(DNI, nombre, apellidos, contraseña);

				usuarios.add(usuario);
				
				fileRead = br.readLine();
			}
			
			br.close();
		}
		
		
		// handle exceptions
		catch (FileNotFoundException fnfe)
		{
			System.out.println("file not found");
		}

		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

	}
	
	public void print(List<Usuario> usuarios) {
		for(Usuario usuario : usuarios) {
			System.out.println("DNI: " + usuario.getDNI() + " Nombre: " + usuario.getNombre() + 
					" Apellidos: " + usuario.getApellidos() + " Contraseña: " + usuario.getContraseña());
		}
	}

}
