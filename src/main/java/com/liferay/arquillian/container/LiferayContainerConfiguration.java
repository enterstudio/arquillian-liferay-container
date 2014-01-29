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

import org.jboss.arquillian.container.spi.ConfigurationException;
import org.jboss.arquillian.container.spi.client.container.ContainerConfiguration;

/**
 * @author Carlos Sierra Andrés
 */
public class LiferayContainerConfiguration implements ContainerConfiguration {

	public String getArquillianDeployerContext() {
		return _arquillianDeployerContext;
	}

	public void setArquillianDeployerContext(String arquillianDeployerContext) {
		_arquillianDeployerContext = arquillianDeployerContext;
	}

	public String getHost() {
		return _host;
	}

	public void setHost(String host) {
		_host = host;
	}

	public String getModuleFrameworkContext() {
		return _moduleFrameworkContext;
	}

	public void setModuleFrameworkContext(String moduleFrameworkContext) {
		_moduleFrameworkContext = moduleFrameworkContext;
	}

	public int getPort() {
		return _port;
	}

	public void setPort(int port) {
		_port = port;
	}

	public String getPortalContextRoot() {
		return _portalContextRoot;
	}

	public void setPortalContextRoot(String portalContextRoot) {
		_portalContextRoot = portalContextRoot;
	}

	public String getProtocol() {
		return _protocol;
	}

	public void setProtocol(String protocol) {
		this._protocol = protocol;
	}

	@Override
	public void validate() throws ConfigurationException {
	}

	private String _arquillianDeployerContext = "arquillian-deploy";
	private String _host = "localhost";
	private String _moduleFrameworkContext = "o";
	private int _port = 8080;
	private String _portalContextRoot = "";
	private String _protocol = "http";
}
