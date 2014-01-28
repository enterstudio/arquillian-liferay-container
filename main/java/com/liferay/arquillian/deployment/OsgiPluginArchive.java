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

package com.liferay.arquillian.deployment;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchiveEventHandler;
import org.jboss.shrinkwrap.api.ArchiveFormat;
import org.jboss.shrinkwrap.api.ArchivePath;
import org.jboss.shrinkwrap.api.Assignable;
import org.jboss.shrinkwrap.api.Filter;
import org.jboss.shrinkwrap.api.IllegalArchivePathException;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.asset.NamedAsset;
import org.jboss.shrinkwrap.api.exporter.StreamExporter;
import org.jboss.shrinkwrap.api.formatter.Formatter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

/**
 * @author Carlos Sierra Andrés
 */
public class OsgiPluginArchive implements WebArchive {

	public OsgiPluginArchive() {
		this._wrapped = ShrinkWrap.create(WebArchive.class);

	}

	public WebArchive addService(String name) {
		return this;
	}

	@Override
	public String getName() {
		return _wrapped.getName();
	}

	@Override
	public String getId() {
		return _wrapped.getId();
	}

	@Override
	public WebArchive add(Asset asset, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.add(asset, target);
	}

	@Override
	public WebArchive add(Asset asset, ArchivePath target, String name) throws IllegalArgumentException {
		return _wrapped.add(asset, target, name);
	}

	@Override
	public WebArchive add(Asset asset, String target, String name) throws IllegalArgumentException {
		return _wrapped.add(asset, target, name);
	}

	@Override
	public WebArchive add(NamedAsset namedAsset) throws IllegalArgumentException {
		return _wrapped.add(namedAsset);
	}

	@Override
	public WebArchive add(Asset asset, String target) throws IllegalArgumentException {
		return _wrapped.add(asset, target);
	}

	@Override
	public WebArchive addAsDirectory(String path) throws IllegalArgumentException {
		return _wrapped.addAsDirectory(path);
	}

	@Override
	public WebArchive addAsDirectories(String... paths) throws IllegalArgumentException {
		return _wrapped.addAsDirectories(paths);
	}

	@Override
	public WebArchive addAsDirectory(ArchivePath path) throws IllegalArgumentException {
		return _wrapped.addAsDirectory(path);
	}

	@Override
	public WebArchive addAsDirectories(ArchivePath... paths) throws IllegalArgumentException {
		return _wrapped.addAsDirectories(paths);
	}

	@Override
	public WebArchive addHandlers(ArchiveEventHandler... handlers) {
		return _wrapped.addHandlers(handlers);
	}

	@Override
	public Node get(ArchivePath path) throws IllegalArgumentException {
		return _wrapped.get(path);
	}

	@Override
	public Node get(String path) throws IllegalArgumentException {
		return _wrapped.get(path);
	}

	@Override
	public <X extends Archive<X>> X getAsType(Class<X> type, String path) {
		return _wrapped.getAsType(type, path);
	}

	@Override
	public <X extends Archive<X>> X getAsType(Class<X> type, ArchivePath path) {
		return _wrapped.getAsType(type, path);
	}

	@Override
	public <X extends Archive<X>> Collection<X> getAsType(Class<X> type, Filter<ArchivePath> filter) {
		return _wrapped.getAsType(type, filter);
	}

	@Override
	public <X extends Archive<X>> X getAsType(Class<X> type, String path, ArchiveFormat archiveFormat) {
		return _wrapped.getAsType(type, path, archiveFormat);
	}

	@Override
	public <X extends Archive<X>> X getAsType(Class<X> type, ArchivePath path, ArchiveFormat archiveFormat) {
		return _wrapped.getAsType(type, path, archiveFormat);
	}

	@Override
	public <X extends Archive<X>> Collection<X> getAsType(Class<X> type, Filter<ArchivePath> filter, ArchiveFormat archiveFormat) {
		return _wrapped.getAsType(type, filter, archiveFormat);
	}

	@Override
	public boolean contains(ArchivePath path) throws IllegalArgumentException {
		return _wrapped.contains(path);
	}

