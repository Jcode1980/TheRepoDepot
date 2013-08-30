package financetrack.service;
import financetrack.common.Asset;
import financetrack.dao.AssetDAO;

public class AssetService {
	AssetDAO assetDAO = new AssetDAO();

	/**
	 * Create a new user or update an existing one
	 * 
	 * @param user
	 *            user to be persisted
	 */
	public void saveOrUpdateAsset(Asset asset) {
		
		try{
			assetDAO.saveOrUpdateAsset(asset);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve an Asset
	 * 
	 * @param userId
	 *            identifier of the user to be retrieved
	 * @return user represented by the identifier provided
	 */
	public Asset getAsset(int assetID) {
		System.out.println("asset service: goat here 1");
		return assetDAO.getAsset(assetID);
	}

	/**
	 * Delete user
	 * 
	 * @param user
	 *            user to be deleted
	 */
	public void deleteAsset(Asset user) {
		assetDAO.deleteAsset(user);
	}
}
