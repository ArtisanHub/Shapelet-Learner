package tech.artisanhub.ShapeletTrainer;

import weka.core.Instances;

import java.util.ArrayList;

public class LearnShapelets
{
    public static void main( String[] args )
    {
        try {
            // mandatory requirements: numShapelets (k), min shapelet length, max shapelet length, input
            // data
            // additional information: log output dir

            // example filter, k = 10, minLength = 20, maxLength = 40, data = , output = exampleOutput.txt
            int k = 15; // number of shapelets

            int minLength = 1;
            int maxLength = 4;
//            String ARFFName = "/home/jawadhsr/Desktop/FYP/FIles/iris_replacedNamedWithInts.arff";
            String ARFFName = "/home/rnavagamuwa/Documents/CSE/FYP/Datasets/pima-indians-diabetes/arff-pima-indians-diabetes.data";
            Instances data = ShapeletFilter.loadData(ARFFName);

//            String outPutFile =  "/home/jawadhsr/Desktop/FYP/FIles/Shaplets.txt";
            String outPutFile = "/home/rnavagamuwa/Documents/CSE/FYP/Datasets/pima-indians-diabetes/shapeletsOut.txt";
            ShapeletFilter sf = new ShapeletFilter(k, minLength, maxLength);
            sf.setLogOutputFile(outPutFile); // log file stores shapelet output
            ArrayList<Shapelet> generatedShapelets = sf.process(data);
            int [] arr = {1,2,3};
            ArrayList<Shapelet> outPut = new ImportantShapelets().GetImportantShapelets(new MergeShapelets().mergeShapelets(generatedShapelets,5),data,arr);
            int i=0;
            for(Shapelet val : outPut){
                System.out.println(outPut.get(i).contentInMergedShapelets);
                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
