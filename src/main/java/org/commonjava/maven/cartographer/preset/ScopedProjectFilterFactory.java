/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc..
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.commonjava.maven.cartographer.preset;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.commonjava.atservice.annotation.Service;
import org.commonjava.maven.atlas.graph.filter.ProjectRelationshipFilter;
import org.commonjava.maven.atlas.graph.workspace.GraphWorkspace;

@Named( "scope" )
@ApplicationScoped
@Service( PresetFactory.class )
public class ScopedProjectFilterFactory
    implements PresetFactory
{

    private static final String[] IDS = { "runtime", "test", "provided", "compile", "scope" };

    @Override
    public String[] getPresetIds()
    {
        return IDS;
    }

    @Override
    public ProjectRelationshipFilter newFilter( final String presetId, final GraphWorkspace workspace,
                                                final Map<String, Object> parameters )
    {
        return null;
    }

}
