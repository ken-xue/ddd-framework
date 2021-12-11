//package io.ddd.framework.domain;
//
//import io.ddd.framework.domain.metrics.techinfluence.InfluenceMetric;
//import io.ddd.framework.domain.metrics.techinfluence.SharingMetric;
//import io.ddd.framework.domain.metrics.techinfluence.SharingMetricItem;
//import io.ddd.framework.domain.metrics.techinfluence.SharingScope;
//import User;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Date;
//
///**
// * SharingMetricTest
// *
// * @date 2019-02-26 4:14 PM
// */
//public class SharingMetricTest {
//
//    @Test
//    public void testSharingMetric(){
//        SharingMetric sharingMetric = new SharingMetric(new InfluenceMetric(new User()));
//        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScope.TEAM, new Date(), "sharingLink"));
//        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScope.BU, new Date(), "sharingLink"));
//        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScope.ALIBABA, new Date(), "sharingLink"));
//        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScope.COMMUNITY, new Date(), "sharingLink"));
//
//        Assert.assertEquals(92, sharingMetric.calculateScore(), 0.01);
//    }
//}
