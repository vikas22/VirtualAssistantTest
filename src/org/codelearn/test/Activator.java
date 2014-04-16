package org.codelearn.test;

import org.eclipse.swtbot.eclipse.finder.SWTEclipseBot;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	


        private static Activator INSTANCE;

        @Override
        public void start(BundleContext context) throws Exception {
                INSTANCE=this;
                super.start(context);
        }

        public static Activator getDefault() {
                return INSTANCE;
        }


}
