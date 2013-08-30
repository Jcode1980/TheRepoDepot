package financetrack.actions;
import financetrack.common.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import financetrack.dao.AssetDAO;

public class AssetListAction extends BaseAssetListAction{
	protected List<Asset> assetsList = null;
	
	public String searchAssets() throws Exception {
		System.out.println("searchAssets");
		assetsList = null;
		System.out.println("this is th number of assets: " + getAssetsList().size());
		return SUCCESS;
	}

	public List<Asset> getAssetsList(){
		AssetDAO assetDAO = new AssetDAO();
		return assetDAO.getAllAssets();

	}
	
	
	public String execute() {
		return SUCCESS;
	}

	
	

	
}

