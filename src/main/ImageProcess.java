package main;



import org.opencv.core.Core;

import contour.ContourReco;
import face.DetectFace;

public class ImageProcess {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String inputFile = "/Users/Daisy/documents/workspaceforEE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BodyEvolutionRecord/IMAGE/yjq154pic.jpg";
		String outputFile = "src/male_canny.jpg";
		
		run(inputFile, outputFile);
		
	}*/
	
	public static void run(String inputFile, String outputFile) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Amout of faces can be deteced in the picture now.
		int faces = new DetectFace().run(inputFile, outputFile);
		
		warningOfFaces(faces);
		
		new ContourReco().run(inputFile, outputFile);
	}
	
	public static void warningOfFaces(int faces) {
		if(faces < 1) {
			System.out.print("NOTICE >> Please stand into the camera area!");
		}
		else if(faces > 1) {
			System.out.print("NOTICE >> Please keep only one person in camera area in a time!");
		}
		if (faces == 1){
			System.out.print("NOTICE >> Reconized! Please keep still to wait for taking photo!");	
		}
	}

}
