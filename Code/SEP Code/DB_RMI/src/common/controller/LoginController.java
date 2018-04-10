package common.controller;

import java.io.IOException;
import java.rmi.Naming;
import java.util.ArrayList;

import common.model.Item;
import common.utility.Host;
import common.utility.Port;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server.ServerInterface;

public class LoginController
{

	
	private static final String Admin_Username = "admin";
	private static final String Admin_Password = "admin";
	
	private static final String User_Username = "user";
	private static final String User_Password = "user";
	
	private ServerInterface server;
	private ArrayList<Item> list = new ArrayList<>();
	
	@FXML
	private TextField UsernameField;

	@FXML
	private PasswordField PasswordField;

	@FXML
	private Button LoginButton;

	@FXML
	private Button CloseButton;

	@FXML
	void onCloseButton(ActionEvent event)
	{
		System.exit(0);
	}

	@FXML
	void onLoginButton(ActionEvent event) throws IOException
	{
		Stage stage = null;
		Parent root = null;
		
		if(this.UsernameField.getText().equals(Admin_Username) && this.PasswordField.getText().equals(Admin_Password))
		{
			
		 stage = (Stage) LoginButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/common/view/StartView.fxml"));

		}
		else if(this.UsernameField.getText().equals(User_Username) && this.PasswordField.getText().equals(User_Password))
		{
			stage = (Stage) LoginButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/common/view/UserView.fxml"));
		}
		else
		{
			return;
		}
		stage.setTitle("Evidence Managment Software");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	


}