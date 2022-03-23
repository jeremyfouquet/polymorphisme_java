package Geometrie;

import java.util.ArrayList;
import java.util.List;

public class Segment {
	List<Point> points = new ArrayList<Point>(2);
	Figure figure;

	public Segment(NbPoints nbPoints) {
		switch (nbPoints) {
			case deux:
				System.out.printf("%s\n", nbPoints.name());
				break;
			case trois:
				System.out.printf("%s\n", nbPoints.name());
				break;
			case quatre:
				System.out.printf("%s\n", nbPoints.name());
				break;
			default :
				break;
		}
		// TODO Auto-generated constructor stub
	}

}
