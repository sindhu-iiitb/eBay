package ebay.iiitb.report;

import java.util.ArrayList;

//import org.iiitb.model.ItemModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ebay.iiitb.report.generatereportmodel;

public class GenerateReportAction extends ActionSupport implements ModelDriven<ArrayList<generatereportmodel>>{

/**
	 * 
	 */
	private int from;
	private int to;
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}

	private static final long serialVersionUID = 1L;
//	Reportmodel reportmodel = new Reportmodel();
//	public Reportmodel getReportmodel() {
//		return reportmodel;
//	}
//	public void setReportmodel(Reportmodel reportmodel) {
//		this.reportmodel = reportmodel;
//	}
	
	private ArrayList<generatereportmodel> reportdetails = new ArrayList<generatereportmodel>();
	public ArrayList<generatereportmodel> getReportdetails() {
		return reportdetails;
	}
	public void setReportdetails(ArrayList<generatereportmodel> reportdetails) {
		this.reportdetails = reportdetails;
	}
	GenerateReportService reportservice=new GenerateReportService();
	//GenerateReportService reportservice=new GenerateReportService(reportmodel);
	
	public String execute()
	{System.out.println("hey--------------");
	System.out.println(getFrom()+" "+getTo());
		setReportdetails(reportservice.getreport(getFrom(),getTo()));
		for( generatereportmodel rd:reportdetails)
		{
			System.out.println(rd.getFirstname());
			System.out.println(rd.getItem_name());
			System.out.println(rd.getItemid());
			
		}
		return SUCCESS;
	}
	@Override
	public ArrayList<generatereportmodel> getModel() {
		// TODO Auto-generated method stub
		return reportdetails;
	}
	
	
}

