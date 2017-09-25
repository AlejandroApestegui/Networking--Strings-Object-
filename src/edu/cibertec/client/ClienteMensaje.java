package edu.cibertec.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteMensaje {

	public static void main(String[] args) {
		String host = "localhost"; 
		int puerto = 1000;
		String mensaje = "Hola";
		
		try(Socket socketCliente = new Socket(host, puerto);
			OutputStream flujoSalida = socketCliente.getOutputStream();
			PrintWriter escritor  = new PrintWriter(flujoSalida, true);)
		{
			escritor.println(mensaje);
			System.out.println("Mensaje Enviado");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
