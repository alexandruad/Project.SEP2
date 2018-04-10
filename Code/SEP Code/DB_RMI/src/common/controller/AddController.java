package common.controller;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import common.model.Date;
import common.model.Item;
import common.model.ItemList;
import common.utility.Host;
import common.utility.Port;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server.ServerInterface;

public class AddController
{

	private Item item;

	private Port port = Port.getInstance();
	private Host host = Host.getInstance();

	ServerInterface server;

	@FXML
	private TextField CaseNumberField1;

	@FXML
	private TextField CaseNumberField2;

	@FXML
	private TextField CaseNumberField3;

	@FXML
	private TextField CaseNumberField4;

	@FXML
	private TextArea OffenseLocationField = new TextArea();

	@FXML
	private TextField ItemIDField = new TextField();

	@FXML
	private TextField NumberField = new TextField();

	@FXML
	private TextField OffenseTypeField = new TextField();

	@FXML
	private TextArea EvidenceDescriptionField = new TextArea();

	@FXML
	private TextField EvidenceTypeField = new TextField();

	@FXML
	private TextArea VictimComplaintField = new TextArea();

	@FXML
	private TextField SuspectField = new TextField();

	@FXML
	private TextArea ReasonSeizedField = new TextArea();

	@FXML
	private TextField DateOfRecoveryField = new TextField();

	@FXML
	private TextField RecoveredByFeild = new TextField();

	@FXML
	private TextField LocationOfRecoveryField = new TextField();

	@FXML
	private TextField TransportedByField = new TextField();

	@FXML
	private TextField TemporaryLocationField = new TextField();

	@FXML
	private TextField EvidenceRoomLocationField = new TextField();

	@FXML
	private TextField CaseOfficeField = new TextField();

	@FXML
	private TextField DispositionField = new TextField();

	@FXML
	private TextField DateOfDispositionField = new TextField();

	@FXML
	private Button ConfirmButton;

	@FXML
	private Button CancelButton;

	@FXML
	private Button setButton;

	@FXML
	private RadioButton activeRB;

	@FXML
	private RadioButton inactiveRB;

	private SystemController sc = new SystemController();

	@FXML
	void onCancelButton(ActionEvent event) throws IOException
	{

		Stage stage = (Stage) CancelButton.getScene().getWindow();
		stage.close();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/common/view/StartView.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage1 = new Stage();
		stage1.setTitle("Evidence Managment Software");
		stage1.setScene(new Scene(root1));
		stage1.show();

	}

	@FXML
	void onConfirmButton(ActionEvent event) throws IOException
	{

		Stage stage = (Stage) ConfirmButton.getScene().getWindow();
		if (this.CaseNumberField1.getText().trim().isEmpty() || this.CaseNumberField2.getText().trim().isEmpty()
				|| this.CaseNumberField3.getText().trim().isEmpty() || this.CaseNumberField4.getText().trim().isEmpty()
				|| this.OffenseLocationField.getText().trim().isEmpty() || this.NumberField.getText().trim().isEmpty()
				|| this.OffenseTypeField.getText().trim().isEmpty()
				|| this.EvidenceDescriptionField.getText().trim().isEmpty()
				|| this.EvidenceTypeField.getText().trim().isEmpty()
				|| this.VictimComplaintField.getText().trim().isEmpty() || this.SuspectField.getText().trim().isEmpty()
				|| this.ReasonSeizedField.getText().trim().isEmpty()
				|| this.DateOfRecoveryField.getText().trim().isEmpty()
				|| this.RecoveredByFeild.getText().trim().isEmpty()
				|| this.LocationOfRecoveryField.getText().trim().isEmpty()
				|| this.TransportedByField.getText().trim().isEmpty()
				|| this.TemporaryLocationField.getText().trim().isEmpty()
				|| this.EvidenceRoomLocationField.getText().trim().isEmpty()
				|| this.CaseOfficeField.getText().trim().isEmpty() || this.DispositionField.getText().trim().isEmpty()
				|| this.DateOfDispositionField.getText().trim().isEmpty()
				|| this.ItemIDField.getText().trim().isEmpty())
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Form completion");
			alert.setHeaderText(null);
			alert.setContentText("You must fill out all the fields!");

			alert.showAndWait();

			return;
		}

