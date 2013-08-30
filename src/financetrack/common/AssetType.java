package financetrack.common;

public class AssetType {
	private long assetTypeID;
	private String name;
	private String descText;
	private Asset[] assets;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescText() {
		return descText;
	}
	
	public void setDescText(String desctext) {
		this.descText = desctext;
	}

	public long getAssetTypeID() {
		return assetTypeID;
	}

	public void setAssetTypeID(long assetTypeID) {
		this.assetTypeID = assetTypeID;
	}
	
	/**
	 * Get ebillsArray
	 * 
	 * @return ebillsArray
	 */
	public Asset[] getAssets() {
		return assets;
	}

	/**
	 * Set ebillsArray
	 * 
	 * @param ebillsArray
	 */
	public void setAssets(Asset[] value) {
		this.assets = value;
	}
 
	
	
}
