/*******************************************************************************
 * Copyright (c) 2012 Secure Software Engineering Group at EC SPRIDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors: Christian Fritz, Steven Arzt, Siegfried Rasthofer, Eric
 * Bodden, and others.
 ******************************************************************************/
package soot.jimple.infoflow.test.loadtime;

import java.util.LinkedList;
import java.util.List;

import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.options.Options;

public class LoadTimeConfigForTest implements IInfoflowConfig {

	public boolean useCoffi = true;
	
	@Override
	public void setSootOptions(Options options) {
		// explicitly include packages for shorter runtime:
		List<String> includeList = new LinkedList<String>();
		/*includeList.add("java.lang.");
		includeList.add("java.util.");
		includeList.add("java.io.");
		includeList.add("sun.misc.");
		includeList.add("java.net.");
		includeList.add("javax.servlet.");
		includeList.add("javax.crypto.");
		*/

		includeList.add("android.");
		includeList.add("org.apache.http.");
		includeList.add("de.test.");
		includeList.add("soot.");
		includeList.add("com.example.");
		includeList.add("libcore.icu.");
		includeList.add("securibench.");
		Options.v().set_no_bodies_for_excluded(true);
		Options.v().set_allow_phantom_refs(true);
		options.set_include(includeList);
		options.set_output_format(Options.output_format_none);
		Options.v().setPhaseOption("jb", "use-original-names:true");
		Options.v().set_keep_line_number(true);
		// Use old coffi backend to get bytecodeoffset tags
		Options.v().set_keep_offset(true);
		Options.v().set_coffi(useCoffi);
	}

}
