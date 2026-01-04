package eu.beanstalk.api.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ServerSocket
{
	private String ip;
	private int port;

	public ServerSocket(String ip, int port)
	{
		this.ip = ip;
		this.port = port;
	}

	public boolean isConnection()
	{
		try
		{
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port), 100);
			socket.close();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public String[] getData()
	{
		try {
			Socket s = new Socket();
			s.connect(new InetSocketAddress(ip, port), 100);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in = new DataInputStream(s.getInputStream());

			out.write(0xFE);

			StringBuilder str = new StringBuilder();

			int b;
			while ((b = in.read()) != -1) {
				if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
					str.append((char) b);
				}
			}

			String[] data = str.toString().split("§");
			s.close();
			return data;
		} catch (IOException e) {
			return new String[] {"", "0", "0"};
		}
	}

	public String getIp()
	{
		return ip;
	}

	public int getPort()
	{
		return port;
	}
}
