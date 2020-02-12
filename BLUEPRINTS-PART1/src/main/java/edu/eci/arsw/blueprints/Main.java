package edu.eci.arsw.blueprints;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {
	
	
    public static void main(String args []) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        Point[] pointOne = {new Point(1,1), new Point(2,3), new Point(4,5)};
        Blueprint blue = new Blueprint("Pedro", "Ezequiel", pointOne);
        
        try {
        	// Test addNewBlueprint
			bs.addNewBlueprint(blue);
        	// Test getAllBlueprints		
			System.out.println(bs.getAllBlueprints());
			// Test getBlueprint
			Blueprint blue2 = bs.getBlueprint("Pedro", "Ezequiel");
			System.out.println(blue2);
			// Test getBlueprintsByAuthor
			System.out.println(bs.getBlueprintsByAuthor("Pedro"));		
			
		} catch (BlueprintPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
