package edu.cibertec.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServidorMensajes {

	private int puerto;
	private boolean prendido;
	private ServerSocket serverSocket;

	public ServidorMensajes(int puerto) throws IOException {
		this.puerto = puerto;
		this.serverSocket = new ServerSocket(puerto);
		System.err.println("El servidor ha sido creado en el puerto => " + this.puerto);
	}

	public void iniciarServidor() {
		this.prendido = true;
		System.out.println("Servidor Iniciado - Hora =>" + LocalDateTime.now());
		InputStream flujoEntrada = null;
		BufferedReader lectorFlujo = null;

		while (this.prendido) {

			try (Socket conexionEntrante = serverSocket.accept()) {
				InetAddress infoCliente = conexionEntrante.getInetAddress();
				System.err.println("Conexion recibida desde => " + infoCliente.getHostName());
				long inicio = System.nanoTime();
				flujoEntrada = conexionEntrante.getInputStream();
				lectorFlujo = new BufferedReader(new InputStreamReader(flujoEntrada));
				String mensaje = lectorFlujo.readLine();
				System.err.println("Mensaje recibido => " + mensaje);
				long fin = System.nanoTime();
				double tt = (fin - inicio) / 1000000000.0;
				System.err.println(String.format("Tiempo de proceso => + %.4f", tt));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					flujoEntrada.close();
					lectorFlujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public void apagarServidor() {
		this.prendido = false;
		System.out.println("Hora de finalización => " + LocalDateTime.now());
	}

	public static void main(String[] args) {
		ServidorMensajes servidorMensajes = null;
		
		try {
			servidorMensajes = new ServidorMensajes(1000);
			servidorMensajes.iniciarServidor();
		} catch (IOException e) {
			servidorMensajes.apagarServidor();
			e.printStackTrace();
		}
	}

}
