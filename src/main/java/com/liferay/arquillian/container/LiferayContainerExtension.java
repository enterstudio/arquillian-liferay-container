/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.arquillian.container;

import com.liferay.arquillian.container.enrichers.LiferayEnricherAuxiliaryAppender;
import com.liferay.arquillian.container.enrichers.LiferayTestEnricher;
import com.liferay.arquillian.processor.LiferayOSGiProtocolProcessor;
import org.jboss.arquillian.container.spi.client.container.DeployableContainer;
import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.container.test.spi.client.deployment.ProtocolArchiveProcessor;
import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.test.spi.TestEnricher;

/**
 * @author Carlos Sierra Andrés
 */
public class LiferayContainerExtension implements LoadableExtension {

	@Override
	public void register(ExtensionBuilder builder) {
		builder.service(DeployableContainer.class, LiferayContainer.class);
		builder.service(ProtocolArchiveProcessor.class,
			LiferayOSGiProtocolProcessor.class);
		builder.service(
			AuxiliaryArchiveAppender.class,
			LiferayEnricherAuxiliaryAppender.class);
		builder.service(TestEnricher.class, LiferayTestEnricher.class);
	}
}
