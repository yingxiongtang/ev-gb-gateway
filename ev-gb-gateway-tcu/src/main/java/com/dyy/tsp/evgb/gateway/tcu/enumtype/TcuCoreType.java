package com.dyy.tsp.evgb.gateway.tcu.enumtype;

import com.dyy.tsp.evgb.gateway.protocol.entity.BeanTime;
import com.dyy.tsp.evgb.gateway.protocol.entity.QueryParamsRequest;
import com.dyy.tsp.evgb.gateway.protocol.entity.SetParamsRequest;
import com.dyy.tsp.evgb.gateway.protocol.entity.TerminalControlRequest;
import com.dyy.tsp.evgb.gateway.tcu.handler.ParamsHandler;
import com.dyy.tsp.evgb.gateway.tcu.handler.ResponseHandler;
import com.dyy.tsp.evgb.gateway.tcu.handler.TerminalControlHandler;
import com.dyy.tsp.netty.common.IStatus;

@SuppressWarnings("all")
public enum TcuCoreType {

    //上行指令
    VEHICLE_LOGIN((short)1, "车辆登入",new BeanTime(), ResponseHandler.class),
    REALTIME_DATA_REPORTING((short)2,"实时信息上报",new BeanTime(), ResponseHandler.class),
    REPLACEMENT_DATA_REPORTING((short)3,"补发信息上报",new BeanTime(), ResponseHandler.class),
    VEHICLE_LOGOUT((short)4,"车辆登出",new BeanTime(),ResponseHandler.class),
    PLATFORM_LOGIN((short)5,"平台登入",new BeanTime(), ResponseHandler.class), //国家过检才用
    PLATFORM_LOGOUT((short)6,"平台登出",new BeanTime(),ResponseHandler.class), //国家过检才用
    HEARTBEAT((short)7,"心跳",null, ResponseHandler.class),
    TERMINAL_CHECK_TIME((short)8,"终端校时",new BeanTime(), ResponseHandler.class),

    //下行指令
    QUERY_COMMAND((short)128,"查询命令",new QueryParamsRequest(), ParamsHandler.class),
    SET_COMMAND((short)129,"设置命令",new SetParamsRequest(),ParamsHandler.class),
    REMOTE_CONTROL((short)130,"车载终端控制命令",new TerminalControlRequest(), TerminalControlHandler.class),
    ;

    private Short id;
    private String desc;
    private IStatus status;
    private Class handler;

    TcuCoreType(Short id, String desc, IStatus status, Class handler) {
        this.id = id;
        this.desc = desc;
        this.status = status;
        this.handler = handler;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public IStatus getStatus() {
        return status;
    }

    public void setStatus(IStatus status) {
        this.status = status;
    }

    public Class getHandler() {
        return handler;
    }

    public void setHandler(Class handler) {
        this.handler = handler;
    }

    public static TcuCoreType valuesOf(Short id) {
        for (TcuCoreType enums : TcuCoreType.values()) {
            if (enums.getId()==id.shortValue()) {
                return enums;
            }
        }
        return null;
    }

}
