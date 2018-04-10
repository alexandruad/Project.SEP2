package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.model.Date;
import common.model.Item;
import common.model.ItemList;

public interface ServerInterface extends Remote
{
	
	public ItemList getAll() throws RemoteException;;

	public void removeItem(int itemId) throws RemoteException;;

	public int getNumberOfItems() throws RemoteException;;

	public Item createItem(int caseNumber1, int caseNumber2, int caseNumber3, int caseNumber4, String offenseLocation,
			int number, String offenseType, String evidenceDiscription, String evidenseType, String victim,
			String suspect, String reasonSiezed, Date dateOfRecovery, String recoveredBy, String locationOfRecovery,
			String transportedBy, String temporaryLocation, String evidenceRoomLocation, boolean caseStatus,
			String caseOfficer, String disposition, Date dateOfDisposition, int itemId) throws RemoteException;

	public void update(int itemId, String whatToChange, String changeWithThis) throws RemoteException;

	public ArrayList<Item> getFilteredItemListByID(int ID) throws RemoteException;

	public ArrayList<Item> getFilteredItemList(String searchType, String searchText) throws RemoteException;
}
