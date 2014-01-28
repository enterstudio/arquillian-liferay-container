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

package com.liferay.arquillian.processor;

import org.jboss.arquillian.container.spi.client.deployment.Validate;
import org.jboss.arquillian.container.test.spi.TestDeployment;
import org.jboss.arquillian.container.test.spi.client.deployment.ProtocolArchiveProcessor;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.jar.Manifest;

/**
 * @author Carlos Sierra Andrés
 */
public class LiferayOSGiProtocolProcessor implements ProtocolArchiveProcessor {

	@Override
	public void process(
		TestDeployment testDeployment, Archive<?> protocolArchive) {

		Archive<?> applicationArchive = testDeployment.getApplicationArchive();

		Manifest manifest = findManifest(applicationArchive);

		OsgiManifestUtil osgiManifestUtil = OsgiManifestUtil.create(manifest);

		Collection<Archive<?>> auxiliaryArchives =
			testDeployment.getAuxiliaryArchives();

		for (Archive<?> auxiliaryArchive : auxiliaryArchives) {
			if (Validate.isArchiveOfType(JavaArchive.class, auxiliaryArchive)) {
				osgiManifestUtil.appendToClassPath(
					"WEB-INF/lib/" + auxiliaryArchive.getName());
			}
		}

		osgiManifestUtil.appendToImport("javax.servlet");
		osgiManifestUtil.appendToImport("javax.servlet.http");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			osgiManifestUtil.writeTo(baos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ByteArrayAsset byteArrayAsset = new ByteArrayAsset(baos.toByteArray());

		replaceManifest(applicationArchive, byteArrayAsset);
	}

	private void replaceManifest(
		Archive<?> archive, ByteArrayAsset byteArrayAsset) {

		archive.delete("META-INF/MANIFEST.MF");

		archive.add(byteArrayAsset, "META-INF/MANIFEST.MF");
	}

	protected Manifest findManifest(Archive<?> archive) {
		Node manifestNode = archive.get("META-INF/MANIFEST.MF");

		if (manifestNode == null) {
			return null;
		}

		InputStream inputStream = manifestNode.getAsset().openStream();

		try {
			Manifest manifest = new Manifest(inputStream);
			return manifest;
		}
	 	catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


}
