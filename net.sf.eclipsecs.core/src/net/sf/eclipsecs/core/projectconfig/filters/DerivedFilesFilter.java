//============================================================================
//
// Copyright (C) 2002-2014  David Schneider, Lars Ködderitzsch
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//============================================================================

package net.sf.eclipsecs.core.projectconfig.filters;

import org.eclipse.core.resources.IResource;

/**
 * Implementation of a filter that filters all ressources that are derived (e.g. generated sources).
 *
 * @author Lars Ködderitzsch
 */
public class DerivedFilesFilter extends AbstractFilter {

    /**
     * {@inheritDoc}
     */
    public boolean accept(Object element) {

        boolean goesThrough = true;

        if (element instanceof IResource) {
            goesThrough = !((IResource) element).isDerived(IResource.CHECK_ANCESTORS);
        }
        return goesThrough;
    }
}
