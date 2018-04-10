package common.controller;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import common.model.Date;
import common.model.Item;
import common.utility.Host;
import common.utility.Port;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server.ServerInterface;

public class EditController
{

	ServerInterface server;

	private Port port = Port.getInstance();
	private Host host = Host.getInstance();

	@FXML
	private TextField CaseNumberField1;

	@FXML
	private TextField CaseNumberField2;

	@FXML
	private TextField CaseNumberField3;

	@FXML
	private TextField CaseNumberField4;

	@FXML
	private TextArea OffenseLocationField;

	@FXML
	private TextField ItemIDField;

	@FXML
	private TextField NumberField;

	@FXML
	private TextField OffenseTypeField;

	@FXML
	private TextArea EvidenceDescriptionField;

	@FXML
	private TextField EvidenceTypeField;

	@FXML
	private TextArea VictimComplaintField;

	@FXML
	private TextField SuspectField;

	@FXML
	private TextArea ReasonSeizedField;

	@FXML
	private TextField DateOfRecoveryField;

	@FXML
	private TextField RecoveredByFeild;

	@FXML
	private TextField LocationOfRecoveryField;

	@FXML
	private TextField TransportedByField;

	@FXML
	private TextField TemporaryLocationField;

	@FXML
	private TextField EvidenceRoomLocationField;

	@FXML
	private TextField CaseOfficeField;

	@FXML
	private TextField DispositionField;

	@FXML
	private TextField DateOfDispositionField;

	@FXML
	private Button ConfirmButton;

	@FXML
	private Button CancelButton;

	@FXML
	private RadioButton activeRB;

	@FXML
	private RadioButton inactiveRB;

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
		String caseStatus = "true";
		if (this.activeRB.isSelected())
		{
			caseStatus = "true";
		}
		else
		{
			caseStatus = "false";
		}
		try
		{
			server.update(Integer.parseInt(this.ItemIDField.getText()), "casenumber_1",
					this.CaseNumberField1.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "casenumber_2",
					this.CaseNumberField2.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "casenumber_3",
					this.CaseNumberField3.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "casenumber_4",
					this.CaseNumberField4.getText());

			server.update(Integer.parseInt(this.ItemIDField.getText()), "offencelocation",
					this.OffenseLocationField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "number", this.NumberField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "offencetype", this.OffenseTypeField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "evidencedescription",
					this.EvidenceDescriptionField.getText());

			server.update(Integer.parseInt(this.ItemIDField.getText()), "evidencetype",
					this.EvidenceTypeField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "victim", this.VictimComplaintField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "suspect", this.SuspectField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "reasonsiezed",
					this.ReasonSeizedField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "dateofrecovery",
					this.DateOfRecoveryField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "recoveredby", this.RecoveredByFeild.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "locationofrecoverry",
					this.LocationOfRecoveryField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "transportedby",
					this.TransportedByField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "temporarylocation",
					this.TemporaryLocationField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "evidenceroomlocation",
					this.EvidenceRoomLocationField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "casestatus", caseStatus);
			server.update(Integer.parseInt(this.ItemIDField.getText()), "caseofficer", this.CaseOfficeField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "disposition", this.DispositionField.getText());
			server.update(Integer.parseInt(this.ItemIDField.getText()), "dateofdisposition",
					this.DateOfDispositionField.getText());
		}
		catch (RemoteException e)
		{

		}

		Stage stage = (Stage) CancelButton.getScene().getWindow();

		Stage stage1 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/common/view/StartView.fxml").openStream());
		SystemController sc = (SystemController) loader.getController();
		sc.setListView(server.getAll().getAllItems());
		Scene scene1 = new Scene(root);
		stage1.setScene(scene1);
		stage1.show();

		stage.close();
	}

	public void setAllFields(int caseNumber1, int caseNumber2, int caseNumber3, int caseNumber4, String offenseLocation,
			int number, String offenseType, String evidenceDescription, String evidenceType, String victim,
			String suspect, String reasonSiezed, Date dateOfRecovery, String recoveredBy, String locationOfRecovery,
			String transportedBy, String temporaryLocation, String evidenceRoomLocation, boolean caseStatus,
			String caseOfficer, String disposition, Date dateOfDisposition, int itemId)
	{
		if (caseStatus)
		{
			this.activeRB.setSelected(true);
		}
		else
		{
			this.inactiveRB.setSelected(true);
		}

		String[] dateContent = dateOfRecovery.toString().split("/");
		Date date1 = new Date(Integer.parseInt(dateContent[0]), Integer.parseInt(dateContent[1]),
				Integer.parseInt(dateContent[2]));

		String[] dateContent2 = dateOfDisposition.toString().split("/");
		Date date2 = new Date(Integer.parseInt(dateContent2[0]), Integer.parseInt(dateContent2[1]),
				Integer.parseInt(dateContent2[2]));

		this.CaseNumberField1.setText(String.valueOf(caseNumber1));
		this.CaseNumberField2.setText(String.valueOf(caseNumber2));
		this.CaseNumberField3.setText(String.valueOf(caseNumber3));
		this.CaseNumberField4.setText(String.valueOf(caseNumber4));
		this.OffenseLocationField.setText(offenseLocation);
		this.NumberField.setText(String.valueOf(number));
		this.OffenseTypeField.setText(offenseType);
		this.EvidenceDescriptionField.setText(evidenceDescription);
		this.EvidenceTypeField.setText(evidenceType);
		this.VictimComplaintField.setText(victim);
		this.SuspectField.setText(suspect);
		this.ReasonSeizedField.setText(reasonSiezed);
		this.DateOfRecoveryField.setText(date1.toString());
		this.RecoveredByFeild.setText(recoveredBy);
		this.LocationOfRecoveryField.setText(locationOfRecovery);
		this.TransportedByField.setText(transportedBy);
		this.TemporaryLocationField.setText(temporaryLocation);
		this.EvidenceRoomLocationField.setText(evidenceRoomLocation);
		this.CaseOfficeField.setText(caseOfficer);
		this.DispositionField.setText(disposition);
		this.DateOfDispositionField.setText(date2.toString());
		this.ItemIDField.setText(String.valueOf(itemId));

	}

	@FXML
	public void initialize()
	{
		ToggleGroup group = new ToggleGroup();
		this.activeRB.setToggleGroup(group);
		this.activeRB.setSelected(true);
		this.inactiveRB.setToggleGroup(group);

		makeConnectionToServer();

		this.ItemIDField.setDisable(true);
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
