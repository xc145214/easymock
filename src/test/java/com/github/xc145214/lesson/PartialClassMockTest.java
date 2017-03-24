/**
 * **********************************************************************
 * HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 * <p/>
 * COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 * ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 * HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 * ***********************************************************************
 */
package com.github.xc145214.lesson;

import org.easymock.EasyMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * partial class mock test.
 *
 * @author xiachuan at 2017/3/24 13:25。
 */

public class PartialClassMockTest {

    /**
     * 部分 模拟 class
     *
     * @throws Exception
     */
    @Test
    public void testPartialMock() throws Exception {
        PartialService1 partialService1 = EasyMock.createMockBuilder(PartialService1.class)
                .addMockedMethod("needMockMethod")
                .createMock();
        partialService1.needMockMethod();
        EasyMock.expectLastCall();

        EasyMock.replay(partialService1);
        partialService1.execute();

        EasyMock.verify(partialService1);
    }

    /**
     * 部分模式静态方法。
     *
     * @throws Exception
     */
    @Test
    public void testStaticMethod() throws Exception {
        PartialService2 partialService2 = EasyMock.createMockBuilder(PartialService2.class)
                .addMockedMethod("getConfiguration")
                .createMock();

        EasyMock.expect(partialService2.getConfiguration()).andReturn("abc");

        EasyMock.replay(partialService2);
        assertEquals("abc", partialService2.execute2());
        EasyMock.verify(partialService2);

    }

    /**
     * mock toString
     * @throws Exception
     */
    @Test
    public void testToStringMock() throws Exception {
        PartialService1 partialService1 = EasyMock.createMockBuilder(PartialService1.class)
                .addMockedMethod("toString")
                .createMock();
        EasyMock.expect(partialService1.toString()).andReturn("abc");
        EasyMock.replay(partialService1);
        assertEquals("abc", partialService1.execute3());
        EasyMock.verify(partialService1);

    }
}