	@Override
	public boolean contains(String path) throws IllegalArgumentException {
		return _wrapped.contains(path);
	}

	@Override
	public Node delete(ArchivePath path) throws IllegalArgumentException {
		return _wrapped.delete(path);
	}

	@Override
	public Node delete(String archivePath) throws IllegalArgumentException {
		return _wrapped.delete(archivePath);
	}

	@Override
	public Map<ArchivePath,Node> getContent() {
		return _wrapped.getContent();
	}

	@Override
	public Map<ArchivePath,Node> getContent(Filter<ArchivePath> filter) {
		return _wrapped.getContent(filter);
	}

	@Override
	public WebArchive add(Archive<?> archive, ArchivePath path, Class<? extends StreamExporter> exporter) throws IllegalArgumentException {
		return _wrapped.add(archive, path, exporter);
	}

	@Override
	public WebArchive add(Archive<?> archive, String path, Class<? extends StreamExporter> exporter) throws IllegalArgumentException {
		return _wrapped.add(archive, path, exporter);
	}

	@Override
	public WebArchive merge(Archive<?> source) throws IllegalArgumentException {
		return _wrapped.merge(source);
	}

	@Override
	public WebArchive merge(Archive<?> source, Filter<ArchivePath> filter) throws IllegalArgumentException {
		return _wrapped.merge(source, filter);
	}

	@Override
	public WebArchive merge(Archive<?> source, ArchivePath path) throws IllegalArgumentException {
		return _wrapped.merge(source, path);
	}

	@Override
	public WebArchive merge(Archive<?> source, String path) throws IllegalArgumentException {
		return _wrapped.merge(source, path);
	}

	@Override
	public WebArchive merge(Archive<?> source, ArchivePath path, Filter<ArchivePath> filter) throws IllegalArgumentException {
		return _wrapped.merge(source, path, filter);
	}

	@Override
	public WebArchive merge(Archive<?> source, String path, Filter<ArchivePath> filter) throws IllegalArgumentException {
		return _wrapped.merge(source, path, filter);
	}

	@Override
	public WebArchive move(ArchivePath source, ArchivePath target) throws IllegalArgumentException, IllegalArchivePathException {
		return _wrapped.move(source, target);
	}

	@Override
	public WebArchive move(String source, String target) throws IllegalArgumentException, IllegalArchivePathException {
		return _wrapped.move(source, target);
	}

	@Override
	public String toString() {
		return _wrapped.toString();
	}

	@Override
	public String toString(boolean verbose) {
		return _wrapped.toString(verbose);
	}

	@Override
	public String toString(Formatter formatter) throws IllegalArgumentException {
		return _wrapped.toString(formatter);
	}

	@Override
	public void writeTo(OutputStream outputStream, Formatter formatter) throws IllegalArgumentException {
		_wrapped.writeTo(outputStream, formatter);
	}

	@Override
	public Archive<WebArchive> shallowCopy() {
		return _wrapped.shallowCopy();
	}

	@Override
	public <TYPE extends Assignable> TYPE as(Class<TYPE> clazz) {
		return _wrapped.as(clazz);
	}

