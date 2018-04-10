package common.view;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client.ClientInterface;
import server.ServerInterface;
import common.utility.Host;
import common.utility.Port;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application implements ClientInterface
{

	private Port port = Port.getInstance();
	private Host host = Host.getInstance();

	private static ServerInterface server;

	public Client() throws RemoteException
	{

		UnicastRemoteObject.exportObject(this, 0);
		makeConnectionToServer();

	}

	public static void main(String[] args)
	{

		try
		{

			launch(args);

			ClientInterface client = new Client();

		}

		catch (RemoteException e)
		{

			e.printStackTrace();
		}

	}

	private void makeConnectionToServer()
	{
		try
		{

			server = (ServerInterface) Naming.lookup("rmi://" + host.get() + ":" + port.get() + "/server");

		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/common/view/Login.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();

	}
	
	

}
