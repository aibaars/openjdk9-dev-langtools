/*
 * Copyright (c) 2003, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * @bug      4802275 4967243 8026567
 * @summary  Make sure param tags are still printed even though they do not
 *           match up with a real parameters.
 *           Make sure inheritDoc cannot be used in an invalid param tag.
 * @author   jamieh
 * @library  ../lib/
 * @build    JavadocTester
 * @build    TestParamTaglet
 * @run main TestParamTaglet
 */

public class TestParamTaglet extends JavadocTester {

    //Javadoc arguments.
    private static final String[] ARGS = new String[] {
        "-d", OUTPUT_DIR, "-sourcepath", SRC_DIR, "pkg"
    };

    //Input for string search tests.
    private static final String[][] TEST = {
        //Regular param tags.
        { "pkg/C.html",
            "<span class=\"paramLabel\">Parameters:</span></dt>\n" +
            "<dd><code>param1</code> - testing 1 2 3.</dd>\n" +
                "<dd><code>param2</code> - testing 1 2 3."
        },
        //Param tags that don't match with any real parameters.
        { "pkg/C.html",
            "<span class=\"paramLabel\">Parameters:</span></dt>\n" +
            "<dd><code><I>p1</I></code> - testing 1 2 3.</dd>\n" +
                "<dd><code><I>p2</I></code> - testing 1 2 3."
        },
        //{@inherit} doc misuse does not cause doclet to throw exception.
        // Param is printed with nothing inherited.
        //XXX: in the future when Configuration is available during doc inheritence,
        //print a warning for this mistake.
        { "pkg/C.html",
            "<code><I>inheritBug</I></code> -"
        },

    };

    /**
     * The entry point of the test.
     * @param args the array of command line arguments.
     */
    public static void main(String[] args) {
        TestParamTaglet tester = new TestParamTaglet();
        tester.run(ARGS, TEST, NO_TEST);
        tester.printSummary();
    }
}
