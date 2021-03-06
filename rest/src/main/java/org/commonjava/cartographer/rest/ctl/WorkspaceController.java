/**
 * Copyright (C) 2013 Red Hat, Inc. (jdcasey@commonjava.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.cartographer.rest.ctl;

import org.commonjava.cartographer.rest.CartoRESTException;
import org.commonjava.cartographer.rest.dto.WorkspaceList;
import org.commonjava.maven.atlas.graph.RelationshipGraphException;
import org.commonjava.maven.atlas.graph.RelationshipGraphFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;

@ApplicationScoped
public class WorkspaceController
{

    @Inject
    private RelationshipGraphFactory graphFactory;

    public void delete( final String id )
            throws CartoRESTException
    {
        try
        {
            if ( !graphFactory.deleteWorkspace( id ) )
            {
                throw new CartoRESTException( "Delete failed for workspace: {}", id );
            }
        }
        catch ( final RelationshipGraphException e )
        {
            throw new CartoRESTException( "Error deleting workspace: {}. Reason: {}", e, id, e.getMessage() );
        }
    }

    public WorkspaceList list()
                    throws CartoRESTException
    {
        Set<String> ids = graphFactory.listWorkspaces();
        return new WorkspaceList( ids );
    }

}
