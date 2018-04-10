package common.mediator;

import java.io.Serializable;
import java.util.ArrayList;

import common.model.Date;
import common.model.Item;
import common.model.ItemList;

@SuppressWarnings("serial")
public class ModelManager implements ModelManagerInterface, Serializable
{

	private ItemList itemList;
	private Persistence persistance;

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String UserName = "postgres";
	private static final String Password = "martomarto96";

	public ModelManager()
	{
		itemList = new ItemList();
		persistance = new DatabaseAdapter(URL, UserName, Password);
		System.out.println(itemList = persistance.getAll());
	}

	@Override
	public ItemList getAll()
	{
		// persistance.getAll();
		return itemList;

	}

	@Override
	public void removeItem(int itemId)
	{
		persistance.remove(itemId);
		itemList.remove(itemId);

	}

	@Override
	public int getNumberOfItems()
	{
		persistance.getNumberOfItems();
		return itemList.getSize();
	}

	public ArrayList<Item> getFilteredItemListByID(int ID)
	{

		return itemList.getFilteredItemListById(ID);

	}

	public ArrayList<Item> getFilteredItemList(String searchType, String searchText)
	{

		return itemList.getFilteredItemList(searchType, searchText);
	}

	@Override
	public void clear()
	{
		itemList.clear();
		persistance.clear();

	}

	@Override
	public Item createItem(int caseNumber1, int caseNumber2, int caseNumber3, int caseNumber4, String offenseLocation,
			int number, String offenseType, String evidenceDiscription, String evidenseType, String victim,
			String suspect, String reasonSiezed, Date dateOfRecovery, String recoveredBy, String locationOfRecovery,
			String transportedBy, String temporaryLocation, String evidenceRoomLocation, boolean caseStatus,
			String caseOfficer, String disposition, Date dateOfDisposition, int itemId)
	{

		persistance.createItem(caseNumber1, caseNumber2, caseNumber3, caseNumber4, offenseLocation, number, offenseType,
				evidenceDiscription, evidenseType, victim, suspect, reasonSiezed, dateOfRecovery, recoveredBy,
				locationOfRecovery, transportedBy, temporaryLocation, evidenceRoomLocation, caseStatus, caseOfficer,
				disposition, dateOfDisposition, itemId);
		return itemList.createItem(caseNumber1, caseNumber2, caseNumber3, caseNumber4, offenseLocation, number,
				offenseType, evidenceDiscription, evidenseType, victim, suspect, reasonSiezed, dateOfRecovery,
				recoveredBy, locationOfRecovery, transportedBy, temporaryLocation, evidenceRoomLocation, caseStatus,
				caseOfficer, disposition, dateOfDisposition, itemId);

	}

	@Override
	public ItemList update(int itemId, String whatToChange, String changeWithThis)
	{
		persistance.update(itemId, whatToChange, changeWithThis);
		itemList.clear();
		itemList = persistance.getAll();

		return itemList;

	}

}
