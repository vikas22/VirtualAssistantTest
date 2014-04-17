To setup the VirtualAssistantTest you need to follow below steps

Install swtbot in your eclipse https://wiki.eclipse.org/SWTBot.

If You want to run from eclipse IDE

1. Import the project in your workspace.
2. In run configuration properties select new SWTBot Test, change test runner value to junit4
3. Run the complete project under SWTBot configuration.

Note: you might face issues saying cannot resolve *** type due to version compatibility, in this case go to Manifest.mf->Depedencies->add the requrired dependencies.

If you want to run it through command line.

1. Follow the first 2 steps from above, make sure project is error free. 
2. Select VirtualAssistantTest project right-click->export->Plug-in Development->Deployable plug-ins and fragments->next-> select VirtualAssistantTest -> provide destination directory-> finish.
3. Rename the exported jar to VirtualAssistantTest.jar and copy it to plugins directory of eclipse.
4. Open test.sh, provide the adt-bundle path and workspace path.
4. Run the script. 
5. Results  will be stored in /tmp/out.xml.


 
