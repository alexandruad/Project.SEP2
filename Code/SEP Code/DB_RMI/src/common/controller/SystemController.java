package common.controller;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import common.mediator.Server;
import common.model.Item;
import common.model.ItemList;
import common.utility.Host;
import common.utility.Port;
import common.view.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import server.ServerInterface;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class SystemController
{
	private Port port = Port.getInstance();
	private Host host = Host.getInstance();

	Item item;

	ObservableList<Item> list;

	private ServerInterface server;

	ArrayList<String> choiceBoxItems = new ArrayList<String>();

	@FXML
	private Pane systemPane;

	@FXML
	private Button addButton;

	@FXML
	private Button EditButton;

	@FXML
	private Button RemoveButton;

	@FXML
	private Button SearchButton;

	@FXML
	private Button quitButton = new Button();

	@FXML
	ListView<Item> ListView = new ListView<Item>();;

	@FXML
	private ChoiceBox<String> ChoiceBox = new ChoiceBox<String>();

	@FXML
	TextArea SearchField = new TextArea();

	@FXML
	private Button LogoutButton;

	@FXML
	private Button backToList;

	@FXML
	public void initialize()
	{
		makeConnectionToServer();

		this.choiceBoxItems.add("ItemID");
		//this.choiceBoxItems.add("CaseNumber");
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

			list = FXCollections.observableList(server.getAll().getAllItems());
			this.ListView.getItems().setAll(server.getAll().getAllItems());
			// ListView.getItems().setAll(server.getAll().getAllItems());
			// itemList = server.getAll();
		}
		catch (RemoteException e)
		{
		}

	}

	@FXML
	void onAddButton(ActionEvent event) throws IOException
	{
		Stage currentStage = (Stage) this.addButton.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/common/view/AddView.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Add evidence");
		stage.setScene(new Scene(root1));
		stage.show();
		currentStage.close();
	}

	@FXML
	void onEditButton(ActionEvent event) throws IOException
	{

		if (!ListView.getSelectionModel().isEmpty())

		{
			item = ListView.getSelectionModel().getSelectedItem();

			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/common/view/EditView.fxml").openStream());
			EditController ec = (EditController) loader.getController();

			ec.setAllFields(item.getCaseNumber1(), item.getCaseNumber2(), item.getCaseNumber3(), item.getCaseNumber4(),
					item.getOffenseLocation(), item.getNumber(), item.getOffenseType(), item.getEvidenceDiscription(),
					item.getEvidenseType(), item.getVictim(), item.getSuspect(), item.getReasonSiezed(),
					item.getDateOfRecovery(), item.getRecoveredBy(), item.getLocationOfRecovery(),
					item.getTransportedBy(), item.getTemporaryLocation(), item.getEvidenceRoomLocation(),
					item.isCaseStatus(), item.getCaseOfficer(), item.getDisposition(), item.getDateOfDisposition(),
					item.getItemId());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
			Stage stage1 = (Stage) this.addButton.getScene().getWindow();
			stage1.close();
			
			stage.show();

		}
	}

	@FXML
	void onRemoveButton(ActionEvent event)
	{
		if (!ListView.getSelectionModel().isEmpty())
		{
			Item item = ListView.getSelectionModel().getSelectedItem();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Removal Confirmation");
			alert.setHeaderText("Confirm that you want to delete the selected item.");
			alert.setContentText("Are you sure?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
			{

				try
				{
					server.removeItem(item.getItemId());
					ListView.getItems().setAll(server.getAll().getAllItems());
				}
				catch (RemoteException e)
				{
				}
			}
			else
			{
				alert.close();
			}
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
	void onKeyPress(KeyEvent event) throws IOException
	{
		switch (event.getCode())
		{
		case F1:
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/common/view/HelpView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Help Window");
			stage.setScene(new Scene(root1));
			stage.show();
		default:
			break;
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

	public void setListView(ArrayList<Item> list)
	{
		this.ListView.getItems().setAll(list);
	}

}
