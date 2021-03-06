package cn.ccsu.notify.pojo.po;

import lombok.Data;

import java.util.Date;

/**
 * @author hangs.zhang
 * @date 2018/12/10
 * *****************
 * function:
 */
@Data
public class SystemNotifyPO {

    private Integer notifyId;

    // 0 活动通知 1 招聘通知
    private String systemNotifyType;

    private String message;

    private Date sendTime;

    private String activityName;

    private Integer status;

}