	@Override
	public WebArchive addAsLibrary(String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resourceName);
	}

	@Override
	public WebArchive addAsLibrary(File resource) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource);
	}

	@Override
	public WebArchive addAsLibrary(String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resourceName, target);
	}

	@Override
	public WebArchive addAsLibrary(File resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource, target);
	}

	@Override
	public WebArchive addAsLibrary(URL resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource, target);
	}

	@Override
	public WebArchive addAsLibrary(Asset resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource, target);
	}

	@Override
	public WebArchive addAsLibrary(String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resourceName, target);
	}

	@Override
	public WebArchive addAsLibrary(File resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource, target);
	}

	@Override
	public WebArchive addAsLibrary(URL resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource, target);
	}

	@Override
	public WebArchive addAsLibrary(Asset resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(resource, target);
	}

	@Override
	public WebArchive addAsLibrary(Archive<?> archive) throws IllegalArgumentException {
		return _wrapped.addAsLibrary(archive);
	}

	@Override
	public WebArchive addAsLibraries(String... resourceNames) throws IllegalArgumentException {
		return _wrapped.addAsLibraries(resourceNames);
	}

	@Override
	public WebArchive addAsLibraries(File... resources) throws IllegalArgumentException {
		return _wrapped.addAsLibraries(resources);
	}

	@Override
	public WebArchive addAsLibraries(Archive<?>... archives) throws IllegalArgumentException {
		return _wrapped.addAsLibraries(archives);
	}

	@Override
	public WebArchive addAsLibraries(Collection<? extends Archive<?>> archives) throws IllegalArgumentException {
		return _wrapped.addAsLibraries(archives);
	}

	@Override
	public WebArchive addAsLibraries(Archive<?>[]... archives) throws IllegalArgumentException {
		return _wrapped.addAsLibraries(archives);
	}

	@Override
	public WebArchive setWebXML(String resourceName) throws IllegalArgumentException {
		return _wrapped.setWebXML(resourceName);
	}

	@Override
	public WebArchive setWebXML(File resource) throws IllegalArgumentException {
		return _wrapped.setWebXML(resource);
	}

	@Override
	public WebArchive setWebXML(URL resource) throws IllegalArgumentException {
		return _wrapped.setWebXML(resource);
	}

	@Override
	public WebArchive setWebXML(Asset resource) throws IllegalArgumentException {
		return _wrapped.setWebXML(resource);
	}

	@Override
	public WebArchive setWebXML(Package resourcePackage, String resourceName) throws IllegalArgumentException {
		return _wrapped.setWebXML(resourcePackage, resourceName);
	}

	@Override
	public WebArchive addAsWebResource(String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resourceName);
	}

	@Override
	public WebArchive addAsWebResource(File resource) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource);
	}

	@Override
	public WebArchive addAsWebResource(String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resourceName, target);
	}

	@Override
	public WebArchive addAsWebResource(File resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource, target);
	}

	@Override
	public WebArchive addAsWebResource(URL resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource, target);
	}

	@Override
	public WebArchive addAsWebResource(Asset resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource, target);
	}

	@Override
	public WebArchive addAsWebResource(String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resourceName, target);
	}

	@Override
	public WebArchive addAsWebResource(File resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource, target);
	}

	@Override
	public WebArchive addAsWebResource(URL resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource, target);
	}

	@Override
	public WebArchive addAsWebResource(Asset resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resource, target);
	}

	@Override
	public WebArchive addAsWebResources(Package resourcePackage, String... resourceNames) throws IllegalArgumentException {
		return _wrapped.addAsWebResources(resourcePackage, resourceNames);
	}

	@Override
	public WebArchive addAsWebResource(Package resourcePackage, String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resourcePackage, resourceName);
	}

	@Override
	public WebArchive addAsWebResource(Package resourcePackage, String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsWebResource(Package resourcePackage, String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsWebInfResource(String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resourceName);
	}

	@Override
	public WebArchive addAsWebInfResource(File resource) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource);
	}

	@Override
	public WebArchive addAsWebInfResource(String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resourceName, target);
	}

	@Override
	public WebArchive addAsWebInfResource(File resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource, target);
	}

	@Override
	public WebArchive addAsWebInfResource(URL resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource, target);
	}

	@Override
	public WebArchive addAsWebInfResource(Asset resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource, target);
	}

	@Override
	public WebArchive addAsWebInfResource(String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resourceName, target);
	}

	@Override
	public WebArchive addAsWebInfResource(File resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource, target);
	}

	@Override
	public WebArchive addAsWebInfResource(URL resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource, target);
	}

	@Override
	public WebArchive addAsWebInfResource(Asset resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resource, target);
	}

	@Override
	public WebArchive addAsWebInfResources(Package resourcePackage, String... resourceNames) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResources(resourcePackage, resourceNames);
	}

	@Override
	public WebArchive addAsWebInfResource(Package resourcePackage, String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resourcePackage, resourceName);
	}

	@Override
	public WebArchive addAsWebInfResource(Package resourcePackage, String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsWebInfResource(Package resourcePackage, String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsWebInfResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsResource(String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourceName);
	}

	@Override
	public WebArchive addAsResource(File resource) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource);
	}

	@Override
	public WebArchive addAsResource(String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourceName, target);
	}

	@Override
	public WebArchive addAsResource(File resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource, target);
	}

	@Override
	public WebArchive addAsResource(URL resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource, target);
	}

	@Override
	public WebArchive addAsResource(Asset resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource, target);
	}

	@Override
	public WebArchive addAsResource(String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourceName, target);
	}

	@Override
	public WebArchive addAsResource(String resourceName, ArchivePath target, ClassLoader classLoader) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourceName, target, classLoader);
	}

	@Override
	public WebArchive addAsResource(File resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource, target);
	}

	@Override
	public WebArchive addAsResource(URL resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource, target);
	}

	@Override
	public WebArchive addAsResource(Asset resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resource, target);
	}

	@Override
	public WebArchive addAsResources(Package resourcePackage, String... resourceNames) throws IllegalArgumentException {
		return _wrapped.addAsResources(resourcePackage, resourceNames);
	}

	@Override
	public WebArchive addAsResource(Package resourcePackage, String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourcePackage, resourceName);
	}

	@Override
	public WebArchive addAsResource(Package resourcePackage, String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsResource(Package resourcePackage, String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsServiceProviderAndClasses(Class<?> serviceInterface, Class<?>... serviceImpls) throws IllegalArgumentException {
		return _wrapped.addAsServiceProviderAndClasses(serviceInterface, serviceImpls);
	}

	@Override
	public WebArchive setManifest(String resourceName) throws IllegalArgumentException {
		return _wrapped.setManifest(resourceName);
	}

	@Override
	public WebArchive setManifest(File resource) throws IllegalArgumentException {
		return _wrapped.setManifest(resource);
	}

	@Override
	public WebArchive setManifest(URL resource) throws IllegalArgumentException {
		return _wrapped.setManifest(resource);
	}

	@Override
	public WebArchive setManifest(Asset resource) throws IllegalArgumentException {
		return _wrapped.setManifest(resource);
	}

	@Override
	public WebArchive setManifest(Package resourcePackage, String resourceName) throws IllegalArgumentException {
		return _wrapped.setManifest(resourcePackage, resourceName);
	}

	@Override
	public WebArchive addAsManifestResource(String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resourceName);
	}

	@Override
	public WebArchive addAsManifestResource(File resource) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource);
	}

	@Override
	public WebArchive addAsManifestResource(String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resourceName, target);
	}

	@Override
	public WebArchive addAsManifestResource(File resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource, target);
	}

	@Override
	public WebArchive addAsManifestResource(URL resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource, target);
	}

	@Override
	public WebArchive addAsManifestResource(Asset resource, String target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource, target);
	}

	@Override
	public WebArchive addAsManifestResource(String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resourceName, target);
	}

	@Override
	public WebArchive addAsManifestResource(File resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource, target);
	}

	@Override
	public WebArchive addAsManifestResource(URL resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource, target);
	}

	@Override
	public WebArchive addAsManifestResource(Asset resource, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resource, target);
	}

	@Override
	public WebArchive addAsManifestResources(Package resourcePackage, String... resourceNames) throws IllegalArgumentException {
		return _wrapped.addAsManifestResources(resourcePackage, resourceNames);
	}

	@Override
	public WebArchive addAsManifestResource(Package resourcePackage, String resourceName) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resourcePackage, resourceName);
	}

	@Override
	public WebArchive addAsManifestResource(Package resourcePackage, String resourceName, String target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsManifestResource(Package resourcePackage, String resourceName, ArchivePath target) throws IllegalArgumentException {
		return _wrapped.addAsManifestResource(resourcePackage, resourceName, target);
	}

	@Override
	public WebArchive addAsServiceProvider(Class<?> serviceInterface, Class<?>... serviceImpls) throws IllegalArgumentException {
		return _wrapped.addAsServiceProvider(serviceInterface, serviceImpls);
	}

	@Override
	public WebArchive addAsServiceProvider(String serviceInterface, String... serviceImpls) {
		return _wrapped.addAsServiceProvider(serviceInterface, serviceImpls);
	}

	@Override
	public WebArchive addManifest() throws IllegalArgumentException {
		return _wrapped.addManifest();
	}

	@Override
	public WebArchive addClass(Class<?> clazz) throws IllegalArgumentException {
		return _wrapped.addClass(clazz);
	}

	@Override
	public WebArchive addClass(String fullyQualifiedClassName) throws IllegalArgumentException {
		return _wrapped.addClass(fullyQualifiedClassName);
	}

	@Override
	public WebArchive addClass(String fullyQualifiedClassName, ClassLoader cl) throws IllegalArgumentException {
		return _wrapped.addClass(fullyQualifiedClassName, cl);
	}

	@Override
	public WebArchive addClasses(Class<?>... classes) throws IllegalArgumentException {
		return _wrapped.addClasses(classes);
	}

	@Override
	public WebArchive addPackage(Package pack) throws IllegalArgumentException {
		return _wrapped.addPackage(pack);
	}

	@Override
	public WebArchive addDefaultPackage() {
		return _wrapped.addDefaultPackage();
	}

	@Override
	public WebArchive addPackages(boolean recursive, Package... packages) throws IllegalArgumentException {
		return _wrapped.addPackages(recursive, packages);
	}

	@Override
	public WebArchive addPackages(boolean recursive, Filter<ArchivePath> filter, Package... packages) throws IllegalArgumentException {
		return _wrapped.addPackages(recursive, filter, packages);
	}

	@Override
	public WebArchive addPackage(String pack) throws IllegalArgumentException {
		return _wrapped.addPackage(pack);
	}

	@Override
	public WebArchive addPackages(boolean recursive, String... packages) throws IllegalArgumentException {
		return _wrapped.addPackages(recursive, packages);
	}

	@Override
	public WebArchive addPackages(boolean recursive, Filter<ArchivePath> filter, String... packages) throws IllegalArgumentException {
		return _wrapped.addPackages(recursive, filter, packages);
	}

	@Override
	public WebArchive deleteClass(Class<?> clazz) throws IllegalArgumentException {
		return _wrapped.deleteClass(clazz);
	}

	@Override
	public WebArchive deleteClass(String fullyQualifiedClassName) throws IllegalArgumentException {
		return _wrapped.deleteClass(fullyQualifiedClassName);
	}

	@Override
	public WebArchive deleteClasses(Class<?>... classes) throws IllegalArgumentException {
		return _wrapped.deleteClasses(classes);
	}

	@Override
	public WebArchive deletePackage(Package pack) throws IllegalArgumentException {
		return _wrapped.deletePackage(pack);
	}

	@Override
	public WebArchive deletePackage(String pack) throws IllegalArgumentException {
		return _wrapped.deletePackage(pack);
	}

	@Override
	public WebArchive deleteDefaultPackage() {
		return _wrapped.deleteDefaultPackage();
	}

	@Override
	public WebArchive deletePackages(boolean recursive, Package... packages) throws IllegalArgumentException {
		return _wrapped.deletePackages(recursive, packages);
	}

	@Override
	public WebArchive deletePackages(boolean recursive, String... packages) throws IllegalArgumentException {
		return _wrapped.deletePackages(recursive, packages);
	}

	@Override
	public WebArchive deletePackages(boolean recursive, Filter<ArchivePath> filter, Package... packages) throws IllegalArgumentException {
		return _wrapped.deletePackages(recursive, filter, packages);
	}

	@Override
	public WebArchive deletePackages(boolean recursive, Filter<ArchivePath> filter, String... packages) throws IllegalArgumentException {
		return _wrapped.deletePackages(recursive, filter, packages);
	}

	private WebArchive _wrapped;
}
