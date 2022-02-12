/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLib.dao;
import DVDLib.dto.DVD;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mariana.bonish
 */
public class DVDLibFileDaoImplTest {

    DVDLibDao testDao;

    public DVDLibFileDaoImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testLib.txt";
        //Use the fileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibFileDaoImpl(testFile);

    }

    @Test
    public void testAddGetDVD() throws Exception {
        int DVDId = 1;
        DVD dvd = new DVD(DVDId);
        dvd.setTitle("Up");
        dvd.setReleaseDate("2002");
        dvd.setMPAARating("10");
        dvd.setDirector("Bob");
        dvd.setStudio("Disney");
        dvd.setUserRating("8");
        
        //Add the DVD to the DAO
        
        testDao.addDVD(dvd);
        
        //retrieve the DVD from the dao
        
        DVD returnedDVD = testDao.getDVD(DVDId);
        
        //Check to see if the data is equal
        assertEquals(dvd.getDVDId(), returnedDVD.getDVDId());
        assertEquals(dvd.getTitle(), returnedDVD.getTitle());
        assertEquals(dvd.getReleaseDate(), returnedDVD.getReleaseDate());
        assertEquals(dvd.getMPAARating(), returnedDVD.getMPAARating());
        assertEquals(dvd.getStudio(), returnedDVD.getStudio());
        assertEquals(dvd.getUserRating(), returnedDVD.getUserRating());
        
        
    }
    
    @Test
    public void testAddGetAllDVDs() throws Exception{
     //create first DVD
           int DVDId = 1;
        DVD dvd = new DVD(DVDId);
        dvd.setTitle("Up");
        dvd.setReleaseDate("2002");
        dvd.setMPAARating("10");
        dvd.setDirector("Bob");
        dvd.setStudio("Disney");
        dvd.setUserRating("8");
        
        //create DVD2
        int DVDId2 = 2;
        DVD dvd2 = new DVD(DVDId2);
        dvd2.setTitle("Titanic");
        dvd2.setReleaseDate("1999");
        dvd2.setMPAARating("10");
        dvd2.setDirector("Billy");
        dvd2.setStudio("who Knows");
        dvd2.setUserRating("99");
        
        //Add both DVDs to DAO
        testDao.addDVD(dvd);
        testDao.addDVD(dvd2);
        
        //get all the DVDs
        List<DVD> allDVDs = testDao.getAllDVDs();
        
        //first check the general contents of the list 
        assertNotNull(allDVDs);
        assertEquals(2,allDVDs.size());
        
        assertTrue(testDao.getAllDVDs().contains(dvd));
        assertTrue(testDao.getAllDVDs().contains(dvd2));
        
    }
    
        @Test
    public void testRemoveDVDs() throws Exception{
     //create first DVD
           int DVDId = 1;
        DVD dvd = new DVD(DVDId);
        dvd.setTitle("Up");
        dvd.setReleaseDate("2002");
        dvd.setMPAARating("10");
        dvd.setDirector("Bob");
        dvd.setStudio("Disney");
        dvd.setUserRating("8");
        
        //create DVD2
        int DVDId2 = 2;
        DVD dvd2 = new DVD(DVDId2);
        dvd2.setTitle("Titanic");
        dvd2.setReleaseDate("1999");
        dvd2.setMPAARating("10");
        dvd2.setDirector("Billy");
        dvd2.setStudio("who Knows");
        dvd2.setUserRating("99");
       
        //Add both DVDs to DAO
        testDao.addDVD(dvd);
        testDao.addDVD(dvd2);
        
        //remove the dvd
        DVD removedDVD = testDao.removeDVD(dvd.getDVDId());
        
        //check to see that the dvd was removed 
        assertEquals(removedDVD,dvd);
       
        //get all dvds
        List<DVD> allDVDs = testDao.getAllDVDs();
        
        //check the contents of the list 
        assertNotNull(allDVDs);
        assertEquals(1, allDVDs.size());
        
        //check the specifics 
        assertFalse(testDao.getAllDVDs().contains(dvd));
        assertTrue(testDao.getAllDVDs().contains(dvd2));
        
        //remove the second dvd
        testDao.removeDVD(dvd2.getDVDId());
        
        //get all the dvds from the list again
        List<DVD> allDVDs2 = testDao.getAllDVDs();
        
        //check that this list is empty
        assertTrue(allDVDs2.isEmpty());
        
        //check to get the dvds by their id. It should be null
        DVD falseRetrievedDVD = testDao.getDVD(dvd.getDVDId());
        
        assertNull(falseRetrievedDVD);
        
        DVD falseRetrievedDVD2 = testDao.getDVD(dvd2.getDVDId());
        
        assertNull(falseRetrievedDVD2);
    }
    
    @Test 
    public void testEditDVD() throws Exception{
        //create DVD
           int DVDId = 1;
        DVD dvd = new DVD(DVDId);
        dvd.setTitle("Up");
        dvd.setReleaseDate("2002");
        dvd.setMPAARating("10");
        dvd.setDirector("Bob");
        dvd.setStudio("Disney");
        dvd.setUserRating("8");
        
        //store dvd
        testDao.addDVD(dvd);
        
        DVD editedDVD = testDao.editDVD(dvd.getDVDId());
        editedDVD.setTitle("New");
      
        //test that it was the correct DVD
        testDao.getDVD(editedDVD.getDVDId());
        //test that the title was changed
        assertTrue(editedDVD.getTitle().equals("New"));
      
        
    }
}
