//============================================================================
//
// Copyright (C) 2002-2004  David Schneider
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

package com.atlassw.tools.eclipse.checkstyle.config.configtypes;

import java.net.URL;

import org.eclipse.core.runtime.Path;

import com.atlassw.tools.eclipse.checkstyle.CheckstylePlugin;

/**
 * Implementation of the configuration type for a built in check configuration,
 * that is located inside the plugin.
 * 
 * @author Lars K�dderitzsch
 */
public class BuiltInCheckConfiguration extends AbstractCheckConfiguration
{

    /**
     * @see AbstractCheckConfiguration#handleGetLocation()
     */
    protected URL handleGetLocation()
    {
        return CheckstylePlugin.getDefault().find(new Path(getLocation()));
    }

    /**
     * @see AbstractCheckConfiguration#handleIsEditable()
     */
    protected boolean handleIsEditable()
    {
        // Built-in configurations cannot be changed
        return false;
    }

    /**
     * @see AbstractCheckConfiguration#handleIsConfigurable()
     */
    protected boolean handleIsConfigurable()
    {
        // Built-in configurations cannot be configured
        return false;
    }
}