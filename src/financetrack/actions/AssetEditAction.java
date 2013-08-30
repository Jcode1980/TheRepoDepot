package financetrack.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import financetrack.common.*;
import financetrack.dao.AssetDAO;
import financetrack.dao.AssetTypeDAO;
import financetrack.service.*;

public class AssetEditAction extends ActionSupport  implements org.apache.struts2.interceptor.ParameterAware {
	private String _testName= "yrdy";
	public Asset selectedAsset = null;
	private String [] genders = {"male", "female", "not sure" };
	private List<State> states ;
	//private Long _assetIDSelected = null;
	private Person personBean;

	public Asset getSelectedAsset(){
		
		/*
		Asset asset = null;
		System.out.println("goat here: assetss: ");
		try{
			asset =  testAsset();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("goat here: asset: " + asset.getName());
		//return asset;*/
		
		return selectedAsset;
	}
	
	public String getSelectedTestName(){
		System.out.println("im getting the test name!!!!");
		return _testName;
	}
	
	public void setSelectedTestName(String value){
		_testName = value;
	}
	
	public void setSelectedAsset(Asset value){
		System.out.println("setting selected Asset");
		//Thread.dumpStack();
		selectedAsset = value;
	}

	public Person getPerson() {
		return new Person();
		
	}
	
	public void setPerson(Person person) {
		
		personBean = person;
		
	}
	
	
	public String createAsset() throws Exception {
		System.out.println("Create asset action");
		//create the Asset
		
		//set the asset
		return SUCCESS;
	}
		
	public Asset testAsset(){
		AssetService assetService = new AssetService();
		return assetService.getAsset(5);
	}
	
	/**
	* To list a single user by Id.
	* @return String
	*/
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		System.out.println("this is the id!! " + request.getParameter("id"));
		//user = userDAO.listUserById(Long.parseLong( request.getParameter("id")));
		return SUCCESS;
	}
	
	public String editAsset(){
		AssetService assetService = new AssetService();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("assetService: " + assetService);
		
		
		Asset foundAsset = assetService.getAsset(id);
		System.out.println("this is the found asset: " + foundAsset + " with ID: " + foundAsset.getAssetID());
		setSelectedAsset(foundAsset);
		//ValueStack stack = ActionContext.getContext().getValueStack();
		
		//System.out.println("This is the edtiAsset. value stack is: " + stack.getContext().keySet());
		//System.out.println("This is the request. value stack is: " + stack.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST));
		return SUCCESS;
	}
	

	public List<AssetType> getAssetTypeList(){
		AssetTypeDAO assetTypeDAO = new AssetTypeDAO();
		return assetTypeDAO.getAllAssetTypes();

	}
	
	public String assetTypeIDString = "Property";
	
	public String assetTypeIDString(){
		return assetTypeIDString;
	}
	
	public void setAssetTypeIDString(String assetTypeIDString){
		System.out.println("Setting the assset SType stringggg: " + assetTypeIDString);
		AssetTypeService astService = new AssetTypeService();
		AssetService assetService = new AssetService();
		
		AssetType selectedAssetType = astService.getAssetType(Long.parseLong(assetTypeIDString));
		
		if(selectedAssetType != null){
			System.out.println("this is the assetType : " + selectedAssetType.getName());
			System.out.println("getSelectedAsset: " + getSelectedAsset());
			getSelectedAsset().setAssettype(selectedAssetType);			
		}
		else{
			System.out.println("No Asset Type");
		}
		this.assetTypeIDString = assetTypeIDString;
	}
	
	public List<State> getStateList() {
		states = new ArrayList<State>();
		states.add( new State("VIC", "Victoria"));
		states.add( new State("SA", "South Australia") );
		states.add( new State("QLD", "Queensland") );
		states.add( new State("NSW", "New South Whales") );
		states.add( new State("NT", "Northern Territory") );
		states.add( new State("TAS", "Tasmania") );
		
		return states;
	}

	public void setParameters(Map<String, String[]> map) {
		System.out.println("this is the map: " + map);
	}
	
	public String saveAction(){
		AssetService assetService = new AssetService();
		System.out.println("saveActionasset: " + getSelectedAsset() + " with ID: " + getSelectedAsset().getAssetID());
		assetService.saveOrUpdateAsset(getSelectedAsset());
		return SUCCESS;
	}
	
	public String backAction(){
		boolean successfulSave = true;
		
		if(successfulSave){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	public String cancelAction(){
		
		return SUCCESS;
	}
	

	
	
	
}
