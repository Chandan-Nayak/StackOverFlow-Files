package stack1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class RunTestNG {
	 
public void runTestNGTest(Map<String,String> testngParams) {
 
//Create an instance on TestNG
 TestNG myTestNG = new TestNG();
 
//Create an instance of XML Suite and assign a name for it.
 XmlSuite mySuite = new XmlSuite();
 mySuite.setName("StackOverFlow-Answer");
 
//Create an instance of XmlTest and assign a name for it.
 XmlTest myTest = new XmlTest(mySuite);
 myTest.setName("peetyaTest");
 
//Add any parameters that you want to set to the Test.
// myTest.setParameters(testngParams);
 
//Create a list which can contain the classes that you want to run including methods.
 List<XmlClass> myClasses = new ArrayList<XmlClass> ();
 XmlClass xmlclass = new XmlClass("stack1.LoginTest");
 
 List<XmlInclude> includedMethods = new ArrayList<XmlInclude>();

 for (int k = 0; k < 5; k++) {

   includedMethods.add(new XmlInclude("golog" + k));
 }
 xmlclass.setIncludedMethods(includedMethods);
 
 myClasses.add(xmlclass);

 
//Assign that to the XmlTest Object created earlier.
 myTest.setXmlClasses(myClasses);
 
//Create a list of XmlTests and add the Xmltest you created earlier to it.
 List<XmlTest> myTests = new ArrayList<XmlTest>();
 myTests.add(myTest);
 
//add the list of tests to your Suite.
 mySuite.setTests(myTests);
 
//Add the suite to the list of suites.
 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
 mySuites.add(mySuite);
 
//Set the list of Suites to the testNG object you created earlier.
 myTestNG.setXmlSuites(mySuites);
 
//invoke run() - this will run your class.
 myTestNG.run();
 
}
 
public static void main(String args[]) {
 
RunTestNG lt = new RunTestNG();
 
//This Map can hold your testng Parameters.
 Map<String,String> testngParams = new HashMap<String,String> ();
 
lt.runTestNGTest(testngParams);
 
}
 
}
