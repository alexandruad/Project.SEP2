package common.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ItemList implements Serializable {

	private ArrayList<Item> items;

	public ItemList() {
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public int getSize() {
		return items.size();
	}
	
	public void clear() {
		items.clear();
	}
	public void remove(int itemId)
	{
		for(int i =0;i<items.size();i++)
		{
		   if(items.get(i).getItemId() == itemId)
		   {
		      items.remove(i);
		   }
		}
	}

	public ArrayList<Item> getAllItems() {
		return items;
	}

	public Item createItem(int caseNumber1, String offenseLocation, int number,
			String offenseType, String suspect, int itemId) {
		Item temp = new Item(caseNumber1, offenseLocation, number, offenseType,
				suspect, itemId);
		items.add(temp);
		return temp;
	}

	public Item createItem(int caseNumber1, int caseNumber2, int caseNumber3,
			int caseNumber4, String offenseLocation, int number,
			String offenseType, String evidenceDiscription,
			String evidenseType, String victim, String suspect,
			String reasonSiezed, Date dateOfRecovery, String recoveredBy,
			String locationOfRecovery, String transportedBy,
			String temporaryLocation, String evidenceRoomLocation,
			boolean caseStatus, String caseOfficer, String disposition,
			Date dateOfDisposition, int itemId) {
		Item temp = new Item(caseNumber1, caseNumber2, caseNumber3,
				caseNumber4, offenseLocation, number, offenseType,
				evidenceDiscription, evidenseType, victim, suspect,
				reasonSiezed, dateOfRecovery, recoveredBy, locationOfRecovery,
				transportedBy, temporaryLocation, evidenceRoomLocation,
				caseStatus, caseOfficer, disposition, dateOfDisposition, itemId );
		items.add(temp);
		return temp;
	}

	// search by ID
	public ArrayList<Item> getFilteredItemListById(int ID) {

		ArrayList<Item> temp = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItemId() == ID) {
				temp.add(items.get(i));
			}
		}

		return temp;
	}

	
	public ArrayList<Item> getFilteredItemList(String searchType,
         String searchText) {
      ArrayList<Item> filteredItemList = new ArrayList<Item>();
      
      switch (searchType.toLowerCase().trim()) {
      case "itemid":
         for (Item item : items) {
            if (item.getItemId() == Integer.parseInt(searchText.trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "casenumber1":
         for (Item item : items) {
            if (item.getCaseNumber1() == Integer
                  .parseInt(searchText.trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "casenumber2":
         for (Item item : items) {
            if (item.getCaseNumber2() == Integer
                  .parseInt(searchText.trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "casenumber3":
         for (Item item : items) {
            if (item.getCaseNumber3() == Integer
                  .parseInt(searchText.trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "casenumber4":
         for (Item item : items) {
            if (item.getCaseNumber4() == Integer
                  .parseInt(searchText.trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "caseofficer":
         for (Item item : items) {
            if (item.getCaseOfficer().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "dateofdisposition": {
         String[] s = searchText.split("/");
         Date date = new Date(Integer.parseInt(s[0]),
               Integer.parseInt(s[1]), Integer.parseInt(s[2]));
         for (Item item : items) {
            if (date.equals(item.getDateOfDisposition())) {
               filteredItemList.add(item);
            }

         }
      }
         break;
      case "dateofrecovery": {
         String[] s = searchText.split("/");
         Date date = new Date(Integer.parseInt(s[0]),
               Integer.parseInt(s[1]), Integer.parseInt(s[2]));
         for (Item item : items) {
            if (date.equals(item.getDateOfRecovery())) {
               filteredItemList.add(item);
            }

         }
      }
         break;
      case "disposition":
         for (Item item : items) {
            if (item.getDisposition().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }

         }
         break;

      case "offensetype":
         for (Item item : items) {
            if (item.getOffenseType().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "offenselocation":
         for (Item item : items) {
            if (item.getOffenseLocation().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;

      case "evidencedescription":
         for (Item item : items) {
            if (item.getEvidenceDiscription().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;

      case "evidencetype":
         for (Item item : items) {
            if (item.getEvidenseType().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;

      case "evidenceroomlocation":
         for (Item item : items) {
            if (item.getEvidenceRoomLocation().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "locationofrecovery":
         for (Item item : items) {
            if (item.getLocationOfRecovery().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "number":
         for (Item item : items) {
            if (item.getNumber() == Integer
                  .parseInt(searchText.trim())) {
               filteredItemList.add(item);
            }

         }
         break;
      case "resonsiezed":
         for (Item item : items) {
            if (item.getReasonSiezed().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "recoveredby":
         for (Item item : items) {
            if (item.getRecoveredBy().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "temporarylocation":
         for (Item item : items) {
            if (item.getTemporaryLocation().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "transportedby":
         for (Item item : items) {
            if (item.getTransportedBy().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;


      case "victim":
         for (Item item : items) {
            if (item.getVictim().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;
      case "iscasestatus":
         for (Item item : items) {
            if (item.isCaseStatus()) {
               filteredItemList.add(item);
            }
         }
         break;

      case "suspect":
         for (Item item : items) {
            if (item.getSuspect().toLowerCase().trim()
                  .contains(searchText.toLowerCase().trim())) {
               filteredItemList.add(item);
            }
         }
         break;

      default:
         break;
      }
      return filteredItemList;
   }

   @Override
   public String toString() {
      String s = "";

      for (Item item : items)
         s += item.toString() + "\n";

      return s;
   }

}
