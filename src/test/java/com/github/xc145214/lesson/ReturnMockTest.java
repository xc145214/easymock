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
import org.easymock.IAnswer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * 返回值测试。
 *
 * @author xiachuan at 2017/3/24 14:00。
 */

public class ReturnMockTest {


    /**
     * 返回值mock。
     *
     * @throws Exception
     */
    @Test
    public void testRuntimeReturn() throws Exception {
        ReturnBusiness returnBusiness = new ReturnBusiness();
        ReturnService returnService = EasyMock.createMock(ReturnService.class);

        returnBusiness.setReturnService(returnService);

        EasyMock.expect(returnService.execute(EasyMock.anyInt())).andAnswer(new IAnswer<Integer>() {
            @Override
            public Integer answer() throws Throwable {
                Integer count = (Integer) EasyMock.getCurrentArguments()[0];
                System.out.println(count);
                return count * 2;
            }
        });

        EasyMock.replay(returnService);

        returnBusiness.execute();

        EasyMock.verify(returnService);
    }

    /**
     * Exception mock
     * @throws Exception
     */
    @Test
    public void testRunTimeException() throws Exception {
        ReturnBusiness returnBusiness = new ReturnBusiness();
        ReturnService returnService = EasyMock.createMock(ReturnService.class);
        returnBusiness.setReturnService(returnService);

        EasyMock.expect(returnService.execute(EasyMock.anyInt())).andAnswer(new IAnswer<Integer>() {
            @Override
            public Integer answer() throws Throwable {
                Integer count = (Integer) EasyMock.getCurrentArguments()[0];
                throw new RuntimeException("count=" + count);
            }
        });

        EasyMock.replay(returnService);

        try {
            returnBusiness.execute();
            fail("should throw RuntimeException!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            assertTrue(e.getMessage().indexOf("count=") != -1);

            EasyMock.verify(returnService);
        }


    }

    @Test
    public void testRuntimeReturnStub() throws Exception {
        ReturnBusiness returnBusiness= new ReturnBusiness();
        ReturnService returnService = EasyMock.createMock(ReturnService.class);
        returnBusiness.setReturnService(returnService);
        EasyMock.expect(returnService.execute(EasyMock.anyInt())).andDelegateTo(new ReturnServiceStub());

        EasyMock.replay(returnService);
        returnBusiness.execute();
        EasyMock.verify(returnService);

    }
}

