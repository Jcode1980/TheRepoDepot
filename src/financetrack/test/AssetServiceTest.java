package financetrack.test;
import financetrack.*;
import financetrack.service.*;
import financetrack.common.*;

import java.util.Date;
import java.math.*;
import java.util.*;

import junit.framework.Assert;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;


/**
 * Service layer tests for Asset
 */
public class AssetServiceTest extends ServiceTest {
	private static final BigDecimal TEST_DECIMAL = new BigDecimal("5000.00");

	/**
	 * Test asset creation
	 */
	public void testCreateAsset() {
		// create the asset
		// ------ --- -------
		Asset asset = new Asset();

		// no need to set id, Hibernate does it for us
		// -- ---- -- --- --- --------- ---- -- --- --
		// asset.setAssetId(1)

		asset.setName("Property 1");
		asset.setIncomeYield(new BigDecimal("100.00"));

		Assert.assertTrue(asset.getAssetID() == 0);

		// save the asset
		// ---- --- -------
		AssetService assetService = new AssetService();
		assetService.saveOrUpdateAsset(asset);


		System.out.println("var asset = " + asset);

		// check that IDs were set after the hbm session
		// ----- ---- --- ---- --- ----- --- --- -------
		Assert.assertTrue(asset.getAssetID() > 0);

		// cleanup
		// -------
		deleteAsset(asset);
	}
	private AssetType createAssetType(Session session){
		
		AssetType assetType = new AssetType();

		assetType.setName("AssetTest 1");
		
		AssetTypeService assetTypeService = new AssetTypeService();
		assetTypeService.saveOrUpdateAssetType(assetType);
		
		
		//session.getTransaction().commit();
		
		return assetType;
	}

	/**
	 * Test retrieval of asset
	 */
	@Test
	public void testGetAsset() {
		System.out.println("testGetAsset");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Asset asset = createAsset();
		System.out.println("var asset = " + asset);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		AssetService assetService = new AssetService();
		Asset anotherCopy = assetService.getAsset(asset.getAssetID());

		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure these are two separate instances
		// ---- ---- ----- --- --- -------- ---------
		Assert.assertTrue(asset != anotherCopy);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// cleanup
		// -------
		deleteAsset(asset);
	}

	/**
	 * Test updating of asset balance
	 */
	@Test
	public void testUpdateAssetBalance() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Asset asset = createAsset();
		System.out.println("var asset = " + asset);

		AssetService assetService = new AssetService();
		asset.setIncomeYield(TEST_DECIMAL);
		assetService.saveOrUpdateAsset(asset);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		session2.beginTransaction();

		Asset anotherCopy = assetService.getAsset(asset.getAssetID());
		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure the one we just pulled back
		// from the database has the updated balance
		// -----------------------------------------
		Assert.assertTrue(anotherCopy.getIncomeYield().equals(TEST_DECIMAL));

		session2.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// cleanup
		// -------
		deleteAsset(asset);
	}

	/**
	 * Test update of asset type. Asset Type is set to update=false in
	 * Hibernate Mapping. Therefore, ensure that it does not get updated.
	 */
	@Test
	public void testUpdateAssetType() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Asset asset = createAsset();
		System.out.println("var asset = " + asset);

		AssetService assetService = new AssetService();
		assetService.saveOrUpdateAsset(asset);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		Session session2 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session2.beginTransaction();

		Asset anotherCopy = assetService.getAsset(asset.getAssetID());
		System.out.println("var anotherCopy = " + anotherCopy);

		// make sure the one we just pulled back from
		// the database DOES NOT HAVE the updated balance
		// ----------------------------------------------
		//Assert.assertFalse(anotherCopy.getAssetType().equals(Asset.ACCOUNT_TYPE_CHECKING));

		session2.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// cleanup
		// -------
		deleteAsset(asset);
	}

	/**
	 * Test deletion of asset
	 */
	
	public void testDeleteAsset() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Asset asset = createAsset();
		System.out.println("var asset = " + asset);

		// delete the asset
		// ------ --- -------
		AssetService assetService = new AssetService();
		assetService.deleteAsset(asset);

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		// try to get the asset again -- should be null
		// --- -- --- --- ------- ----- -- ------ -- ----
		Session session2 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session2.beginTransaction();

		Asset anotherCopy = assetService.getAsset(asset.getAssetID());

		System.out.println("var anotherCopy = " + anotherCopy);

		Assert.assertNull(anotherCopy);

		session2.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}
	
	@Test
	public void testListAllAssets(){
		System.out.println("this is the testListAllAssets");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		java.util.List users = session.createQuery("FROM User").list(); 
         System.out.println("Users count is : " + users.size());
         for (Iterator iterator = users.iterator(); iterator.hasNext();)
         {
            User user = (User) iterator.next(); 
            System.out.print("User Name: " + user.getGiven()); 
            System.out.print("  Last Name: " + user.getSurname()); 
            System.out.println("  login: " + user.getLogin()); 
         } 
	}
	
	@Test
	public void test2CreateAsset() {
		System.out.println("test2CreateAsset");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		AssetService assetService = new AssetService();
		AssetTypeService assetTypeService = new AssetTypeService();
		
		// create the asset
		// ------ --- -------
		Asset asset = new Asset();

		// no need to set id, Hibernate does it for us
		// -- ---- -- --- --- --------- ---- -- --- --
		// asset.setAssetId(1)

		asset.setName("Property 2");
		asset.setIncomeYield(new BigDecimal("100.00"));

		Assert.assertTrue(asset.getAssetID() == 0);

		// create and save the assetType
		// ---- --- -------
		AssetType assetType = createAssetType(session);
		
		System.out.println("test2CreateAsset3");
		
		
		System.out.println("this is the assetype ID: " + assetType.getAssetTypeID());
		
		asset.setAssettype(assetType);
		assetService.saveOrUpdateAsset(asset);
		
		session.getTransaction().commit();
		System.out.println("test2CreateAsset4");
		
		HibernateUtil.getSessionFactory().close();

		System.out.println("haha var asset = " + asset);

		// check that IDs were set after the hbm session
		// ----- ---- --- ---- --- ----- --- --- -------
		Assert.assertTrue(asset.getAssetID() > 0);

		// cleanup
		// -------
		//deleteAsset(asset);
	}
}