package com.lc.pictureoftheday;

import com.lc.pictureoftheday.utils.NetworkUtil;

import junit.framework.Assert;

import org.junit.Test;

public class NetworkUtilTest {

    @Test
    public void isResponseCodeOKTest() {
        Assert.assertEquals(NetworkUtil.isResponseCodeOK(200), true );
        Assert.assertEquals(NetworkUtil.isResponseCodeOK(202), true );
        Assert.assertEquals(NetworkUtil.isResponseCodeOK(400), false );
    }

}
