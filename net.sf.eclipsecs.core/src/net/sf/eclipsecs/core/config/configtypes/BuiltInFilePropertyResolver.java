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

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.FileLocator;

import com.puppycrawl.tools.checkstyle.PropertyResolver;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

/**
 * Adds support for additional checkstyle config files (header, suppressions
 * etc.) to be delivered with a builtin configuration.
 * 
 * @author Lars Ködderitzsch
 */
public class BuiltInFilePropertyResolver implements PropertyResolver {

    /** constant for the samedir variable. */
    private static final String SAMEDIR_LOC = "samedir"; //$NON-NLS-1$

    /** constant for the config_loc variable. */
    private static final String CONFIG_LOC = "config_loc"; //$NON-NLS-1$

    private final String mBuiltInConfigLocation;

    /**
     * Creates the resolver.
     * 
     * @param builtInConfigLocation the bundle based url of the builtin
     *            configuration file
     */
    public BuiltInFilePropertyResolver(String builtInConfigLocation) {
        mBuiltInConfigLocation = builtInConfigLocation;
    }

    /**
     * {@inheritDoc}
     */
    public String resolve(String property) throws CheckstyleException {

        String value = null;

        if ((SAMEDIR_LOC.equals(property) || CONFIG_LOC.equals(property))
                && mBuiltInConfigLocation != null) {

            int lastSlash = mBuiltInConfigLocation.lastIndexOf("/"); //$NON-NLS-1$
            if (lastSlash > -1) {
                value = mBuiltInConfigLocation.substring(0, lastSlash + 1);
            }
        }

        if (value != null) {
            try {
                URL bundleLocatedURL = new URL(value);
                URL fileURL = FileLocator.toFileURL(bundleLocatedURL);

                value = FileUtils.toFile(fileURL).toString();
            }
            catch (IOException e) {
                throw new CheckstyleException(e.getMessage(), e);
            }
        }

        return value;
    }

}
