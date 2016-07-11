
// tables : category
// category : id , name , parent , class



package ebay.iiitb.admin;


import ebay.iiitb.DBUtil.*;

import java.sql.*;;

public class AddNewSubcategoryService {

	AddNewSubcategoryModel addNewSubcategoryModel;
	boolean status=false;
	int id;
	
	public AddNewSubcategoryService(AddNewSubcategoryModel addNewSubcategoryModel) {
		this.addNewSubcategoryModel=addNewSubcategoryModel;
	}

	public boolean addSubcategory() {
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		int id=0;
		
		String getcatclass="select id from category where name=?";
		String addnewsubcategory="insert into category (name,parent,class) values(?,?,?)";
		try {
			ps=con.prepareStatement(getcatclass);
			ps.setString(1, addNewSubcategoryModel.getCategory());
			rs=ps.executeQuery();
			while(rs.next()){
				id=rs.getInt(1);
			}
			ps=con.prepareStatement(addnewsubcategory);
			
			ps=con.prepareStatement(addnewsubcategory);
			ps.setString(1, addNewSubcategoryModel.getSubcategory());
			ps.setInt(2, id);	
			ps.setInt(3,id);
			
			if(ps.executeUpdate()>0)
				status=true;
			else {
				status=false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
