package org.codelearn.test;

import static org.junit.Assert.*;

import javax.swing.text.View;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.eclipse.swtbot.eclipse.finder.SWTEclipseBot;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;

public class RunTest {

private static SWTEclipseBot bot = new SWTEclipseBot();
private static SWTWorkbenchBot workBot=null;
private static SWTBotPreferences prefs=new SWTBotPreferences();
private static SWTBotTree tree = null;

	public RunTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Before
	public void init()
	{
		
		
		
	}
	@Test
	public void CheckForSucessPopup() {
		
		try
		{
			new SWTEclipseBot().view("Welcome").close();
		SWTBotShell shell = bot.shell("Codelearn Plugin");
		shell.activate();
		bot.button("OK").click();
		}
		catch(Exception e){assertTrue("Did not comeup with the success popup",false);}
	
		
	}
	
	@Test
	public void CompleteProcess()
	{
	
		bot.menu("File").menu("New").menu("Project...").click();
		try
		{
			bot.tree().expandNode("Codelearn Android project").select("Twitter App");	
		}
		catch(Exception e)
		{
			assertTrue("Could not find Codelearn Android project option in new project wizard",false);
		}
		
		//bot.tree().select("Twitter App");
		bot.button("Finish").click();
	
		try
		{
		tree=bot.viewByTitle("Package Explorer").bot().tree();
		tree.setFocus();
		tree.select("CodelearnTwitterApp");
		}
		catch(Exception e)
		{
			assertTrue("No project named CodelearnTwitterApp in CodlearnTwitterApp",false);
		}
		
		bot.menu("Run").menu("Run As").menu("1 Android App Codelearn").click();
		SWTBotShell shell=bot.shell("Launching CodelearnTwitterApp");
		shell.activate(); 
		bot.button("Run in Background").click();
		try
		{
		
		Thread.sleep(30000);
		shell=bot.shell("Android AVD Error");
		shell.activate(); 
		bot.button("No").click();
		
		shell=bot.shell("Android Device Chooser");
		shell.activate(); 
		bot.button("Cancel").click();
		
		}
		catch(Exception e)
		{
		System.out.println("Error="+e.toString());
		}
		
		try
		{
			Thread.sleep(10000);
			 shell = bot.shell("Codelearn Plugin");
			shell.activate();
			bot.button("OK").click();
		}
		catch(Exception e){
			System.out.println(e.toString());
			assertTrue("Did not comeup with the success popup",false);}
	
		
		
	}
	
	
	

}
