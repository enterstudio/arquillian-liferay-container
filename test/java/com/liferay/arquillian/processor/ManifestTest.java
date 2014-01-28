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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Manifest;


/**
 * @Author Carlos Sierra Andrés
 */
public class ManifestTest {

	@Before
	public void setup() throws IOException {
		URL resource = ManifestTest.class.getClassLoader().getResource(
			"test-manifest.mf");

		_manifest = new Manifest(resource.openStream());

		_osgiManifestUtil = OsgiManifestUtil.create(_manifest);
	}

	@Test
	public void testManifest() throws IOException {
		Assert.assertTrue(_osgiManifestUtil.isOSGiManifest(_manifest));
	}

	@Test
	public void testGetBundleClassPath() throws IOException {
		String bundleClasspath = _osgiManifestUtil.getBundleClasspath();

		System.out.println(bundleClasspath);
	}

	@Test
	public void testAppendClassPath() {
		String bundleClasspath = _osgiManifestUtil.getBundleClasspath();

		String newPath = "/WEB-INF/mijar.jar";

		Assert.assertFalse(bundleClasspath.contains(newPath));

		_osgiManifestUtil.appendToClassPath(newPath);

		String bundleClasspath2 = _osgiManifestUtil.getBundleClasspath();

		Assert.assertTrue(bundleClasspath2.contains(newPath));
	}

	private OsgiManifestUtil _osgiManifestUtil;

	private Manifest _manifest;
}
