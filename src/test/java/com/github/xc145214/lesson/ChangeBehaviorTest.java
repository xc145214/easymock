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
import static org.junit.Assert.fail;

/**
 * 行为改变测试。
 *
 * @author xiachuan at 2017/3/24 15:18。
 */

public class ChangeBehaviorTest {

    private interface Service {
        byte voteForRemoval(String name);
    }

    @Test
    public void testExecute() throws Exception {
        final String name = "Document";

        Service mock = EasyMock.createMock("service", Service.class);

        EasyMock.expect(mock.voteForRemoval("Document"))
                .andReturn((byte) 42).times(3)
                .andThrow(new RuntimeException()).times(4)
                .andReturn((byte) -42);

        EasyMock.replay(mock);

        for (int i = 0; i < 3; i++) {
            assertEquals(42, mock.voteForRemoval(name));
        }

        for (int i = 0; i < 4; i++) {
            try {
                mock.voteForRemoval(name);
                fail("should throw RuntimeException");
            } catch (Exception e) {
            }

        }

        assertEquals(-42, mock.voteForRemoval(name));

        EasyMock.verify(mock);
    }
}

