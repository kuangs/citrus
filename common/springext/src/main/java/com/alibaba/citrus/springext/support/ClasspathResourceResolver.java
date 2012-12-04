/*
 * Copyright (c) 2002-2012 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.citrus.springext.support;

import static org.springframework.core.io.support.ResourcePatternResolver.*;

import java.io.IOException;

import com.alibaba.citrus.springext.ResourceResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 从class loader中装载资源的<code>ResourceResolver</code>实现。
 *
 * @author Michael Zhou
 */
public class ClasspathResourceResolver extends ResourceResolver {
    private final ResourcePatternResolver resolver;

    public ClasspathResourceResolver(ClassLoader classLoader) {
        this.resolver = new PathMatchingResourcePatternResolver(classLoader);
    }

    @Override
    public Resource getResource(String location) {
        return resolver.getResource(CLASSPATH_URL_PREFIX + location);
    }

    @Override
    public Resource[] getResources(String locationPattern) throws IOException {
        return resolver.getResources(CLASSPATH_ALL_URL_PREFIX + locationPattern);
    }
}
