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

package net.sf.eclipsecs.core.config.configtypes;

import java.util.List;

import net.sf.eclipsecs.core.config.ICheckConfiguration;
import net.sf.eclipsecs.core.config.ResolvableProperty;

import com.puppycrawl.tools.checkstyle.PropertyResolver;

/**
 * Resolves properties set up with the check configuration.
 * 
 * @author Lars Ködderitzsch
 */
public class ResolvablePropertyResolver implements PropertyResolver {

    /** The check configuration to resolve from. */
    private ICheckConfiguration mCheckConfiguration;

    /**
     * Creates the resolver for the given check configuration.
     * 
     * @param checkConfiguration the check configuration
     */
    public ResolvablePropertyResolver(ICheckConfiguration checkConfiguration) {
        mCheckConfiguration = checkConfiguration;
    }

    /**
     * {@inheritDoc}
     */
    public String resolve(String aName) {

        String value = null;

        List<ResolvableProperty> resolvableProperties = mCheckConfiguration
                .getResolvableProperties();
        for (ResolvableProperty prop : resolvableProperties) {

            if (aName.equals(prop.getPropertyName())) {
                value = prop.getValue();
                break;
            }
        }

        return value;
    }

}
