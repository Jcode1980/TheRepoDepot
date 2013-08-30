package financetrack.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import financetrack.*;
import financetrack.common.Asset;
import financetrack.common.AssetType;


/**
 * Data Access Object for assetType
 */
public class AssetTypeDAO {
	Session session;
	
	/**
	 * Create a new assetType or update an existing one
	 * 
	 * @param assetType
	 *            assetType to be persisted
	 */
	public void saveOrUpdateAssetType(AssetType assetType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(assetType);
	}
	
	 @SuppressWarnings("unchecked")
	   public List<AssetType> getAllAssetTypes()
	   {
	      List<AssetType> assetTypes = new ArrayList<AssetType>();
	      try
	      {
	    	  System.out.println("this is the session: "  + (session != null));
	    	  session = HibernateUtil.getSessionFactory().getCurrentSession();
	    	  session.beginTransaction();
	    	  assetTypes = session.createQuery("from AssetType").list();
	    	  session.getTransaction().commit();
	  			HibernateUtil.getSessionFactory().close();
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return assetTypes;
	   }
	

	/**
	 * Retrieve an assetType from the data store
	 * 
	 * @param assetTypeId
	 *            identifier of the assetType to be retrieved
	 * @return assetType represented by the identifier provided
	 */
	public AssetType getAssetType(long assetTypeId) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AssetType assetType = (AssetType) session.get(AssetType.class, assetTypeId);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		
		return assetType;
	}

	/**
	 * Delete assetType from data store
	 * 
	 * @param assetType
	 *            assetType to be deleted
	 */
	public void deleteAssetType(AssetType assetType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(assetType);
	}
}
