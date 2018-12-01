package co.edu.udea.dappe;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.dappe.codebreaker.dao.Codebreaker;

public class CodebreakerTest {

	private Codebreaker cb;
	private String realAnswer;
	
	@Before
	public void setUp() {
		cb = new Codebreaker();
		cb.setSecret("1234");
	}
	
	@Test
	public void allCoincidences1234() {		
		realAnswer = cb.decode("1234");
		assertEquals("XXXX", realAnswer);
	}
	
	@Test
	public void allDifferent7896() {
		realAnswer = cb.decode("7896");
		assertEquals("", realAnswer);
	}
	
	@Test
	public void oneCoincidenceByNumber0100() {
		realAnswer = cb.decode("0100");
		assertEquals("_", realAnswer);
	}
		
	@Test
	public void twoCoincidenceByNumber0120() {
		realAnswer = cb.decode("0120");
		assertEquals("__", realAnswer);
	}
	
	@Test
	public void threeCoincidenceByNumber0123() {
		realAnswer = cb.decode("0123");
		assertEquals("___", realAnswer);
	}
	
	@Test
	public void fourCoincidenceByNumber4123() {
		realAnswer = cb.decode("4123");
		assertEquals("____", realAnswer);
	}
	
	@Test
	public void oneCoincidenceByNumber5000() {
		cb.setSecret("4567");
		assertEquals("_", cb.decode("5000"));
	}
		
	@Test
	public void twoCoincidencesByNumber5006() {
		cb.setSecret("4567");
		assertEquals("__", cb.decode("5006"));
	}
	
	@Test
	public void threeCoincidencesByNumber5076() {
		cb.setSecret("4567");
		assertEquals("___", cb.decode("5076"));
	}
	
	@Test
	public void fourCoincidencesByNumber5876() {
		cb.setSecret("6785");
		assertEquals("____", cb.decode("5876"));
	}
	
	@Test
	public void oneCoincidenceByPosition5876() {
		cb.setSecret("5123");
		assertEquals("X", cb.decode("5876"));
	}
	
	@Test
	public void twoCoincidencesByPosition5176() {
		cb.setSecret("5123");
		assertEquals("XX", cb.decode("5176"));
	}
	
	@Test
	public void twoCoincidencesByTwoPosition5176() {
		cb.setSecret("5123");
		assertEquals("XX__", cb.decode("5132"));
	}
	
	
	@Test
	public void oneCoincidencesByOnePosition5176() {
		cb.setSecret("5123");
		assertEquals("X___", cb.decode("5312"));
	}
	
	@Test
	public void allGrown5176() {
		cb.setSecret("5123");
		assertEquals("", cb.decode("7890"));
	}
}
