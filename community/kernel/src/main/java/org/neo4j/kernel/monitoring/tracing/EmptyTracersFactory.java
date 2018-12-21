/*
 * Copyright (c) 2002-2018 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.monitoring.tracing;

import java.time.Clock;

import org.neo4j.io.pagecache.tracing.PageCacheTracer;
import org.neo4j.io.pagecache.tracing.cursor.PageCursorTracerSupplier;
import org.neo4j.kernel.impl.transaction.tracing.CheckPointTracer;
import org.neo4j.kernel.impl.transaction.tracing.TransactionTracer;
import org.neo4j.kernel.monitoring.Monitors;
import org.neo4j.logging.Log;
import org.neo4j.scheduler.JobScheduler;
import org.neo4j.storageengine.api.lock.LockTracer;
import org.neo4j.time.SystemNanoClock;

public class EmptyTracersFactory implements TracerFactory
{
    @Override
    public String getImplementationName()
    {
        return "empty";
    }

    @Override
    public PageCacheTracer createPageCacheTracer( Monitors monitors, JobScheduler jobScheduler, SystemNanoClock clock, Log log )
    {
        return PageCacheTracer.NULL;
    }

    @Override
    public TransactionTracer createTransactionTracer( Clock clock )
    {
        return TransactionTracer.NULL;
    }

    @Override
    public CheckPointTracer createCheckPointTracer( Clock clock )
    {
        return CheckPointTracer.NULL;
    }

    @Override
    public LockTracer createLockTracer( Clock clock )
    {
        return LockTracer.NONE;
    }

    @Override
    public PageCursorTracerSupplier createPageCursorTracerSupplier( Monitors monitors, JobScheduler jobScheduler )
    {
        return PageCursorTracerSupplier.NULL;
    }
}
