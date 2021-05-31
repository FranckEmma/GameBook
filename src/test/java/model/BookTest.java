package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	@Test
	void testGetTextOfParagraphe() {
		var b = new Book("Book1");
		b.addParagraph(1, "para1","");
		assertEquals("para1", b.getTextOfParagraphe(1));
	}
	
	@Test
	void testgetAllTextOfAction() {
		var b = new Book("Book1");
		b.addParagraph(1, "para1","");
		b.addChoice(1, 2, "act1");
		b.addChoice(1, 3, "act2");
		var v = b.getAllTextOfAction(1);
		assertEquals("act1", v.get(0));
		assertEquals("act2", v.get(1));
	}
	
	

}
