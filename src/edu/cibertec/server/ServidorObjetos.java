package edu.cibertec.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import edu.cibertec.bean.Pokemon;

public class ServidorObjetos {

	private int puerto;
	private boolean prendido;
	private ServerSocket serverSocket;

	public ServidorObjetos(int puerto) throws IOException {
		this.puerto = puerto;
		this.serverSocket = new ServerSocket(this.puerto);
	}

	public void iniciarServidor() {
		this.prendido = true;

		while (this.prendido) {
			try (Socket conexionEntrante = serverSocket.accept()) {

				InputStream flujoEntrada = conexionEntrante.getInputStream();
				ObjectInputStream lectorObjetos = new ObjectInputStream(flujoEntrada);
				Pokemon pokemon = (Pokemon) lectorObjetos.readObject();

				System.err.println("Datos =>" + pokemon);

				lectorObjetos.close();
				flujoEntrada.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ServidorObjetos servidorObjetos;
		try {
			servidorObjetos = new ServidorObjetos(1000);
			servidorObjetos.iniciarServidor();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
