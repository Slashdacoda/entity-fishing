package com.scienceminer.nerd.kb;

import com.scienceminer.nerd.kb.model.Page;
import org.junit.Before;
import org.junit.Test;

public class LookupIntegrationTest {

    private LowerKnowledgeBase wikipedia = null;

    @Before
    public void setUp() throws Exception {
        UpperKnowledgeBase.getInstance();
        wikipedia = UpperKnowledgeBase.getInstance().getWikipediaConf("en");
    }

    @Test
    public void testPageId() {
        Page page = wikipedia.getPageById(3966054);

        System.out.println("pageId:" + page.getId());
        System.out.println(page.getTitle());
    }

    @Test
    public void testTitle() {
        Page page = wikipedia.getArticleByTitle("Mexico");
        if (page != null) {
            System.out.println(page.getTitle());
            System.out.println("pageId:" + page.getId());
        }
    }

    @Test
    public void testConcept() {
        Concept concept = UpperKnowledgeBase.getInstance().getConcept("Q18498");
        if (concept != null) {
            System.out.println(concept.getId());
            System.out.println("en pageId:" + concept.getPageIdByLang("en"));
        }
    }

	/*@Test
	public void testProperties() {
		try {
			List<Property> properties = wikipedia.getProperties(3966054);

			System.out.println("properties for Mexico (" + 3966054 + ")");
			if (properties != null) {
				for (Property property : properties)
					System.out.println(property.toJson());
			} else 
				System.out.println("no property found");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/

	/*@Test
	public void testRelations() {
		try {
			List<Relation> relations = wikipedia.getRelations(3966054);

			System.out.println("relations for Mexico (" + 3966054 + ")");
			if (relations != null) {
				for (Relation relation : relations)
					System.out.println(relation.toJson());
			} else 
				System.out.println("no relation found");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*@After
	public void testClose() {
		try {
			UpperKnowledgeBase.getInstance().close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
}

