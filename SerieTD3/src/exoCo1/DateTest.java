package exoCo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DateTest {

  // tests du constructeur

  @Test
  public void testCreationDateOK() throws DateException {
    Date d = new Date(15, 03, 2018);
    assertNotNull(d);
  }

  @Test(expected = DateException.class)
  public void testCreationDateKoMoisIncorrect() throws DateException {
    new Date(15, 13, 2018);
  }

  @Test(expected = DateException.class)
  public void testCreationDateKoAnneeIncorrect() throws DateException {
    new Date(03, 12, 818);
  }

  @Test(expected = DateException.class)
  public void testCreationDateKoJourIncorrectNegatif() throws DateException {
    new Date(-103, 12, 1818);
  }

  @Test(expected = DateException.class)
  public void testCreationDateKoJourIncorrectTropGrand() throws DateException {
    new Date(103, 12, 1818);
  }

  // tests specifiques années bissextiles
  @Test
  public void testAnneeBissextileOK() throws DateException {
    Date d = new Date(29, 02, 2020);
    assertNotNull(d);
  }

  @Test(expected = DateException.class)
  public void testAnneeBissextileKO() throws DateException {
    new Date(29, 02, 2017);
  }

  @Test(expected = DateException.class)
  public void testAnneeBissextileOKMultipleCent() throws DateException {
    new Date(29, 02, 1900);
  }

  @Test
  public void testAnneeBissextileOKMultipleQuatreCent() throws DateException {
    Date d = new Date(29, 02, 2000);
    assertNotNull(d);
  }

  // tests de methode "lendemain"

  @Test
  public void testBasiqueDemain() throws DateException {
    Date d = new Date(15, 03, 2018);
    assertNotNull(d);

    d.demain();
    assertEquals(16, d.getJour());
    assertEquals(3, d.getMois());
    assertEquals(2018, d.getAnnee());
  }

  @Test
  public void testDemainChangementMois() throws DateException {
    Date d = new Date(31, 03, 2018);
    assertNotNull(d);

    d.demain();
    assertEquals(1, d.getJour());
    assertEquals(4, d.getMois());
    assertEquals(2018, d.getAnnee());
  }

  @Test
  public void testDemainChangementAnnee() throws DateException {
    Date d = new Date(31, 12, 2018);
    assertNotNull(d);

    d.demain();
    assertEquals(1, d.getJour());
    assertEquals(1, d.getMois());
    assertEquals(2019, d.getAnnee());
  }

  @Test
  public void testDemainPendantAnnee() throws DateException {
    Date d = new Date(15, 2, 2018);
    assertNotNull(d);

    for (int i = 0; i < 365; i++) {
      d.demain();
      System.out.println(d);
    }
    assertEquals(15, d.getJour());
    assertEquals(2, d.getMois());
    assertEquals(2019, d.getAnnee());
  }

}