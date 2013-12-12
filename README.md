SAP PI Test Adapter Module
===============

SAP PI Adapter Module template. SAP JAR's are required to build this:
 - com.sap.aii.af.cpa.svc.api.jar
 - com.sap.aii.af.lib.mod.jar
 - com.sap.aii.af.lib.mod.jar
 - com.sap.aii.af.svc_api.jar
 - sap.com~tc~logging~java~impl.jar
 
Template code just logs the message payload and doesn't do much else.
 
The JNDI name is used as the alias in the Integration Directory i.e. in this case JNDI is SAPPITestModule so in the integration builder add a local enterprise bean with module name SAPPITestModule
 
Project needs to be added to a EAR project and then deployed to a PI server via NWDS


Notes:

(1) Configure the build path. Create a classpath variable (Window->Preferences Java->Build Path->Classpath Variables) called PI_AF_LIBS and point it to the folder containing the PI jars listed above.
(2) Eclipse uses a .apt_generated folder to store information about annotations. This project does not use annotations so the folder is empty and git will not track empty folders by default. To sort this out just perform one of two quick fixes:
+ Create an empty .apt_generated folder in the projects root directory.
+ Open Project Properties and navigate to Java Compiler -> Annotation Processing. Disable annotation processing and apply. Then re-enable annotation processing and apply.
