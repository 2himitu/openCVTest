import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Assignment_1 {

	public static void main(String[] args) {
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		int num = 100;
		// 얼굴 찾을 대상 사진
		for (int i = 1; i < num; i++) {
			String file = "C:/marpple/"+i+".jpg";
			Mat src = Imgcodecs.imread(file);
		
			String xmlFile = "C:/Users/lhs12/Downloads/Opencv/build/etc/lbpcascades/lbpcascade_frontalface.xml";
			CascadeClassifier classifier = new CascadeClassifier(xmlFile);
	
			
			MatOfRect faceDetections = new MatOfRect();
			classifier.detectMultiScale(src, faceDetections);

//        Mat m  = Mat.eye(3, 3, CvType.CV_8UC1);
//        System.out.println("m = " + m.dump());
//	}

//}
			System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

			// Drawing boxes
			for (Rect rect : faceDetections.toArray()) {
				Imgproc.rectangle(src, // where to draw the box
						new Point(rect.x, rect.y), // bottom left
						new Point(rect.x + rect.width, rect.y + rect.height), // top right
						new Scalar(0, 0, 255), 3 // RGB colour
				);
			}

			// Writing the image
			Imgcodecs.imwrite("C:/marpple/b1/facedetect_output"+i+".jpg", src);

			System.out.println("Image Processed");
		}
	}
}