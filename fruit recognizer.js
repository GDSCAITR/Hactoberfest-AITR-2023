import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.zoo.model.VGG16;
import org.deeplearning4j.zoo.util.imagenet.ImageNetLabels;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.io.File;
import java.io.IOException;

public class FruitRecognizer {

    public static void main(String[] args) throws IOException {
        // Load pre-trained VGG16 model
        ComputationGraph vgg16 = (ComputationGraph) VGG16.builder().build().initPretrained();

        // Load and preprocess the image
        NativeImageLoader loader = new NativeImageLoader(224, 224, 3);
        File imageFile = new File("path_to_your_image.jpg");
        INDArray image = loader.asMatrix(imageFile);

        // Perform the prediction
        INDArray output = vgg16.outputSingle(false, image);

        // Get the ImageNet labels
        ImageNetLabels labels = new ImageNetLabels();

        // Print the predicted label
        int[] top5 = org.deeplearning4j.nn.layers.objdetect.YoloUtils.getPredictedLabels(output, 5, 0.0);
        for (int i = 0; i < 5; i++) {
            System.out.println("Predicted Label " + (i + 1) + ": " + labels.getLabel(top5[i]));
        }
    }
}
