package common.mediator;

import java.sql.DriverManager;
import java.sql.ResultSet;

import common.model.Date;
import common.model.Item;
import common.model.ItemList;

import java.sql.*;

public class DatabaseAdapter implements Persistence
{

	private Connection myConn;
	private Statement myStm;
	private ResultSet myRs;
	private ItemList itemList;

	public DatabaseAdapter(String URL, String UserName, String Password)
	{

		itemList = new ItemList();
		try
		{
			// CONNECTION
			myConn = DriverManager.getConnection(URL, UserName, Password);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public ItemList getAll()
	{

		try
		{
			myStm = myConn.createStatement();
			String sql = "Select * From evidence_room.items";
			myRs = myStm.executeQuery(sql);
			while (myRs.next())
			{

				itemList.addItem(new Item(Integer.parseInt(myRs.getString("casenumber_1")),
						Integer.parseInt(myRs.getString("casenumber_2")),
						Integer.parseInt(myRs.getString("casenumber_3")),
						Integer.parseInt(myRs.getString("casenumber_4")), myRs.getString("offencelocation"),
						Integer.parseInt(myRs.getString("number")), myRs.getString("offencetype"),
						myRs.getString("evidencedescription"), myRs.getString("evidencetype"), myRs.getString("victim"),
						myRs.getString("suspect"), myRs.getString("reasonsiezed"),
						new Date(myRs.getDate("dateofrecovery").getDate(),
								myRs.getDate("dateofrecovery").getMonth() + 1,
								myRs.getDate("dateofrecovery").getYear() + 1900),
						myRs.getString("recoveredby"), myRs.getString("locationofrecoverry"),
						myRs.getString("transportedby"), myRs.getString("temporarylocation"),
						myRs.getString("evidenceroomlocation"), myRs.getBoolean("casestatus"),
						myRs.getString("caseofficer"), myRs.getString("disposition"),
						new Date(myRs.getDate("dateofdisposition").getDate(),
								myRs.getDate("dateofdisposition").getMonth()
										+ 1,
								myRs.getDate("dateofdisposition").getYear() + 1900),
						Integer.parseInt(myRs.getString("id"))));
			}

		}
		catch (Exception e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
		return itemList;

	}

	@Override
	public void remove(int itemId)
	{
		try
		{
			myStm = myConn.createStatement();
			String sql = "DELETE FROM evidence_room.items where id = " + itemId;
			myStm.executeUpdate(sql);
			System.out.println("ITEM WITH ID=" + itemId + " WAS REMOVED");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void clear()
	{
		try
		{

			myStm = myConn.createStatement();
			String sql = "TRUNCATE evidence_room.items";
			myStm.executeUpdate(sql);
			System.out.println("THE TABLE IS CLEAR");

		}
		catch (Exception e)
		{
			System.out.println("THERE IS A MISTAKE WITH CLEAN METHOD YOU ASSHOLE");
		}

	}

	@Override
	public int getNumberOfItems()
	{
		int count = 0;
		try
		{

			myStm = myConn.createStatement();
			ResultSet rs = myStm.executeQuery("Select * From Evidence_room.items");
			ResultSetMetaData rsmd = rs.getMetaData();
			count = rsmd.getColumnCount();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Item createItem(int caseNumber1, int caseNumber2, int caseNumber3, int caseNumber4, String offenseLocation,
			int number, String offenseType, String evidenceDiscription, String evidenseType, String victim,
			String suspect, String reasonSiezed, Date dateOfRecovery, String recoveredBy, String locationOfRecovery,
			String transportedBy, String temporaryLocation, String evidenceRoomLocation, boolean caseStatus,
			String caseOfficer, String disposition, Date dateOfDisposition, int itemId)
	{

		Item temp = new Item(caseNumber1, caseNumber2, caseNumber3, caseNumber4, offenseLocation, number, offenseType,
				evidenceDiscription, evidenseType, victim, suspect, reasonSiezed, dateOfRecovery, recoveredBy,
				locationOfRecovery, transportedBy, temporaryLocation, evidenceRoomLocation, caseStatus, caseOfficer,
				disposition, dateOfDisposition, itemId);
		try
		{
			myStm = myConn.createStatement();
			String sql1 = "INSERT INTO evidence_room.items(casenumber_1,casenumber_2,casenumber_3,casenumber_4,offencelocation,number,";
			String sql2 = "offencetype,evidencedescription,evidencetype,victim,suspect,reasonsiezed,dateofrecovery,recoveredby,";
			String sql3 = "locationofrecoverry,transportedby,temporarylocation,evidenceroomlocation,casestatus,caseofficer,disposition,dateofdisposition,id)";
			String sql4 = "values(" + caseNumber1 + "," + caseNumber2 + "," + caseNumber3 + "," + caseNumber4 + ",'"
					+ offenseLocation + "'," + number + ",'" + offenseType + "'" + ",'" + evidenceDiscription + "','"
					+ evidenseType + "','" + victim + "'," + "'" + suspect + "','" + reasonSiezed + "','"
					+ dateOfRecovery + "','" + recoveredBy + "'," + "'" + locationOfRecovery + "'," + "'"
					+ transportedBy + "','" + temporaryLocation + "','" + evidenceRoomLocation + "'," + caseStatus
					+ ",'" + caseOfficer + "','" + disposition + "','" + dateOfDisposition + "'" + "," + itemId +

					")";

			String all = sql1 + sql2 + sql3 + sql4;

			myStm.executeUpdate(all);

			System.out.println("INSERT COMPLETE");

		}
		catch (Exception e)
		{

			System.out.println("Something went wrong with createStatement");
			e.printStackTrace();
		}

		return temp;

	}

	String sql;

	@Override
	public void update(int itemId, String whatToChange, String changeWithThis)
	{

		try
		{
			myStm = myConn.createStatement();
			sql = "UPDATE evidence_room.items set " + whatToChange + "='" + changeWithThis + "'" + " where id = "
					+ itemId;
			myStm.executeUpdate(sql);
			System.out.println("CHANGE WAS MADE");

		}
		catch (Exception e)
		{
			System.out.println(sql);
			e.printStackTrace();
		}

	}
}
