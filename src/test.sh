#!/bin/bash
rm -rf ~/workspace-2/CodelearnTwitterApp 
sed -i "s/true/false/" ~/Desktop/adt-bundle-linux-x86-20131030/eclipse/dropins/config.properties

eclipse= ~/Desktop/adt-bundle-linux-x86-20131030/
workspace=  ~/workspace-2 
java \
-Xms256M -Xmx768M -XX:MaxPermSize=512M \
-jar $eclipse/eclipse/plugins/org.eclipse.equinox.launcher_*.jar \
-application org.eclipse.swtbot.eclipse.junit.headless.swtbottestapplication \
-product com.android.ide.eclipse.adt.package.product \
-testApplication org.eclipse.ui.ide.workbench \
-data ~/$workspace \
-testPluginName VirtualAssistantTest \
formatter=org.apache.tools.ant.taskdefs.optional.junit.XMLJUnitResultFormatter,/tmp/out.xml \
formatter=org.apache.tools.ant.taskdefs.optional.junit.PlainJUnitResultFormatter \
-className org.codelearn.test.RunTest \
-os linux -ws gtk -arch x86 \
-consoleLog -debug

