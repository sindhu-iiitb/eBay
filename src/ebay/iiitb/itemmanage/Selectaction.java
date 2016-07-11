package ebay.iiitb.itemmanage;

public class Selectaction {
private String choice;

public String getChoice() {
	return choice;
}

public void setChoice(String choice) {
	this.choice = choice;
}
public String execute()
{System.out.println("in select action" +choice);
	if(choice.equals("AddItem"))
		return "sellitem";
	else if(choice.equals("DeleteItem"))
		return "deleteitem";
	else if(choice.equals("Add Deal"))
		return "addDeal";
	//added by kirti(14-04-16)
	else if(choice.equals("UpdateItem"))
	{
		System.out.println("update choice--------------------------");
		return "updateitem";
	}
	//----kirti
	else
		return "deleteDeal";
	}
}
