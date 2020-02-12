package edu.eci.arsw.blueprints.test.persistence.filter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.eci.arsw.blueprints.filters.Filter;
import edu.eci.arsw.blueprints.filters.impl.RedundancyFiltering;
import edu.eci.arsw.blueprints.filters.impl.SubsamplingFiltering;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

public class FilterTest {
	
	@Test	
	public void shouldBeFilterByRedundancy() {
		Point[] points = new Point[] {new Point(1,1), new Point(2,2), new Point(2,2)};
		List<Point> res = Arrays.asList(new Point[] {new Point(1,1), new Point(2,2)});
		Filter filter = new RedundancyFiltering();
		Blueprint blue = filter.filter(new Blueprint("Jorge","El Curioso", points));
		assertEquals(res, blue.getPoints());
	}
	
	
	@Test	
	public void shouldBeFilterPointBySubsampling() {
		Point[] points = new Point[] {new Point(1,1), new Point(2,2), new Point(3,3),
									  new Point(4,4), new Point(5,5), new Point(6,6),
									  new Point(7,7), new Point(8,8), new Point(9,9)};
		List<Point> res = Arrays.asList(new Point[] {new Point(1,1), new Point(3,3), new Point(5,5),
				  									new Point(7,7),new Point(9,9)});
		
		Filter filter = new SubsamplingFiltering();
		Blueprint blue = filter.filter(new Blueprint("Jorge","El Curioso", points));
		assertEquals(res, blue.getPoints());
		
	}
}