		try
		{
			int caseNumber = Integer.parseInt(this.CaseNumberField1.getText());
			int caseNumber2 = Integer.parseInt(this.CaseNumberField2.getText());
			int caseNumber3 = Integer.parseInt(this.CaseNumberField3.getText());
			int caseNumber4 = Integer.parseInt(this.CaseNumberField4.getText());

			String offenseL = this.OffenseLocationField.getText();

			int numberOfItems = Integer.parseInt(this.NumberField.getText());

			String offenseT = this.OffenseTypeField.getText();
			String evidenceDescription = this.EvidenceDescriptionField.getText();
			String evidenceType = this.EvidenceTypeField.getText();
			String victim = this.VictimComplaintField.getText();
			String suspect = this.SuspectField.getText();
			String reasonSiezed = this.ReasonSeizedField.getText();

			String[] dateContent = this.DateOfRecoveryField.getText().split("/");
			Date dateOfRecovery = new Date(Integer.parseInt(dateContent[0]), Integer.parseInt(dateContent[1]),
					Integer.parseInt(dateContent[2]));

			String recoveredBy = this.RecoveredByFeild.getText();
			String locationOfRecovery = this.LocationOfRecoveryField.getText();
			String transportedBy = this.TransportedByField.getText();
			String temporaryLocation = this.TemporaryLocationField.getText();
			String evidenceRoomLocation = this.EvidenceRoomLocationField.getText();
			boolean caseStatus = true;
			if (this.activeRB.isSelected())
			{
				caseStatus = true;
			}
			else
			{
				caseStatus = false;
			}

			String caseOfficer = this.CaseOfficeField.getText();
			String disposition = this.DispositionField.getText();

			String[] date1Content = this.DateOfDispositionField.getText().split("/");
			Date dateOfDisposition = new Date(Integer.parseInt(date1Content[0]), Integer.parseInt(date1Content[1]),
					Integer.parseInt(date1Content[2]));

			int itemID = Integer.parseInt(this.ItemIDField.getText());

			server.createItem(caseNumber, caseNumber2, caseNumber3, caseNumber4, offenseL, numberOfItems, offenseT,
					evidenceDescription, evidenceType, victim, suspect, reasonSiezed, dateOfRecovery, recoveredBy,
					locationOfRecovery, transportedBy, temporaryLocation, evidenceRoomLocation, caseStatus, caseOfficer,
					disposition, dateOfDisposition, itemID);
		}
		catch (NumberFormatException e)
		{
			return;
		}
		catch (NullPointerException e)
		{
			return;
		}

		Stage stage1 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/common/view/StartView.fxml").openStream());
		SystemController ec = (SystemController) loader.getController();
		sc.SearchField.setText("OII");
		Scene scene1 = new Scene(root);
		stage1.setScene(scene1);
		stage1.show();

		/*
		 * FXMLLoader loader = new FXMLLoader(); Pane root =
		 * loader.load(getClass().getResource("/common/view/StartView.fxml").
		 * openStream()); SystemController sc = (SystemController)
		 * loader.getController(); //
		 * sc.setItems(FXCollections.observableList(server.getAll().getAllItems(
		 * ))); sc.onBackToListButton(event);
		 */

		stage.close();

	}

	@FXML
	void initialize()
	{
		ToggleGroup group = new ToggleGroup();
		this.activeRB.setToggleGroup(group);
		this.activeRB.setSelected(true);
		this.inactiveRB.setToggleGroup(group);

		makeConnectionToServer();
	}

	public void setFields(int caseNumber, int nrOfItems)
	{
		this.CaseNumberField1.setText(String.valueOf(caseNumber));
		this.NumberField.setText(String.valueOf(nrOfItems));
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

}