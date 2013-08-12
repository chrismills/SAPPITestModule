SAPPITestModule
===============

SAP PI Adapter Module template. SAP JAR's are required to build this:
 - com.sap.aii.af.cpa.svc.api.jar
 - com.sap.aii.af.lib.mod.jar
 - com.sap.aii.af.lib.mod.jar
 - com.sap.aii.af.svc_api.jar
 - sap.com~tc~logging~java~impl.jar
 
 Template code just logs the message payload and doesn't do much else.
 
 The JNDI name is used as the alias in the Integration Directory i.e. in this case JNDI is SAPPITestModule so in the integration builder add a local enterprise bean with module name SAPPITestModule
