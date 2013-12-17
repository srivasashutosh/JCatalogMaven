package catalog.model.dao.hibernate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;


import com.mysql.jdbc.Connection;


public class Testdb extends DatabaseTestCase {

	
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		// TODO Auto-generated method stub

		   Class driverClass = 
		     Class.forName("com.mysql.jdbc.Driver");

		   Connection jdbcConnection = 
			 (Connection) DriverManager.getConnection(
		  "jdbc:mysql://localhost:3306/catalog", "ashutosh", "admin");
		   
		   return new DatabaseConnection(jdbcConnection);
	}

	
	public IDataSet createXML()
	{
		QueryDataSet partDS=null;
		IDatabaseConnection conn=null;
		try {
			 conn=getConnection();
			
			 partDS = new QueryDataSet(conn);
			partDS.addTable("product","SELECT id,name FROM product");
			FlatXmlDataSet.write(partDS, new FileOutputStream("dataset1.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null)
			{
				try {
					conn.close();
					System.out.println("hi");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return partDS;
		
	}
	
	@Test
   public void testHibernate() throws SQLException, Exception
    {
    	
    	
    	//IDataSet databaseDataSet = getConnection().createDataSet();
    	//databaseDataSet.to
    	//ITable actualTable = databaseDataSet.getTable("product");
    	ITable actualTable = getConnection().createQueryTable("product", "select id,name from product");
    	//actualTable.to
    	
    	System.out.println(actualTable.getRowCount());
    	
       IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("product");
        System.out.println(expectedDataSet.getTableNames().toString());
        //System.out.println(expectedTable.getValue(1, "name").toString());

        //assertEquals(expectedTable, actualTable);
        assertTrue("connection successful",(expectedTable.getRowCount()==8));
		
    	
    }
    
	
	@Test
    public void testAllProduct() throws DataSetException, SQLException, Exception
    {
    	ITable table= getConnection().createQueryTable("product", "select distinct name from product order by id");
    	
    	//System.out.println(table.getRowCount());
    	assertTrue("get all products", (table.getRowCount()>0));
		
    }

	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		// TODO Auto-generated method stub
		return DatabaseOperation.REFRESH;
	}

	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		// TODO Auto-generated method stub
		return DatabaseOperation.NONE;
	}
	
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		File fs = new File("dataset1.xml");
		FileInputStream fs1 = new FileInputStream(fs);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs1));
		String str=null;
		IDataSet iset = null;
		while((str=br.readLine())!=null)
		{
			//System.out.println(str);
			
		}
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dataset1.xml"));
		
	}
	
	@Test
	public void testGetAllCategory() throws DataSetException, SQLException, Exception
	{
		ITable table=getConnection().createQueryTable("category", "select name from category order by id");
		assertTrue("Category names received", table.getRowCount()>0);		
		
	}
	
	
	
}
