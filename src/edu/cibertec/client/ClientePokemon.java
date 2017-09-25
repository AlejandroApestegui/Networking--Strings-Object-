package edu.cibertec.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import edu.cibertec.bean.Pokemon;

public class ClientePokemon {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 1000;
		Pokemon pokemon = new Pokemon(1, "Pikachu", null);
		
		try(Socket socketCliente = new Socket(host, puerto)){
			
			OutputStream outputStream = socketCliente.getOutputStream();
			ObjectOutputStream escritor = new ObjectOutputStream(outputStream);
			escritor.writeObject(pokemon);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
