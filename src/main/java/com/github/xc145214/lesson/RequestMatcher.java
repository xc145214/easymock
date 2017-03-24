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
import org.easymock.IArgumentMatcher;

/**
 *
 *  @author xiachuan at 2017/3/24 15:48。
 */

public class RequestMatcher implements IArgumentMatcher {

    private boolean condition;

    private String expectedValue;

    public RequestMatcher(boolean condition, String expectedValue) {
        this.condition = condition;
        this.expectedValue = expectedValue;
    }

    @Override
    public boolean matches(Object argument) {
        if (!(argument instanceof Request)) {
            return false;
        }

        Request request = (Request) argument;
        if (condition) {
            return expectedValue.equals(request.getValue1());
        } else {
            return expectedValue.equals(request.getValue2());
        }
    }

    @Override
    public void appendTo(StringBuffer buffer) {
        buffer.append("RequestMatcher expect(condition=");
        buffer.append(condition);
        buffer.append(" expectedValue=");
        buffer.append(expectedValue);
        buffer.append(")");
    }

    public static Request requestEquals(boolean condition, String expectedValue) {
        EasyMock.reportMatcher(new RequestMatcher(condition, expectedValue));
        return null;
    }
}

