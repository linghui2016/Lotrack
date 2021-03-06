/*******************************************************************************
 * Copyright (c) 2015 Eric Bodden.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Eric Bodden - initial API and implementation
 ******************************************************************************/
package heros.solver;

import java.util.List;

public interface TopologicalSorter<N, M> {
	List<N> getPseudoTopologicalOrder(M method);
	
}
