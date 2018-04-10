package common.mediator;

import common.model.Date;
import common.model.Item;
import common.model.ItemList;

public interface ModelManagerInterface {

	public ItemList getAll();

	public void removeItem(int  itemId);

	public int getNumberOfItems();

	
	public ItemList update(int itemId, String whatToChange, String changeWithThis);
	
	public Item createItem(int caseNumber1, int caseNumber2, int caseNumber3,
			int caseNumber4, String offenseLocation, int number,
			String offenseType, String evidenceDiscription,
			String evidenseType, String victim, String suspect,
			String reasonSiezed, Date dateOfRecovery, String recoveredBy,
			String locationOfRecovery, String transportedBy,
			String temporaryLocation, String evidenceRoomLocation,
			boolean caseStatus, String caseOfficer, String disposition,
			Date dateOfDisposition, int itemId);

	

	public void clear();

}
