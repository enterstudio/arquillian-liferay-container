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
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * @author Carlos Sierra Andrés
 */
public class LiferayContainer implements DeployableContainer<LiferayContainerConfiguration> {

	@Override
	public Class<LiferayContainerConfiguration> getConfigurationClass() {
		return LiferayContainerConfiguration.class;
	}

	@Override
	public void setup(LiferayContainerConfiguration liferayContainerConfiguration) {

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

	@Override
	public ProtocolMetaData deploy(Archive<?> archive) throws DeploymentException {
		String deploymentUrl = null;

		try {
			deploymentUrl =
				"http://localhost:8080/o/arquillian-deploy/arquillian-deploy?location=dummy";

			HttpPost httpPost = new HttpPost(deploymentUrl);

			DefaultHttpClient httpClient = new DefaultHttpClient();

			ZipExporter zipView = archive.as(ZipExporter.class);

			InputStream inputStream = zipView.exportAsInputStream();

			HttpEntity entity = MultipartEntityBuilder.create().addBinaryBody(
				archive.getName(), inputStream).build();

			httpPost.setEntity(entity);

			HttpResponse response = httpClient.execute(httpPost);

			Header contextPath = response.getFirstHeader("Bundle-Context-Path");

			ProtocolMetaData protocolMetaData = new ProtocolMetaData();

			HTTPContext httpContext = new HTTPContext("localhost", 8080);

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
		String deploymentUrl =
			"http://localhost:8080/o/arquillian-deploy/arquillian-deploy?location=dummy";

		HttpPost httpPost = new HttpPost(deploymentUrl);

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
