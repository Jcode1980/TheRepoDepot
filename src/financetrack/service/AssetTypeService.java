package financetrack.service;

import financetrack.dao.AssetTypeDAO;
import financetrack.common.AssetType;

/**
 * Service layer for AssetType
 */
public class AssetTypeService {
	AssetTypeDAO assetTypeDAO = new AssetTypeDAO();

	/**
	 * Create a new assetType or update an existing one
	 * 
	 * @param assetType
	 *            assetType to be persisted
	 */
	public void saveOrUpdateAssetType(AssetType assetType) {
		assetTypeDAO.saveOrUpdateAssetType(assetType);
	}

	/**
	 * Retrieve an assetType
	 * 
	 * @param assetTypeId
	 *            identifier of the assetType to be retrieved
	 * @return assetType represented by the identifier provided
	 */
	public AssetType getAssetType(long assetTypeID) {
		
		return assetTypeDAO.getAssetType(assetTypeID);
	}

	/**
	 * Delete assetType
	 * 
	 * @param assetType
	 *            assetType to be deleted
	 */
	public void deleteAssetType(AssetType assetType) {
		assetTypeDAO.deleteAssetType(assetType);
	}
}
