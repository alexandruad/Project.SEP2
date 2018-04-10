package common.controller;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import common.model.Item;
import common.model.ItemList;
import common.utility.Host;
import common.utility.Port;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import server.ServerInterface;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

public class UserViewController
{
	private Port port = Port.getInstance();
	private Host host = Host.getInstance();

	private ServerInterface server;

	ItemList itemList = new ItemList();

	ArrayList<String> choiceBoxItems = new ArrayList<String>();

	@FXML
	private Pane userPane;

	@FXML
	private Button quitButton;

	@FXML
	private Button LogoutButton;

	@FXML
	private Button SearchButton;

	@FXML
	ListView<Item> ListView = new ListView<Item>();

	@FXML
	private ChoiceBox<String> ChoiceBox = new ChoiceBox<String>();

	@FXML
	private TextArea SearchField;

	@FXML
	private Button backToList;

	public void initialize()
	{
		makeConnectionToServer();
		this.choiceBoxItems.add("ItemID");
		// this.choiceBoxItems.add("CaseNumber");
		this.choiceBoxItems.add("DateOfRecovery");
		this.choiceBoxItems.add("Offense");
		this.choiceBoxItems.add("OffenseLocation");
		this.choiceBoxItems.add("EvidenceDescription");
		this.choiceBoxItems.add("EvidenceType");
		this.choiceBoxItems.add("EvidenceRoomLocation");
		this.choiceBoxItems.add("Victim");
		this.choiceBoxItems.add("Suspect");
		this.choiceBoxItems.add("RecoveredBy");
		this.choiceBoxItems.add("TransportedBy");

		ChoiceBox.getItems().setAll(choiceBoxItems);
		ChoiceBox.getSelectionModel().selectFirst();

		try
		{

			
			this.ListView.getItems().setAll(server.getAll().getAllItems());
			// ListView.getItems().setAll(server.getAll().getAllItems());
			// itemList = server.getAll();
		}
		catch (RemoteException e)
		{
		}
	}

	@FXML
	void onBackToListButton(ActionEvent event)
	{
		try
		{
			this.ListView.getItems().setAll(server.getAll().getAllItems());
		}
		catch (RemoteException e)
		{
		}
	}

	@FXML
	void onSearchButton(ActionEvent event) throws RemoteException
	{

		if (SearchField.getText().trim().isEmpty())
		{
			ListView.getItems().setAll(server.getAll().getAllItems());
		}
		else
		{
			String param = SearchField.getText();
			try
			{
				ListView.getItems().setAll(server.getFilteredItemList(ChoiceBox.getValue(), param));
			}
			catch (NumberFormatException e)
			{
				System.out.println("Wrong format: Enter a number.");
			}
			catch (NullPointerException e)
			{
				System.out.println("Wrong format: Enter a string.");
			}
		}

	}

	@FXML
	void onLogout(ActionEvent event) throws IOException
	{
		Stage stage = (Stage) LogoutButton.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/common/view/Login.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void onQuitButton(ActionEvent event)
	{
		System.exit(0);
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

	@FXML
	void onKeyPress(KeyEvent event) throws IOException
	{
		switch (event.getCode())
		{
		case F1:
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/common/view/HelpUserView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Help Window");
			stage.setScene(new Scene(root1));
			stage.show();
		default:
			break;
		}
	}

}