package common.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable
{

   private int caseNumber1;
   private int caseNumber2;
   private int caseNumber3;
   private int caseNumber4;
   private String offenseLocation;
   private int itemId;
   private int number;
   private String offenseType;
   private String evidenceDiscription;
   private String evidenseType;
   private String victim;
   private String suspect;
   private String reasonSiezed;
   private Date dateOfRecovery;
   private String recoveredBy;
   private String locationOfRecovery;
   private String transportedBy;
   private String temporaryLocation;
   private String evidenceRoomLocation;
   private boolean caseStatus;
   private String caseOfficer;
   private String disposition;
   private Date dateOfDisposition;

   public Item()
   {

   }

   public Item(int caseNumber1, int nrOfItems)
   {
      this.caseNumber1 = caseNumber1;
      this.number = nrOfItems;
   }

   // simple constructor
   public Item(int caseNumber1, String offenseLocation, int number,
         String offenseType, String suspect, int itemId)
   {

      this.itemId = itemId;
      this.caseNumber1 = caseNumber1;
      this.offenseLocation = offenseLocation;
      this.number = number;
      this.offenseType = offenseType;
      this.suspect = suspect;

   }

   // the whole constructor
   public Item(int caseNumber1, int caseNumber2, int caseNumber3,
         int caseNumber4, String offenseLocation, int number,
         String offenseType, String evidenceDiscription, String evidenseType,
         String victim, String suspect, String reasonSiezed,
         Date dateOfRecovery, String recoveredBy, String locationOfRecovery,
         String transportedBy, String temporaryLocation,
         String evidenceRoomLocation, boolean caseStatus, String caseOfficer,
         String disposition, Date dateOfDisposition, int itemID)
   {
      this.itemId = itemID;
      this.caseNumber1 = caseNumber1;
      this.caseNumber2 = caseNumber2;
      this.caseNumber3 = caseNumber3;
      this.caseNumber4 = caseNumber4;
      this.offenseLocation = offenseLocation;
      this.number = number;
      this.offenseType = offenseType;
      this.evidenceDiscription = evidenceDiscription;
      this.evidenseType = evidenseType;
      this.victim = victim;
      this.suspect = suspect;
      this.reasonSiezed = reasonSiezed;
      this.dateOfRecovery = dateOfRecovery;
      this.recoveredBy = recoveredBy;
      this.locationOfRecovery = locationOfRecovery;
      this.transportedBy = transportedBy;
      this.temporaryLocation = temporaryLocation;
      this.evidenceRoomLocation = evidenceRoomLocation;
      this.caseStatus = caseStatus;
      this.caseOfficer = caseOfficer;
      this.disposition = disposition;
      this.dateOfDisposition = dateOfDisposition;
   }

   public int getItemId()
   {
      return itemId;
   }

   public int getCaseNumber1()
   {
      return caseNumber1;
   }

   public void setCaseNumber1(int caseNumber1)
   {
      this.caseNumber1 = caseNumber1;
   }

   public int getCaseNumber2()
   {
      return caseNumber2;
   }

   public void setCaseNumber2(int caseNumber2)
   {
      this.caseNumber2 = caseNumber2;
   }

   public int getCaseNumber3()
   {
      return caseNumber3;
   }

   public void setCaseNumber3(int caseNumber3)
   {
      this.caseNumber3 = caseNumber3;
   }

   public int getCaseNumber4()
   {
      return caseNumber4;
   }

   public void setCaseNumber4(int caseNumber4)
   {
      this.caseNumber4 = caseNumber4;
   }

   public String getOffenseLocation()
   {
      return offenseLocation;
   }

   public void setOffenseLocation(String offenseLocation)
   {
      this.offenseLocation = offenseLocation;
   }

   public int getNumber()
   {
      return number;
   }

   public void setNumber(int number)
   {
      this.number = number;
   }

   public String getOffenseType()
   {
      return offenseType;
   }

   public void setOffenseType(String offenseType)
   {
      this.offenseType = offenseType;
   }

   public String getEvidenceDiscription()
   {
      return evidenceDiscription;
   }

   public void setOffenseDiscription(String offenseDiscription)
   {
      this.evidenceDiscription = offenseDiscription;
   }

   public String getEvidenseType()
   {
      return evidenseType;
   }

   public void setEvidenseType(String evidenseType)
   {
      this.evidenseType = evidenseType;
   }

   public String getVictim()
   {
      return victim;
   }

   public void setVictim(String victim)
   {
      this.victim = victim;
   }

   public String getSuspect()
   {
      return suspect;
   }

   public void setSuspect(String suspect)
   {
      this.suspect = suspect;
   }

   public String getReasonSiezed()
   {
      return reasonSiezed;
   }

   public void setReasonSiezed(String reasonSiezed)
   {
      this.reasonSiezed = reasonSiezed;
   }

   public Date getDateOfRecovery()
   {
      return dateOfRecovery;
   }

   public void setDateOfRecovery(Date dateOfRecovery)
   {
      this.dateOfRecovery = dateOfRecovery;
   }

   public String getRecoveredBy()
   {
      return recoveredBy;
   }

   public void setRecoveredBy(String recoveredBy)
   {
      this.recoveredBy = recoveredBy;
   }

   public String getLocationOfRecovery()
   {
      return locationOfRecovery;
   }

   public void setLocationOfRecovery(String locationOfRecovery)
   {
      this.locationOfRecovery = locationOfRecovery;
   }

   public String getTransportedBy()
   {
      return transportedBy;
   }

   public void setTransportedBy(String transportedBy)
   {
      this.transportedBy = transportedBy;
   }

   public String getTemporaryLocation()
   {
      return temporaryLocation;
   }

   public void setTemporaryLocation(String temporaryLocation)
   {
      this.temporaryLocation = temporaryLocation;
   }

   public String getEvidenceRoomLocation()
   {
      return evidenceRoomLocation;
   }

   public void setEvidenceRoomLocation(String evidenceRoomLocation)
   {
      this.evidenceRoomLocation = evidenceRoomLocation;
   }

   public boolean isCaseStatus()
   {
      return caseStatus;
   }

   public void setCaseStatus(boolean caseStatus)
   {
      this.caseStatus = caseStatus;
   }

   public String getCaseOfficer()
   {
      return caseOfficer;
   }

   public void setCaseOfficer(String caseOfficer)
   {
      this.caseOfficer = caseOfficer;
   }

   public String getDisposition()
   {
      return disposition;
   }

   public void setDisposition(String disposition)
   {
      this.disposition = disposition;
   }

   public Date getDateOfDisposition()
   {
      return dateOfDisposition;
   }

   public void setDateOfDisposition(Date dateOfDisposition)
   {
      this.dateOfDisposition = dateOfDisposition;
   }

   @Override
   public String toString()
   {
      return "Item [caseNumber1="
            + caseNumber1
            + ", caseNumber2="
            + caseNumber2
            + ", caseNumber3="
            + caseNumber3
            + ", caseNumber4="
            + caseNumber4
            + ", "
            + (offenseLocation != null ? "offenseLocation=" + offenseLocation
                  + ", " : "")
            + "itemId="
            + itemId
            + ", number="
            + number
            + ", "
            + (offenseType != null ? "offenseType=" + offenseType + ", " : "")
            + (evidenceDiscription != null ? "offenseDiscription="
                  + evidenceDiscription + ", " : "")
            + (evidenseType != null ? "evidenseType=" + evidenseType + ", "
                  : "")
            + (victim != null ? "victim=" + victim + ", " : "")
            + (suspect != null ? "suspect=" + suspect + ", " : "")
            + (reasonSiezed != null ? "reasonSiezed=" + reasonSiezed + ", "
                  : "")
            + (dateOfRecovery != null ? "dateOfRecovery=" + dateOfRecovery
                  + ", " : "")
            + (recoveredBy != null ? "recoveredBy=" + recoveredBy + ", " : "")
            + (locationOfRecovery != null ? "locationOfRecovery="
                  + locationOfRecovery + ", " : "")
            + (transportedBy != null ? "transportedBy=" + transportedBy + ", "
                  : "")
            + (temporaryLocation != null ? "temporaryLocation="
                  + temporaryLocation + ", " : "")
            + (evidenceRoomLocation != null ? "evidenceRoomLocation="
                  + evidenceRoomLocation + ", " : "")
            + "caseStatus="
            + caseStatus
            + ", "
            + (caseOfficer != null ? "caseOfficer=" + caseOfficer + ", " : "")
            + (disposition != null ? "disposition=" + disposition + ", " : "")
            + (dateOfDisposition != null ? "dateOfDisposition="
                  + dateOfDisposition : "") +"]";
   }

}
