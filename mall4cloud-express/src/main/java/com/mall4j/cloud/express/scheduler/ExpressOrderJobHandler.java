package com.mall4j.cloud.express.scheduler;

import com.mall4j.cloud.api.order.constant.OrderStatus;
import com.mall4j.cloud.express.constants.SchedulerJobHandlerType;
import com.mall4j.cloud.express.service.ExpressService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 使用定时任务去更改用户订单的快递状态
 */
@Component
public class ExpressOrderJobHandler extends IJobHandler {
    @Autowired
    ExpressService expressService;

    @Override
    public void execute() throws Exception {
        expressService.doExpressOsSync();
    }
}
