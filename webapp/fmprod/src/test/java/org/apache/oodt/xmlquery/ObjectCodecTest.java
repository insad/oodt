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


package org.apache.oodt.xmlquery;

import org.apache.oodt.xmlquery.ObjectCodec; // Imported for javadoc

/** Unit test the {@link ObjectCodec} class.
 *
 * @author Kelly
 */ 
public class ObjectCodecTest extends CodecTest {
	/** Construct the test case for the {@link ObjectCodec} class. */
	public ObjectCodecTest(String name) {
		super(name);
	}

	public void testIt() throws Exception {
		runTest(CodecFactory.createCodec("org.apache.oodt.xmlquery.ObjectCodec"));
	}

	public long getTestSize() {
		// Serialization overhead adds a few bytes, so we override the method here
		// with this value:
		return 30;
	}
}
