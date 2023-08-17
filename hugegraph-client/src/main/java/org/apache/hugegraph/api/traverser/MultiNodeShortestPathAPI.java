/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hugegraph.api.traverser;

import org.apache.hugegraph.client.OkhttpOkhttpRestClient;
import org.apache.hugegraph.rest.OkhttpRestResult;
import org.apache.hugegraph.structure.traverser.MultiNodeShortestPathRequest;
import org.apache.hugegraph.structure.traverser.PathsWithVertices;

public class MultiNodeShortestPathAPI extends TraversersAPI {

    public MultiNodeShortestPathAPI(OkhttpOkhttpRestClient client, String graph) {
        super(client, graph);
    }

    @Override
    protected String type() {
        return "multinodeshortestpath";
    }

    public PathsWithVertices post(MultiNodeShortestPathRequest request) {
        this.client.checkApiVersion("0.58", "multi node shortest path");
        OkhttpRestResult result = this.client.post(this.path(), request);
        return result.readObject(PathsWithVertices.class);
    }
}
