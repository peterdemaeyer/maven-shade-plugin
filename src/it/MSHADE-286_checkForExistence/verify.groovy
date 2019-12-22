/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

def mainMainJarFile = new File( basedir, "main/target/mshade-286-main-1.0.jar" )
def mainTestJarFile = new File ( basedir, "main/target/mshade-286-main-1.0-tests.jar" )
def testMainJarFile = new File( basedir, "test/target/mshade-286-test-1.0.jar" )
def testTestJarFile = new File ( basedir, "test/target/mshade-286-test-1.0-tests.jar" )
def uberMainJarFile = new File( basedir, "uber/target/mshade-286-uber-1.0.jar" )
def uberTestJarFile = new File ( basedir, "uber/target/mshade-286-uber-1.0-tests.jar" )

assert true == mainMainJarFile.exists()
assert false == mainTestJarFile.exists()
assert false == testMainJarFile.exists()
assert true == testTestJarFile.exists()
assert true == uberMainJarFile.exists()
assert true == uberTestJarFile.exists()

def jarFile = new java.util.jar.JarFile( uberMainJarFile )
try
{
    assert null != jarFile.getJarEntry( "Main.class" )
    assert null == jarFile.getJarEntry( "Test.class" )
}
finally
{
    jarFile.close()
}

def testJarFile = new java.util.jar.JarFile( uberTestJarFile )
try
{
    assert null == testJarFile.getJarEntry( "Main.class" )
    assert null != testJarFile.getJarEntry( "Test.class" )
}
finally
{
    testJarFile.close()
}
