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

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.arquillian.container.spi.client.container.DeployableContainer;
import org.jboss.arquillian.container.spi.client.container.DeploymentException;
import org.jboss.arquillian.container.spi.client.container.LifecycleException;
import org.jboss.arquillian.container.spi.client.protocol.ProtocolDescription;
import org.jboss.arquillian.container.spi.client.protocol.metadata.HTTPContext;
import org.jboss.arquillian.container.spi.client.protocol.metadata.ProtocolMetaData;
import org.jboss.arquillian.container.spi.client.protocol.metadata.Servlet;
import org.jboss.arquillian.protocol.servlet.ServletMethodExecutor;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.descriptor.api.Descriptor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * @author Carlos Sierra Andrés
 */
public class LiferayContainer
	implements DeployableContainer<LiferayContainerConfiguration> {

	@Override
	public Class<LiferayContainerConfiguration> getConfigurationClass() {
		return LiferayContainerConfiguration.class;
	}

	@Override
	public void setup(
		LiferayContainerConfiguration liferayContainerConfiguration) {

		_liferayContainerConfiguration = liferayContainerConfiguration;
	}

	@Override
	public void start() throws LifecycleException {
		// NOOP
	}

	@Override
	public void stop() throws LifecycleException {
		// NOOP
	}

	@Override
	public ProtocolDescription getDefaultProtocol() {
		return new ProtocolDescription("Servlet 2.5");
	}

	private String buildDeploymentUrl() {
		String protocol = _liferayContainerConfiguration.getProtocol();
		String host = _liferayContainerConfiguration.getHost();
		int port = _liferayContainerConfiguration.getPort();
		String portalContextRoot =
			_liferayContainerConfiguration.getPortalContextRoot();
		String moduleFrameworkContext =
			_liferayContainerConfiguration.getModuleFrameworkContext();
		String arquillianDeployerContext =
			_liferayContainerConfiguration.getArquillianDeployerContext();

		return protocol+"://"+host+":"+port+"/"+portalContextRoot+"/"+
			moduleFrameworkContext+"/"+ arquillianDeployerContext+
			"/arquillian-deploy";
	}

	@Override
	public ProtocolMetaData deploy(Archive<?> archive)
		throws DeploymentException {

		try {
			String deploymentUrl = buildDeploymentUrl();

			HttpPost httpPost = new HttpPost(deploymentUrl);

			DefaultHttpClient httpClient = new DefaultHttpClient();

			ZipExporter zipView = archive.as(ZipExporter.class);

			InputStream inputStream = zipView.exportAsInputStream();

			MultipartEntity entity = new MultipartEntity();

			entity.addPart(
				archive.getName(),
				new InputStreamBody(inputStream, archive.getName()));

			httpPost.setEntity(entity);

			HttpResponse response = httpClient.execute(httpPost);

			Header contextPath = response.getFirstHeader("Bundle-Context-Path");

			ProtocolMetaData protocolMetaData = new ProtocolMetaData();

			HTTPContext httpContext = new HTTPContext(
				_liferayContainerConfiguration.getHost(),
				_liferayContainerConfiguration.getPort());

			httpContext.add(new Servlet(
				ServletMethodExecutor.ARQUILLIAN_SERVLET_NAME,
				contextPath.getValue()));

			protocolMetaData.addContext(httpContext);

			return protocolMetaData;
		} catch (MalformedURLException e) {
			throw new DeploymentException("Invalid URL for portal", e);
		} catch (ClientProtocolException e) {
			throw new DeploymentException("Invalid URL for portal", e);
		} catch (IOException e) {
			throw new DeploymentException("Invalid URL for portal", e);
		}

	}

	@Override
	public void undeploy(Archive<?> archive) throws DeploymentException {
		String deploymentUrl = buildDeploymentUrl();

		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpDelete httpDelete = new HttpDelete(deploymentUrl);

		try {
			httpClient.execute(httpDelete);
		} catch (IOException e) {
			throw new DeploymentException("Error undeploying", e);
		}
	}

	@Override
	public void deploy(Descriptor descriptor) throws DeploymentException {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void undeploy(Descriptor descriptor) throws DeploymentException {
		throw new UnsupportedOperationException("Not implemented");
	}

	private LiferayContainerConfiguration _liferayContainerConfiguration;

}
