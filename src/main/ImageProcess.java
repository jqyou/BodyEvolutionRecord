package main;




import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;








import javax.imageio.ImageIO;
import javax.media.MediaLocator;








import org.jcodec.api.SequenceEncoder;

import contour.ContourReco;
import face.DetectFace;
import video.JpegImagesToMovie;

public class ImageProcess {
/*
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		String inputFile = "/Users/Daisy/documents/workspaceforEE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BodyEvolutionRecord/IMAGE/Daisy776pic.jpg";
		String outputFile = "src/male_canny.jpg";
		
		facerun(inputFile, outputFile);
	//	String video = "src/video.mp4";
		//transVideo(pictures, video);
	//	Vector<String> pics = new Vector<String>();
	//	pics.add("");
		
	//	makeVideo(pics, video, 320, 320);
		
	}*/
	
	public static void run(String inputFile, String outputFile) {
	//   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	   System.load("/Users/Daisy/downloads/opencv-2.4.9/release/lib/libopencv_java249.dylib");

		/*// Amout of faces can be deteced in the picture now.
		int faces = new DetectFace().run(inputFile, outputFile);
		
		warningOfFaces(faces);*/
		
		new ContourReco().run(inputFile, outputFile);
	}
	
	public static void facerun(String inputFile, String outputFile) {
		//   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		   System.load("/Users/Daisy/downloads/opencv-2.4.9/release/lib/libopencv_java249.dylib");

			// Amout of faces can be deteced in the picture now.
			int faces = new DetectFace().run(inputFile, outputFile);
			
			warningOfFaces(faces);
			
		}

	
	public static void makeVideo(Vector<String> inputPictures, String fileName, int width, int height) throws MalformedURLException {
	    JpegImagesToMovie imageToMovie = new JpegImagesToMovie();
	    MediaLocator oml;
	    if ((oml = JpegImagesToMovie.createMediaLocator(fileName)) == null) {
	        System.err.println("Cannot build media locator from: " + fileName);
	        System.exit(0);
	    }
	    int interval = 1000;
	    imageToMovie.doIt(width, height, (1000 / interval), inputPictures, oml);

	}
	public static void sequenceVideo(Vector<String> inputPictures, String outputFile) throws IOException {
	    SequenceEncoder encoder = new SequenceEncoder(new File(outputFile));
	    for(int i = 0; i < inputPictures.size(); i++) {
	    	BufferedImage bi = ImageIO.read(new File(inputPictures.get(i)));
	    	encoder.encodeImage(bi);
	    }
	    encoder.finish();
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
