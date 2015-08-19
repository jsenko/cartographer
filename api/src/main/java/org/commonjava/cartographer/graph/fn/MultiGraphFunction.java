package org.commonjava.cartographer.graph.fn;

import java.util.Map;

import org.commonjava.maven.atlas.graph.RelationshipGraph;
import org.commonjava.cartographer.CartoDataException;
import org.commonjava.cartographer.request.GraphDescription;

public interface MultiGraphFunction<T>
{
    void extract( T elements, Map<GraphDescription, RelationshipGraph> graphs )
        throws CartoDataException;
}