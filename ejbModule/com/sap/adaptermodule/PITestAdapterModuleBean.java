/**
 * 
 */
package com.sap.adaptermodule;

// Classes for EJB 
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext; // Classes for Module development & Trace 
import com.sap.aii.af.lib.mp.module.*;
import com.sap.engine.interfaces.messaging.api.*;
import com.sap.engine.interfaces.messaging.api.auditlog.*;
import com.sap.tc.logging.*; // XML parsing and transformation classes 
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.xml.transform.*;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class PITestAdapterModuleBean implements SessionBean, Module {
	public static final String VERSION_ID = "$Id://tc/aii/30_REL/src/_adapters/_sample/java/user/module/PITestAdapterModuleBean.java#1 $";
	static final long serialVersionUID = 7435850550539048631L;
	//private SessionContext myContext;

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		//myContext = context;
	}

	public void ejbCreate() throws CreateException {
	}

	public ModuleData process(ModuleContext moduleContext, ModuleData inputModuleData) throws ModuleException {
		Location location = null;
		try {
			location = Location.getLocation(this.getClass().getName());
		} catch (Exception t) {
			t.printStackTrace();
			ModuleException me = new ModuleException(
					"Unable to create trace location", t);
			throw me;
		}
		//This will show up in all SAP Java logs as its at error level, by default logs only display errors unless higher level set in config
		location.errorT(inputModuleData.contentToString());
		Object obj = null;
		Message msg = null;
		MessageKey key = null;
		try {
			obj = inputModuleData.getPrincipalData();
			msg = (Message) obj;
			key = new MessageKey(msg.getMessageId(), msg.getMessageDirection());
		} catch (Exception e) {
			ModuleException me = new ModuleException(e);
			throw me;
		}
		if(msg != null) {
			location.errorT("Msg Payload: " + msg.getDocument().getText());
		} else {
			location.errorT("No message payload");
		}
		return inputModuleData;
	}
}