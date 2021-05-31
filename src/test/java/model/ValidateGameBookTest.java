package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateGameBookTest {

	@Test
	void testDisplayNoeud() {
		var b = new Book("Book1");
		ValidateGameBook vb = new ValidateGameBook();
		//var pa5 = new Paragraph(1, "para4");
		// pa1.addAction(act2);
		b.addParagraph(1,"para1","");
		b.addParagraph(2,"para2","");
		b.addChoice(1, 3, "act1");
		b.addChoice(2, 4, "act2");
		b.addChoice(2, 3, "act23");
		
		var str = vb.displayNoeud(b);
		var str1 = "Nœuds absents de toute action : ";
		var str2 = "Nœuds terminaux inaccessibles à partir du début: ";
		var resul = str1 + 2 + " \n" + str2 + 4 + " ";
		assertEquals(resul, str);
	}

}
