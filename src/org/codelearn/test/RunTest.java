package org.codelearn.test;

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.junit.Assert.assertTrue;

import org.eclipse.swtbot.eclipse.finder.SWTEclipseBot;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.Test;

public class RunTest {

private static SWTEclipseBot bot = new SWTEclipseBot();
private static SWTWorkbenchBot workBot=null;
private static SWTBotPreferences prefs=new SWTBotPreferences();
private static SWTBotTree tree = null;

	public RunTest() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	  private static SWTBotView getPackageExplorer() {
	        SWTBotView view = bot.viewByTitle("Package Explorer");
	        return view;
	    }
	

		void click(SWTEclipseBot bot,String popup,String Button)
		{
			SWTBotShell shell = bot.shell(popup);
			shell.activate();
			bot.button(Button).click();
		}
		
		
		
	  void wait(SWTEclipseBot bot, String popup)
	  {
		  try
		  {
		  while(true)
		  {
			  if(bot.shell(popup)!=null)
			  {
				  break;
			  }
			 
		  }
		  }
		  catch(Exception e)
		  {
			  
		  }
		  return;
		  
	  }
	@Test
	public void CheckForSucessPopup() {
		
		try
		{
			 SWTBotShell shell=null;
						 
		try
		{
			new SWTEclipseBot().view("Welcome").close();
		
		}
		catch(Exception e)
		{
			System.out.println("processing");
		}
		wait(bot,"Codelearn Plugin");
		click(bot,"Codelearn Plugin","OK");
		}
		catch(Exception e){assertTrue("Did not comeup with the success popup",false);}
	
		
	}
	
	@Test
	public void CompleteProcess()
	{
		SWTBotShell shell=null;
		SWTBotView packageExplorer = getPackageExplorer();
        SWTBotTree tree = packageExplorer.bot().tree();
        packageExplorer.show();
        try
        {
        if(tree.select("CodelearnTwitterApp")!=null)
        {
        tree.select("CodelearnTwitterApp");
        bot.menu("Edit").menu("Delete").click();
        shell= bot.shell("Delete Resources");
        shell.activate();
        bot.checkBox("Delete project contents on disk (cannot be undone)").select();
        bot.button("OK").click();
        bot.waitUntil(shellCloses(shell));
        }
        }
        catch(Exception e)
        {
        	
        }
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
		bot.menu("Run").menu("Run As").menu("1 Android App Codelearn").click();
		
		wait(bot,"Launching CodelearnTwitterApp");
		if(bot.shell("Launching CodelearnTwitterApp")!=null)
		{
			click(bot,"Launching CodelearnTwitterApp","Run in Background");
		 }
		}
		catch(Exception e)
		{
			assertTrue("No project named CodelearnTwitterApp in CodlearnTwitterApp",false);
		}
		
		
		
		try
		{
		
		wait(bot,"Android AVD Error");
		while(true)
		{
			
		try
		{
		click(bot,"Android AVD Error","No");
		break;
		}
		
		catch(Exception e)
		{
			wait(bot,"Android AVD Error");
			
		}
		}
		
		click(bot,"Android Device Chooser","Cancel");
		
		}
		catch(Exception e)
		{
		System.out.println("Error="+e.toString());
		}
		
		try
		{
			wait(bot,"Codelearn Plugin");
			click(bot,"Codelearn Plugin","OK");
		}
		catch(Exception e){
			System.out.println(e.toString());
			assertTrue("Did not comeup with the success popup",false);}
	
		
		
	}
	
	
	

}
