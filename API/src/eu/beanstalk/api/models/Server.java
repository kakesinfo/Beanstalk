package eu.beanstalk.api.models;


public class Server
{	
	private ServerSocket serverSocket;
	private String name;
	private boolean isConnection;
	private int onlinePlayers, maximumPlayers;

	public Server(String name, String ip, int port)
	{
		this.name = name;
		this.serverSocket = new ServerSocket(ip, port);
	}

	public ServerSocket getSocket()
	{
		return serverSocket;
	}

	public void update()
	{	
		isConnection = getSocket().isConnection();
		String data = getFormatedPlayersInformation();
		onlinePlayers = Integer.parseInt(data.split("/")[0]);
		maximumPlayers = Integer.parseInt(data.split("/")[1]);
	}

	public String getFormatedPlayersInformation()
	{
		String[] data = getSocket().getData();
		return data[1] + "/" + data[2];
	}

	public String getName()
	{
		return name;
	}

	public int getOnlinePlayers()
	{	
		return onlinePlayers;	
	}

	public int getMaximumPlayers()
	{
		return maximumPlayers;
	}

	public boolean isConnection()
	{
		return isConnection;
	}
	
}
