package com.appian.robot.core.template;

import java.io.IOException;
import java.util.List;

import com.novayre.jidoka.client.api.IJidokaServer;
import com.novayre.jidoka.client.api.IRobot;
import com.novayre.jidoka.client.api.JidokaFactory;
import com.novayre.jidoka.client.api.JidokaMethod;
import com.novayre.jidoka.client.api.JidokaParameter;
import com.novayre.jidoka.client.api.annotations.Robot;
import com.novayre.jidoka.client.api.execution.IUsernamePassword;
import com.novayre.jidoka.client.api.multios.IClient;


/**
 * The Class RobotBlankTemplate.
 */
/**
 * Action "startUp".
 * <p>
 * This method is overriden to initialize the Appian RPA modules instances.
 */
 
@Robot
public class Local_Try implements IRobot {


	private IJidokaServer<?> server;
	private IClient client;
	private String username;
	private String password;
	private List<IUsernamePassword> credentials;
	//private Map<String, IRobotVariable> variables;
	//private static String applicationPath = "C:\\Users\\u404942\\Desktop\\rpa-installer - Shortcut.lnk";

	@JidokaMethod(name="Start UP", description="Starting the process") public boolean init() throws Exception {

		server = (IJidokaServer< ? >) JidokaFactory.getServer();
		client = IClient.getInstance(this); 
		return IRobot.super.startUp();


	}



	@JidokaMethod(name="Open Application", description="Opening the Application")
	public void openshortcut(
			@JidokaParameter(
					name="Application Path")String applicationPath) throws IOException, InterruptedException {

		//variables = server.getWorkflowVariables();
		//applicationPath=variables.get("applicationPath").getValue();
		try {
			credentials = server.getCredentials("Local_Try");
			username = credentials.get(0).getUsername();
			password = credentials.get(0).getPassword();

			
		} catch(Exception e) {
			server.info("Invalid/Empty Credentials");
		}


	}





}
