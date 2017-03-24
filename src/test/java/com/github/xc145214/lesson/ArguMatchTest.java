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

/**
 * 自定义参数匹配测试。
 *
 * @author xiachuan at 2017/3/24 15:52。
 */

public class ArguMatchTest {


    Request prepareRequest(boolean codition, String value1, String value2) {
        Request request = new Request();
        request.setCondition(codition);
        request.setValue1(value1);
        request.setValue2(value2);
        return request;
    }

    @Test
    public void testConditionFailure() throws Exception {
        final boolean expectedCondition = true;
        final String expectedValue = "aaa";

        MatchService matchService = EasyMock.createMock("matchService", MatchService.class);
        Request request = prepareRequest(expectedCondition, "bbb", "ccc");
        matchService.execute(RequestMatcher.requestEquals(expectedCondition, expectedValue));
        EasyMock.expectLastCall();

        EasyMock.replay(matchService);
        matchService.execute(request);
        EasyMock.verify(matchService);

    }
}

