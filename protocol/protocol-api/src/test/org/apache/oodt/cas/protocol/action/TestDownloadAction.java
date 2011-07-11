/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.oodt.cas.protocol.action;

//JUnit imports
import java.net.URISyntaxException;

import org.apache.oodt.cas.protocol.MockProtocol;
import org.apache.oodt.cas.protocol.Protocol;
import org.apache.oodt.cas.protocol.ProtocolFile;
import org.apache.oodt.cas.protocol.config.MockSpringProtocolConfig;
import org.apache.oodt.cas.protocol.system.ProtocolManager;

import junit.framework.TestCase;

/**
 * Test class for {@link DownloadAction}.
 * 
 * @author bfoster
 */
public class TestDownloadAction extends TestCase {
	
	private ProtocolManager pm;
	
	@Override
	public void setUp() {
		pm = new ProtocolManager(new MockSpringProtocolConfig());
	}
	
	public void testCreateProtocol() throws URISyntaxException {
		DownloadAction da = new DownloadAction();
		da.setUrl("http://localhost/some/file");
		Protocol protocol = da.createProtocol(pm);
		assertNotNull(protocol);
		assertTrue(protocol instanceof MockProtocol);
		assertEquals("http1", ((MockProtocol) protocol).getFactoryId());
	}
	
	public void testCreateProtocolFile() throws URISyntaxException {
		DownloadAction da = new DownloadAction();
		da.setUrl("http://localhost/some/file");
		ProtocolFile file = da.createProtocolFile();
		assertNotNull(file);
		assertEquals("/some/file", file.getPath());
		assertFalse(file.isRelative());
		assertFalse(file.isDir());
	}
	
	public void testFileDownload() throws Exception {
		DownloadAction da = new DownloadAction();
		da.setUrl("http://localhost/some/file");
		da.performAction(new ProtocolManager(new MockSpringProtocolConfig()));
		assertNotNull(da.getUsedProtocol());
		assertTrue(da.getUsedProtocol() instanceof MockProtocol);
		assertEquals(1, ((MockProtocol) da.getUsedProtocol()).getGetFiles().size());
		assertEquals("/some/file", ((MockProtocol) da.getUsedProtocol()).getGetFiles().get(0).getPath());
	}
}
