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

import java.util.Random;

/**
 *  返回值。
 *
 *  @author xiachuan at 2017/3/24 13:56。
 */

public class ReturnBusiness {

    private ReturnService returnService;

    public void execute(){
        int count = randomInt();
        int result = returnService.execute(count);
    }

    public void setReturnService(ReturnService returnService) {
        this.returnService = returnService;
    }

    private int randomInt(){
        Random random = new Random();
        return random.nextInt()/10000;
    }
}

