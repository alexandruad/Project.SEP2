package common.mediator;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.model.Date;
import common.model.Item;
import common.model.ItemList;
import common.utility.Port;
import server.ServerInterface;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements ServerInterface
{
	private static Port port = Port.getInstance();
	private ModelManager modelManager;

	public Server() throws RemoteException
	{
		super();

		this.modelManager = new ModelManager();

	}

	public static void main(String[] args)
	{
		makeARegistryBinding();

	}

	private static void makeARegistryBinding()
	{
		try
		{
			@SuppressWarnings("unused")
			Registry reg = LocateRegistry.createRegistry(port.get());
			ServerInterface rmiServer = new Server();
			Naming.rebind("server", rmiServer);
			System.out.println("Starting server...");
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public ItemList getAll()
	{
		return modelManager.getAll();
	}

	@Override
	public void removeItem(int itemId)
	{
		modelManager.removeItem(itemId);

	}

	@Override
	public int getNumberOfItems()
	{
		return modelManager.getNumberOfItems();
	}

	@Override
	public ArrayList<Item> getFilteredItemListByID(int ID) throws RemoteException
	{
		return modelManager.getFilteredItemListByID(ID);
	}

	@Override
	public ArrayList<Item> getFilteredItemList(String searchType, String searchText) throws RemoteException
	{
		return modelManager.getFilteredItemList(searchType, searchText);
	}

	@Override
	public void update(int itemId, String whatToChange, String changeWithThis)
	{
		modelManager.update(itemId, whatToChange, changeWithThis);

	}

	@Override
	public Item createItem(int caseNumber1, int caseNumber2, int caseNumber3, int caseNumber4, String offenseLocation,
			int number, String offenseType, String evidenceDiscription, String evidenseType, String victim,
			String suspect, String reasonSiezed, Date dateOfRecovery, String recoveredBy, String locationOfRecovery,
			String transportedBy, String temporaryLocation, String evidenceRoomLocation, boolean caseStatus,
			String caseOfficer, String disposition, Date dateOfDisposition, int itemId) throws RemoteException
	{
		return modelManager.createItem(caseNumber1, caseNumber2, caseNumber3, caseNumber4, offenseLocation, number,
				offenseType, evidenceDiscription, evidenseType, victim, suspect, reasonSiezed, dateOfRecovery,
				recoveredBy, locationOfRecovery, transportedBy, temporaryLocation, evidenceRoomLocation, caseStatus,
				caseOfficer, disposition, dateOfDisposition, itemId);
	}

}
