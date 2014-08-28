/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 8042251
 * @summary Testing InnerClasses_attribute of inner annotations in inner enum.
 * @library /tools/lib /tools/javac/lib ../lib
 * @build InnerClassesInInnerClassTestBase InnerClassesTestBase TestBase TestResult InMemoryFileManager ToolBox
 * @run main InnerAnnotationsInInnerEnumTest
 */

public class InnerAnnotationsInInnerEnumTest extends InnerClassesInInnerClassTestBase {

    public static void main(String[] args) throws TestFailedException {
        InnerClassesTestBase test = new InnerAnnotationsInInnerEnumTest();
        test.test("InnerClassesSrc$Inner", "Inner", "1");
    }

    @Override
    public void setProperties() {
        setOuterOtherModifiers(Modifier.EMPTY, Modifier.STATIC);
        setInnerOtherModifiers(Modifier.EMPTY, Modifier.STATIC, Modifier.ABSTRACT);
        setOuterClassType(ClassType.ENUM);
        setInnerClassType(ClassType.ANNOTATION);
        setPrefix("Inner {;");
        setSuffix("}");
    }
}
