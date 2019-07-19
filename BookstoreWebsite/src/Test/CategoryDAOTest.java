package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.dao.BaseDAOTest;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

class CategoryDAOTest extends BaseDAOTest {
	
	public static CategoryDAO categorydao;
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception{
		BaseDAOTest.setUpBeforeClass();
		categorydao=new CategoryDAO(entitymanager);
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	void testCreateCategory() {
		Category newcat=new Category("SAP Systems");
		Category category=categorydao.create(newcat);
		assertTrue(category !=null && category.getCategoryId()>0);
		
	}

	@Test
	void testUpdateCategory() {
		Category newcat=new Category("RPA Automation");
		newcat.setCategoryId(6);
		categorydao.update(newcat);		
		assertTrue(newcat.getName()=="RPA Automation");
		
		}

	/*@Test
	void testGetCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testListAllCategories() {
		fail("Not yet implemented");
	}

	@Test
	void testCategoryCount() {
		fail("Not yet implemented");
	}
	*/

}
