/*
 * Copyright (c) 2025 Oracle and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.helidon.webclient.grpc.spi;

import io.helidon.common.config.NamedService;
import io.helidon.grpc.core.WeightedBag;

import io.grpc.ClientInterceptor;

/**
 * Extension that can modify gRPC client behavior.
 */
@FunctionalInterface
public interface GrpcClientService extends NamedService {

    @Override
    default String name() {
        return type();
    }

    @Override
    default String type() {
        return "grpc-client-service";
    }

    /**
     * Insert a list of client interceptors for a client gRPC call.
     *
     * @return weighted bag of interceptors
     */
    WeightedBag<ClientInterceptor> interceptors();
}
