package com.mall4j.cloud.express.controller.app;

import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.express.dto.ExpressInfoDTO;
import com.mall4j.cloud.express.dto.ExpressRspDTO;
import com.mall4j.cloud.express.dto.ExpressTrackDTO;
import com.mall4j.cloud.express.service.ExpressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 快递
 *
 * @author carterzhang
 */
@RestController
@RequestMapping("p/goodsExpress")
@Api(tags = "app-快递接口")
public class ExpressController {
    @Autowired
    private ExpressService expressService;

    /**
     * 查询物流详情接口
     */
    @PostMapping(value = "根据快递公司code和快递单号查询物流信息")
    @ApiOperation(value="快递详情信息",notes = "根据快递公司code和快递单号查询物流信息")
    public ServerResponseEntity<ExpressInfoDTO> getExpressInfoByCodeAndNo(@RequestBody ExpressTrackDTO expressTrack){
        ExpressInfoDTO result = expressService.getExpressInfoByCodeAndNo(expressTrack);
        return ServerResponseEntity.success(result);
    }

}
