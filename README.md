noharp-analysis
===============
How to run
1. put logfiles from experiment in the folder 'rawdata'
2. make sure the logfiles have the following format: {L,K}Participant#.log e.g. L1.log (leap data for participant 1) K5.log (keyboard + mouse data for participant 5)
3. run main.Main
4. the processed results can be found in a .csv file in the folder 'processed'. Every row represents a participant and every column a feature. 

Steps to add a new loggable in the parser
1. Add the loggable in the DataTypes Enum that is located in the GenericDataType abstract class.
2. Create a new class in the 'dataTypes' folder that extends the GenericDataType abstract class for the loggable.
3. Add the attributes that you want to retrieve from the log file for that loggable.
4. Complete the switch statement in the extractDataType method located in the ParserIn class. The real parsing takes place here. 

Steps to add a new aggregator
1. Create a new class in the 'aggregation' folder that gives back the result of a specific metric (for both the LEAP as keyboard + mouse).
2. Add an instantiation of the new aggregator class as an attribute to the Trial class and instantiate in the aggregateData method.
3. Adapt the toString method of the Trial class to output the aggregated information.
4. Adapt the static method getHeader to account for the aggregator.
