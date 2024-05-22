package org.carbonIT.app;

import org.carbonIT.model.Map;
import org.carbonIT.utils.InputParser;
import org.carbonIT.simulation.Simulator;
import org.carbonIT.utils.OutputWriter;

public class TreasureTrackerApp {

    public static void main(String[] args) {
        String inputFilePath;
        String defaultInputPath = "src/main/resources/input.txt";
        String outputFilePath = "target/output.txt";

        if (args.length > 0) {
            inputFilePath = args[0];
        } else {
            inputFilePath = defaultInputPath;
        }
        try {
            Map map = InputParser.parseMap(inputFilePath);
            Simulator.simulate(map);

            OutputWriter.writeOutput(map, outputFilePath);

            System.out.println("Simulation complete. Output written to " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
